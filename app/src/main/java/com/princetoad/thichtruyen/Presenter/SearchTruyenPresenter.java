package com.princetoad.thichtruyen.Presenter;

/**
 * Created by PRINCE D. TOAD on 1/29/2018.
 */

public interface SearchTruyenPresenter {
    public void getListTruyen(String search);
    public void loadMoreList(String search);
    public boolean isLoadMore();
}
