package com.princetoad.thichtruyen.View;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 1/22/2018.
 */

public interface ListBookView extends BaseView{
    public void setListBook(List<TruyenDTO> list);
    public void setMoreListBook(List<TruyenDTO> list);
    public int getPage();
    public int getType();
}
