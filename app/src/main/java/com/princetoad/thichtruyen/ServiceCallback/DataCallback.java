package com.princetoad.thichtruyen.ServiceCallback;

import com.princetoad.thichtruyen.Common.Domain.BaseDTO;

/**
 * Created by PRINCE D. TOAD on 3/16/2017.
 */

public interface DataCallback<T extends BaseDTO> {
    public void onSuccess(T data);

    public void onFail(String error);
}
