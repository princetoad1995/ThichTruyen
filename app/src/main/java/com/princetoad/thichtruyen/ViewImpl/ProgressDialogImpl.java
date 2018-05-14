package com.princetoad.thichtruyen.ViewImpl;

import android.app.ProgressDialog;
import android.content.Context;

import com.princetoad.thichtruyen.R;

/**
 * Created by PRINCE D. TOAD on 4/11/2017.
 */

public class ProgressDialogImpl {
    private ProgressDialog pDialog = null;

    public ProgressDialogImpl(Context context) {
        this.pDialog = new ProgressDialog(context);
    }

    public void showLoadingDialog(String message) {
        pDialog.setMessage(message);
        pDialog.show();
        pDialog.setCancelable(false);
    }

    public void hideLoadingDialog() {
        if (pDialog != null) {
            pDialog.hide();
            pDialog.cancel();
        }
    }
}
