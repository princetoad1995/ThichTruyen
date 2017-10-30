package com.princetoad.thichtruyen.View;

import com.princetoad.thichtruyen.Common.Domain.ContentDTO;

/**
 * Created by PRINCE D. TOAD on 10/30/2017.
 */

public interface ContentView extends BaseView{
    public void setContent(ContentDTO content);
    public int getTruyenId();
    public int getChapId();
}
