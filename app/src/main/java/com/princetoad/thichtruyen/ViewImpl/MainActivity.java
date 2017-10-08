
package com.princetoad.thichtruyen.ViewImpl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.princetoad.thichtruyen.Common.Adapter.CustomListBook;
import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Presenter.MainPresenter;
import com.princetoad.thichtruyen.PresenterImpl.MainPresenterImpl;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.MainView;

import java.util.List;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    private MainPresenter controller;
    private List<TruyenDTO> truyenDTOList;
    private ListView list_book;
    private CustomListBook adapter;
    private final static String TAG = MainActivity.class.getSimpleName();
    private int pageCount = 1, type = Constant.TYPE.NGONTINH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list_book = (ListView) findViewById(R.id.list_book);
        controller = new MainPresenterImpl(MainActivity.this);
        controller.getListTruyen(type);
        list_book.setOnScrollListener(onScrollListener());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ngontinh) {
            resetPage(Constant.TYPE.NGONTINH);
            controller.getListTruyen(type);

        } else if (id == R.id.teen) {
            resetPage(Constant.TYPE.TEEN);
            controller.getListTruyen(type);
        } else if (id == R.id.voz) {
            resetPage(Constant.TYPE.VOZ);
            controller.getListTruyen(type);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private AbsListView.OnScrollListener onScrollListener() {
        return new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                int threshold = 1;
                int count = list_book.getCount();

                if (scrollState == SCROLL_STATE_IDLE) {
                    if (list_book.getLastVisiblePosition() >= count - threshold) {
                        Log.e(TAG, "loading more data");
                        // Execute LoadMoreDataTask AsyncTask
                        if (controller.isLoadMore()) {
                            pageCount++;
                            controller.loadMoreList();
                        }
                    }
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        };
    }

    @Override
    public void setListBook(List<TruyenDTO> list) {
        truyenDTOList = list;
        adapter = new CustomListBook(list, MainActivity.this);
        list_book.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setMoreListBook(List<TruyenDTO> list) {
        truyenDTOList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public int getPage() {
        return pageCount;
    }

    @Override
    public int getType() {
        return type;
    }

    private void resetPage(int type){
        pageCount = 1;
        controller.resetLoadMore();
        truyenDTOList.clear();
        this.type = type;
    }
}
