package com.princetoad.thichtruyen.PresenterImpl;

import android.util.Log;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Presenter.ListBookPresenter;
import com.princetoad.thichtruyen.Service.TruyenService;
import com.princetoad.thichtruyen.ServiceCallback.ListDataCallback;
import com.princetoad.thichtruyen.ServiceImpl.TruyenServiceImpl;
import com.princetoad.thichtruyen.View.ListBookView;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 1/22/2018.
 */

public class ListBookPresenterImpl implements ListBookPresenter {
    private ListBookView view;
    private TruyenService service;
    private boolean mIsLoadMore;

    public ListBookPresenterImpl(ListBookView view) {
        this.view = view;
        service = TruyenServiceImpl.getInstance();
        mIsLoadMore = true;
    }

    @Override
    public void getListTruyen(int type) {
        view.showLoadingDialog("Đang tải dữ liệu");
        service.getTruyenByTheloai(type, view.getPage(), new ListDataCallback<TruyenDTO>() {
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
    public void loadMoreList() {
        view.showLoadingDialog("Đang tải dữ liệu");
        Log.d("type", view.getType() + "");
        service.getTruyenByTheloai(view.getType(), view.getPage(), new ListDataCallback<TruyenDTO>() {
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

    @Override
    public void resetLoadMore() {
        mIsLoadMore = true;
    }
}
