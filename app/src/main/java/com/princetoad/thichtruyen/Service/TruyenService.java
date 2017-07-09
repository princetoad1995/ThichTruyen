package com.princetoad.thichtruyen.Service;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.ServiceCallback.ListDataCallback;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public interface TruyenService {
    public void getTruyenByTheloai(int theloai, ListDataCallback<TruyenDTO> callback);
}
