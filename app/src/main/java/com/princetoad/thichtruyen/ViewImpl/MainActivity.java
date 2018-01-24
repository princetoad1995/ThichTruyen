
package com.princetoad.thichtruyen.ViewImpl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.princetoad.thichtruyen.Common.Adapter.AdapterListType;
import com.princetoad.thichtruyen.Common.Domain.TypeDTO;
import com.princetoad.thichtruyen.Presenter.MainPresenter;
import com.princetoad.thichtruyen.PresenterImpl.MainPresenterImpl;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView{

    private MainPresenter controller;
    private GridView gridView;
    private final static String TAG = MainActivity.class.getSimpleName();
    private AdapterListType adapter;
    private View layoutErr;
    private List<TypeDTO> listType;
    private SwipeRefreshLayout mRefesh;
    private int kt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listType = new ArrayList<>();
        gridView = (GridView) findViewById(R.id.gridView);
        layoutErr = findViewById(R.id.layout_err_main);
        controller = new MainPresenterImpl(MainActivity.this);
        controller.getListType();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ListBookActivity.class);
                i.putExtra("idType", listType.get(position).getId());
                i.putExtra("typeName", listType.get(position).getTen());
                startActivity(i);
            }
        });

        refeshActivity();

    }

    private void refeshActivity(){
        mRefesh = (SwipeRefreshLayout) findViewById(R.id.refesh_list_type);
        mRefesh.setColorScheme(android.R.color.holo_orange_light,
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_red_light);

        mRefesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                kt = 1;
                resetPage();
            }
        });

    }

    private void resetPage() {
        listType.clear();
        controller.getListType();
        // refesh list
        if (kt == 1) {
            mRefesh.setRefreshing(false);
            kt = 0;
        }
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
//            resetPage(Constant.TYPE.NGONTINH);
        } else if (id == R.id.teen) {
//            resetPage(Constant.TYPE.TEEN);
        } else if (id == R.id.voz) {
//            resetPage(Constant.TYPE.VOZ);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void showLayoutErr() {
        layoutErr.setVisibility(View.VISIBLE);
        gridView.setVisibility(View.GONE);
    }

    @Override
    public void hideLayoutErr() {
        layoutErr.setVisibility(View.GONE);
        gridView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListType(List<TypeDTO> listType) {
        this.listType = listType;
        adapter = new AdapterListType(listType, MainActivity.this);
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
