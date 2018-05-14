package com.princetoad.thichtruyen.ViewImpl;

import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.princetoad.thichtruyen.Common.Adapter.AdapterListBook;
import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Presenter.SearchTruyenPresenter;
import com.princetoad.thichtruyen.PresenterImpl.SearchTruyenPresenterImpl;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.SearchTruyenView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity implements SearchTruyenView{
    private SearchTruyenPresenter controller;
    private List<TruyenDTO> truyenDTOList;
    private ListView list_book;
    private AdapterListBook adapter;
    private int pageCount = 1, type = 0, kt = 0;
    private View layoutErr;
    private final static String TAG = SearchActivity.class.getSimpleName();
    private String search = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        truyenDTOList = new ArrayList<>();
        list_book = (ListView) findViewById(R.id.list_search);
        layoutErr = findViewById(R.id.layout_err_main);

        setToolbar("");
        controller = new SearchTruyenPresenterImpl(SearchActivity.this);
        if (truyenDTOList.size() > 0) {
            list_book.setOnScrollListener(onScrollListener());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search_action));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.isEmpty()) {
                    search = newText;
                    controller.getListTruyen(newText);
                }
                return true;
            }
        });

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
                            controller.loadMoreList(search);
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
    public void showLayoutErr() {
        layoutErr.setVisibility(View.VISIBLE);
        list_book.setVisibility(View.GONE);
    }

    @Override
    public void hideLayoutErr() {
        layoutErr.setVisibility(View.GONE);
        list_book.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListBook(List<TruyenDTO> list) {
        if (truyenDTOList.size() > 0){
            truyenDTOList.clear();
        }
        truyenDTOList = list;
        adapter = new AdapterListBook(truyenDTOList, SearchActivity.this);
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
}
