package com.princetoad.thichtruyen.Service;

import com.princetoad.thichtruyen.Common.Domain.CommentDTO;
import com.princetoad.thichtruyen.Common.Domain.ContentDTO;
import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Common.Domain.TypeDTO;
import com.princetoad.thichtruyen.ServiceCallback.DataCallback;
import com.princetoad.thichtruyen.ServiceCallback.InfoCallback;
import com.princetoad.thichtruyen.ServiceCallback.ListDataCallback;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public interface TruyenService {
    public void getTruyenByTheloai(int theloai, int page, ListDataCallback<TruyenDTO> callback);

    public void getContentByTruyen(int idTruyen, int idChap, ListDataCallback<ContentDTO> callback);

    public void getCommentByTruyen(int idTruyen, int page, ListDataCallback<CommentDTO> callback);

    public void getListType(ListDataCallback<TypeDTO> callback);

    public void getListSearchTruyen(String search, int page, ListDataCallback<TruyenDTO> callback);

    public void updateLuotxem(int id, InfoCallback callback);

    public void updateYeuthich(int id, InfoCallback callback);
}
