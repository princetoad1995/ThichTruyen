package com.princetoad.thichtruyen.ViewImpl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.princetoad.thichtruyen.Common.Adapter.PageAdapter;
import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.Common.Domain.ContentDTO;
import com.princetoad.thichtruyen.Common.ZoomOutPageTransformer;
import com.princetoad.thichtruyen.Presenter.ContentPresenter;
import com.princetoad.thichtruyen.PresenterImpl.ContentPresenterImpl;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.ContentView;

public class ContentActivity extends BaseActivity {
    private int idBook, idChap, numberChap;
    private ViewPager mPager;
    private PageAdapter mAdapter;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent i = getIntent();
        idBook = (int) i.getSerializableExtra(Constant.INFO_BOOK.ID_BOOK);
        idChap = (int) i.getSerializableExtra(Constant.INFO_BOOK.ID_CHAP);
        numberChap = (int) i.getSerializableExtra(Constant.INFO_BOOK.NUMBER_CHAP);

        setToolbar("CHAP " + idChap);

        int selectedPage = 1;
        if (idChap > 1){
            selectedPage = idChap;
        }
        mAdapter = new PageAdapter(getSupportFragmentManager(), numberChap, idBook, selectedPage);

        mPager = (ViewPager) findViewById(R.id.container);
        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(selectedPage-1);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setToolbar("CHAP " + (position + 1));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void showLayoutErr() {

    }

    @Override
    public void hideLayoutErr() {

    }
}
