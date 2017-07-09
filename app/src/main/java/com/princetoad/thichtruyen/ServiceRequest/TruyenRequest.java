package com.princetoad.thichtruyen.ServiceRequest;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public interface TruyenRequest {
    @POST("/listTruyen.php?theloai=")
    Call<List<TruyenDTO>> getListTruyenById(@Query("theloai") int theloai);
}
