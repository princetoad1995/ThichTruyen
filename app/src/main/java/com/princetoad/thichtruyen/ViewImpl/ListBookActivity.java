package com.princetoad.thichtruyen.ViewImpl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.princetoad.thichtruyen.Common.Adapter.AdapterListBook;
import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Presenter.ListBookPresenter;
import com.princetoad.thichtruyen.PresenterImpl.ListBookPresenterImpl;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.ListBookView;

import java.util.ArrayList;
import java.util.List;

public class ListBookActivity extends BaseActivity implements ListBookView {
    private List<TruyenDTO> truyenDTOList;
    private ListView list_book;
    private AdapterListBook adapter;
    private ListBookPresenter controller;
    private int pageCount = 1, type = 0, kt = 0;
    private SwipeRefreshLayout mRefeshTruyen;
    private View layoutErr;
    private final static String TAG = ListBookActivity.class.getSimpleName();
    private String typeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);

        truyenDTOList = new ArrayList<>();
        list_book = (ListView) findViewById(R.id.list_book);
        layoutErr = findViewById(R.id.layout_err_main);
        mRefeshTruyen = (SwipeRefreshLayout) findViewById(R.id.refesh_list_truyen);
        mRefeshTruyen.setColorScheme(android.R.color.holo_orange_light,
                android.R.color.holo_blue_light,
                android.R.color.holo_green_light,
                android.R.color.holo_red_light);

        Intent i = getIntent();
        type = (int) i.getSerializableExtra("idType");
        typeName = (String) i.getSerializableExtra("typeName");

        setToolbar(typeName);

        controller = new ListBookPresenterImpl(ListBookActivity.this);
        controller.getListTruyen(type);
        control();
        list_book.setOnScrollListener(onScrollListener());
        mRefeshTruyen.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                kt = 1;
                resetPage(type);
            }
        });
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

    private void control() {
        list_book.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(ListBookActivity.this, IntroductionBook.class);
                i.putExtra(Constant.BOOK, truyenDTOList.get(position));
                startActivity(i);
            }
        });
    }

    // set listview fist
    @Override
    public void setListBook(List<TruyenDTO> list) {
        truyenDTOList = list;
        adapter = new AdapterListBook(list, ListBookActivity.this);
        list_book.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    // load more listview
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

    // resetPage when user choose new type or refesh list
    private void resetPage(int type) {
        this.type = type;
        pageCount = 1;
        controller.resetLoadMore();
        truyenDTOList.clear();
        controller.getListTruyen(type);
        // refesh list
        if (kt == 1) {
            mRefeshTruyen.setRefreshing(false);
            kt = 0;
        }
    }

    @Override
    public void showLayoutErr() {
        layoutErr.setVisibility(View.VISIBLE);
        mRefeshTruyen.setVisibility(View.GONE);
    }

    @Override
    public void hideLayoutErr() {
        layoutErr.setVisibility(View.GONE);
        mRefeshTruyen.setVisibility(View.VISIBLE);
    }
}
