package com.princetoad.thichtruyen.PresenterImpl;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Presenter.InfomationPresenter;
import com.princetoad.thichtruyen.Service.TruyenService;
import com.princetoad.thichtruyen.ServiceImpl.TruyenServiceImpl;
import com.princetoad.thichtruyen.View.InfomationView;

/**
 * Created by PRINCETOAD on 09/10/2017.
 */

public class InfomationPresenterImpl implements InfomationPresenter {
    private InfomationView view;
    private TruyenService service;

    public InfomationPresenterImpl(InfomationView view) {
        this.view = view;
        service = TruyenServiceImpl.getInstance();
    }

    @Override
    public TruyenDTO getTruyen() {
        return null;
    }
}
