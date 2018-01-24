package com.princetoad.thichtruyen.PresenterImpl;

import android.util.Log;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Common.Domain.TypeDTO;
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
    public void getListType() {
        view.showLoadingDialog("Đang tải dữ liệu");
        service.getListType(new ListDataCallback<TypeDTO>() {
            @Override
            public void onSuccess(List<TypeDTO> data) {
                view.setListType(data);
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
}
