package com.princetoad.thichtruyen.View;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;

import java.util.List;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public interface MainView extends BaseView{
    public void setListBook(List<TruyenDTO> list);
    public void setMoreListBook(List<TruyenDTO> list);
    public int getPage();
    public int getType();
}
