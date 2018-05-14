package com.princetoad.thichtruyen.Common.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.ViewImpl.Fragment.ContentChapFragment;

/**
 * Created by PRINCE D. TOAD on 1/28/2018.
 */

public class PageAdapter extends FragmentPagerAdapter {
    private int chapNumber, idTruyen, idChap;
    public PageAdapter(FragmentManager fragmentManager, int chapNumber, int idTruyen, int idChap) {
        super(fragmentManager);
        this.chapNumber = chapNumber;
        this.idChap = idChap;
        this.idTruyen = idTruyen;
    }

    @Override
    public Fragment getItem(int position) {
        final Bundle bundle = new Bundle();
        bundle.putInt(Constant.INFO_BOOK.ID_BOOK, idTruyen);
        bundle.putInt(Constant.INFO_BOOK.ID_CHAP, position+1);

        final ContentChapFragment fragment = new ContentChapFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return chapNumber;
    }

}
