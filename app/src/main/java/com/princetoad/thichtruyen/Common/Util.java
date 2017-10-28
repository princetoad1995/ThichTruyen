package com.princetoad.thichtruyen.Common;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.R;

/**
 * Created by PRINCETOAD on 09/10/2017.
 */

public class Util {
    public static String getType(Context context, TruyenDTO truyenDTO) {
        String theloai = "";
        if (truyenDTO.getTheloai() == Constant.TYPE.NGONTINH) {
            theloai = context.getResources().getString(R.string.ngontinh);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.DAMMY) {
            theloai = context.getResources().getString(R.string.dammy);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.DOTHI) {
            theloai = context.getResources().getString(R.string.dothi);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.KIEMHIEP) {
            theloai = context.getResources().getString(R.string.kiemhiep);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.SACHIEP) {
            theloai = context.getResources().getString(R.string.sachiep);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.KINHDI) {
            theloai = context.getResources().getString(R.string.kinhdi);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.NGAN) {
            theloai = context.getResources().getString(R.string.ngan);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.TEEN) {
            theloai = context.getResources().getString(R.string.teen);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.THAMKIN) {
            theloai = context.getResources().getString(R.string.thamkin);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.VOZ) {
            theloai = context.getResources().getString(R.string.voz);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.TRINHTHAM) {
            theloai = context.getResources().getString(R.string.trinhtham);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.XUYENKHONG) {
            theloai = context.getResources().getString(R.string.xuyenkhong);
        }
        return theloai;
    }

    public static void hideKeyboard(@NonNull Activity activity) {
        // Check if no view has focus:
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
