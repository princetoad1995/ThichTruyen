package com.princetoad.thichtruyen.Presenter;

/**
 * Created by PRINCE D. TOAD on 1/22/2018.
 */

public interface ListBookPresenter {
    public void getListTruyen(int type);
    public void loadMoreList();
    public boolean isLoadMore();
    public void resetLoadMore();
}
