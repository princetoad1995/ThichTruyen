package com.princetoad.thichtruyen.PresenterImpl;

import android.util.Log;

import com.princetoad.thichtruyen.Common.Domain.ContentDTO;
import com.princetoad.thichtruyen.Presenter.ContentPresenter;
import com.princetoad.thichtruyen.Service.TruyenService;
import com.princetoad.thichtruyen.ServiceCallback.DataCallback;
import com.princetoad.thichtruyen.ServiceCallback.ListDataCallback;
import com.princetoad.thichtruyen.ServiceImpl.TruyenServiceImpl;
import com.princetoad.thichtruyen.View.ContentView;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 10/30/2017.
 */

public class ContentPresenterImpl implements ContentPresenter {
    private ContentView view;
    private TruyenService service;

    public ContentPresenterImpl(ContentView view) {
        this.view = view;
        service = TruyenServiceImpl.getInstance();
    }


    @Override
    public void getContent() {
        view.showLoadingDialog("Đang tải dữ liệu");
        service.getContentByTruyen(view.getTruyenId(), view.getChapId(), new ListDataCallback<ContentDTO>() {
            @Override
            public void onSuccess(List<ContentDTO> data) {
                view.setContent(data.get(0));
                view.hideLoadingDialog();
            }

            @Override
            public void onFail(String error) {
                view.showMessage(error);
                view.hideLoadingDialog();
            }
        });
    }
}
