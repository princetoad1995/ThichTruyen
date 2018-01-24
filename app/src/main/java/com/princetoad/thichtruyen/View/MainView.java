package com.princetoad.thichtruyen.View;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Common.Domain.TypeDTO;

import java.util.List;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public interface MainView extends BaseView{
    public void setListType(List<TypeDTO> listType);
}
