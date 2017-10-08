package com.princetoad.thichtruyen.Presenter;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;

import java.util.List;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public interface MainPresenter {
    public void getListTruyen(int type);
    public void loadMoreList();
    public boolean isLoadMore();
    public void resetLoadMore();
}
