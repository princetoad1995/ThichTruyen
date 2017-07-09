package com.princetoad.thichtruyen.PresenterImpl;

import android.util.Log;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Presenter.MainPresenter;
import com.princetoad.thichtruyen.Service.TruyenService;
import com.princetoad.thichtruyen.ServiceCallback.ListDataCallback;
import com.princetoad.thichtruyen.ServiceImpl.TruyenServiceImpl;
import com.princetoad.thichtruyen.View.MainView;

import java.util.List;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public class MainPresenterImpl implements MainPresenter{
    private MainView view;
    private TruyenService service;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        service = TruyenServiceImpl.getInstance();
    }

    @Override
    public void getListTruyen() {
        view.showLoadingDialog("Đang tải dữ liệu");
        service.getTruyenByTheloai(1, new ListDataCallback<TruyenDTO>() {
            @Override
            public void onSuccess(List<TruyenDTO> data) {
                Log.e("size", data.size() + "");
                view.setUrl(data.get(1).getAnhbia());
                view.hideLoadingDialog();
            }

            @Override
            public void onFail(String error) {
                Log.e("Loi", error);
            }
        });
    }

}
