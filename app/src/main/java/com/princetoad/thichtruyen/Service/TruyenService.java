package com.princetoad.thichtruyen.Service;

import com.princetoad.thichtruyen.Common.Domain.ContentDTO;
import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.ServiceCallback.DataCallback;
import com.princetoad.thichtruyen.ServiceCallback.ListDataCallback;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public interface TruyenService {
    public void getTruyenByTheloai(int theloai, int page, ListDataCallback<TruyenDTO> callback);
    public void getContentByTruyen(int idTruyen, int idChap, DataCallback<ContentDTO> callback);
}
