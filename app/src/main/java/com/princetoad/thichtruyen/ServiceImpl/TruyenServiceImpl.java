package com.princetoad.thichtruyen.ServiceImpl;

import android.util.Log;

import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.Common.Domain.ContentDTO;
import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Common.RetrofitRequest;
import com.princetoad.thichtruyen.Service.TruyenService;
import com.princetoad.thichtruyen.ServiceCallback.DataCallback;
import com.princetoad.thichtruyen.ServiceCallback.ListDataCallback;
import com.princetoad.thichtruyen.ServiceRequest.TruyenRequest;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public class TruyenServiceImpl implements TruyenService{
    private static TruyenRequest request;
    private static TruyenService instance;

    public TruyenServiceImpl() {
        request = RetrofitRequest.getInstance().getRetrofit().create(TruyenRequest.class);
    }

    public static TruyenService getInstance() {
        if (instance == null)
            instance = new TruyenServiceImpl();
        return instance;
    }

    @Override
    public void getTruyenByTheloai(int theloai, int page, final ListDataCallback<TruyenDTO> callback) {
        request.getListTruyenById(theloai, page).enqueue(new Callback<List<TruyenDTO>>() {
            @Override
            public void onResponse(Call<List<TruyenDTO>> call, Response<List<TruyenDTO>> response) {
                if (response.isSuccessful()){
                    callback.onSuccess(response.body());
                } else {
                    try {
                        callback.onFail("Có lỗi xảy ra !");
                        Log.e("error", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<TruyenDTO>> call, Throwable t) {
                callback.onFail(Constant.ERROR.CONNECT_ERROR);
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getContentByTruyen(int idTruyen, int idChap, final DataCallback<ContentDTO> callback) {
        request.getListContentByTruyen(idTruyen, idChap).enqueue(new Callback<ContentDTO>() {
            @Override
            public void onResponse(Call<ContentDTO> call, Response<ContentDTO> response) {
                if (response.isSuccessful()){
                    callback.onSuccess(response.body());
                } else {
                    try {
                        callback.onFail("Có lỗi xảy ra !");
                        Log.e("error", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ContentDTO> call, Throwable t) {
                callback.onFail(Constant.ERROR.CONNECT_ERROR);
                t.printStackTrace();
            }
        });
    }
}
