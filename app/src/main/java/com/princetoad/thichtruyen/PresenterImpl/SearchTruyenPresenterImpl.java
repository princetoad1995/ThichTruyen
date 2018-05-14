package com.princetoad.thichtruyen.PresenterImpl;

import android.util.Log;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Presenter.SearchTruyenPresenter;
import com.princetoad.thichtruyen.Service.TruyenService;
import com.princetoad.thichtruyen.ServiceCallback.ListDataCallback;
import com.princetoad.thichtruyen.ServiceImpl.TruyenServiceImpl;
import com.princetoad.thichtruyen.View.SearchTruyenView;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 1/30/2018.
 */

public class SearchTruyenPresenterImpl implements SearchTruyenPresenter{
    private SearchTruyenView view;
    private TruyenService service;
    private boolean mIsLoadMore;

    public SearchTruyenPresenterImpl(SearchTruyenView view) {
        this.view = view;
        service = TruyenServiceImpl.getInstance();
    }

    @Override
    public void getListTruyen(String search) {
        view.showLoadingDialog("Đang tải dữ liệu");
        service.getListSearchTruyen(search, view.getPage(), new ListDataCallback<TruyenDTO>() {
            @Override
            public void onSuccess(List<TruyenDTO> data) {
                Log.e("size", data.size() + "");
                view.setListBook(data);
                view.hideLoadingDialog();
                view.hideLayoutErr();
            }

            @Override
            public void onFail(String error) {
                Log.e("Loi", error);
                view.hideLoadingDialog();
                view.showLayoutErr();
            }
        });
    }

    @Override
    public void loadMoreList(String search) {
        view.showLoadingDialog("Đang tải dữ liệu");
        service.getListSearchTruyen(search, view.getPage(), new ListDataCallback<TruyenDTO>() {
            @Override
            public void onSuccess(List<TruyenDTO> data) {
                Log.e("size", data.size() + "");
                if (data.size() > 0){
                    view.setMoreListBook(data);
                } else {
                    mIsLoadMore = false;
                }
                view.hideLoadingDialog();
            }

            @Override
            public void onFail(String error) {
                Log.e("Loi", error);
                view.hideLoadingDialog();
            }
        });
    }

    @Override
    public boolean isLoadMore() {
        return mIsLoadMore;
    }
}
