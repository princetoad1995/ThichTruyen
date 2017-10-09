package com.princetoad.thichtruyen.Common;

import android.content.Context;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.R;

/**
 * Created by PRINCETOAD on 09/10/2017.
 */

public class TypeUtil {
    public static String getType(Context context, TruyenDTO truyenDTO){
        String theloai = "";
        if (truyenDTO.getTheloai() == Constant.TYPE.NGONTINH){
            theloai = context.getResources().getString(R.string.ngontinh);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.DAMMY){
            theloai = context.getResources().getString(R.string.dammy);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.DOTHI){
            theloai = context.getResources().getString(R.string.dothi);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.KIEMHIEP){
            theloai = context.getResources().getString(R.string.kiemhiep);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.SACHIEP){
            theloai = context.getResources().getString(R.string.sachiep);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.KINHDI){
            theloai = context.getResources().getString(R.string.kinhdi);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.NGAN){
            theloai = context.getResources().getString(R.string.ngan);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.TEEN){
            theloai = context.getResources().getString(R.string.teen);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.THAMKIN){
            theloai = context.getResources().getString(R.string.thamkin);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.VOZ){
            theloai = context.getResources().getString(R.string.voz);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.TRINHTHAM){
            theloai = context.getResources().getString(R.string.trinhtham);
        } else if (truyenDTO.getTheloai() == Constant.TYPE.XUYENKHONG){
            theloai = context.getResources().getString(R.string.xuyenkhong);
        }
        return theloai;
    }
}
