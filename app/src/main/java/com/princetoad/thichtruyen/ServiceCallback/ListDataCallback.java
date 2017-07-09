package com.princetoad.thichtruyen.ServiceCallback;

import com.princetoad.thichtruyen.Common.Domain.BaseDTO;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 3/16/2017.
 */

public interface ListDataCallback<T extends BaseDTO> {
    public void onSuccess(List<T> data);

    public void onFail(String error);
}