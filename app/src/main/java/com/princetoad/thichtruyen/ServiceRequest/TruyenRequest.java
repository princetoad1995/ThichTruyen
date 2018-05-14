package com.princetoad.thichtruyen.ServiceRequest;

import com.princetoad.thichtruyen.Common.Domain.CommentDTO;
import com.princetoad.thichtruyen.Common.Domain.ContentDTO;
import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Common.Domain.TypeDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public interface TruyenRequest {
    @POST("/listTruyen.php")
    Call<List<TruyenDTO>> getListTruyenById(@Query("theloai") int theloai, @Query("page") int page);

    @POST("/listChap.php")
    Call<List<ContentDTO>> getListContentByTruyen(@Query("idTruyen") int idTruyen, @Query("idChap") int idChap);

    @POST("/listComment.php")
    Call<List<CommentDTO>> getCommetTruyenById(@Query("idTruyen") int idTruyen, @Query("page") int page);

    @POST("/listType.php")
    Call<List<TypeDTO>> getListType();

    @POST("/searchTruyen.php")
    Call<List<TruyenDTO>> getSearchListTruyen(@Query("search") String search, @Query("page") int page);

    @POST("/updateLuotxem.php")
    Call<String> updateLuotxem(@Query("idTruyen") int id);

    @POST("/updateYeuthic.php")
    Call<String> updateYeuthich(@Query("idTruyen") int id);
}
