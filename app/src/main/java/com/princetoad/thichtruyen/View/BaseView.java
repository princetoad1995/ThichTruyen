package com.princetoad.thichtruyen.View;

/**
 * Created by PRINCE D. TOAD on 3/27/2017.
 */

public interface BaseView {
    public void showMessage(String message);

    public void showMessageCustom(String message);

    public void showLoadingDialog(String message);

    public void hideLoadingDialog();

    public void showToastMessage(String message);
}
