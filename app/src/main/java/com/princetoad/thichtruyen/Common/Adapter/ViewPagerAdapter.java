package com.princetoad.thichtruyen.Common.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCETOAD on 09/10/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> mFragmentList;
    private List<String> mFragmentTitleList;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
        mFragmentTitleList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
