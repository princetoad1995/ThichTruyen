package com.princetoad.thichtruyen.ViewImpl;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.princetoad.thichtruyen.Common.Adapter.ViewPagerAdapter;
import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.ViewImpl.Fragment.ChapterFragment;
import com.princetoad.thichtruyen.ViewImpl.Fragment.CommentFragment;
import com.princetoad.thichtruyen.ViewImpl.Fragment.InfomationFragment;

public class IntroductionBook extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TruyenDTO truyenDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_book);

        Intent i = getIntent();
        truyenDTO = (TruyenDTO) i.getSerializableExtra(Constant.BOOK);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(truyenDTO.getTen());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //This method will be invoked when the current page is scrolled,
                //either as part of a programmatically initiated smooth scroll
                //or a user initiated touch scroll.

                hideKeyboard();
            }

            @Override
            public void onPageSelected(int position) {
                //This method will be invoked when a new page becomes selected.
                //hide keyboard when any fragment of this class has been detached
                hideKeyboard();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //Called when the scroll state changes.
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        truyenDTO = new TruyenDTO();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new InfomationFragment(truyenDTO), getResources().getString(R.string.introduction));
        adapter.addFragment(new ChapterFragment(truyenDTO.getSochuong(), truyenDTO.getId()), getResources().getString(R.string.chapter));
        adapter.addFragment(new CommentFragment(), getResources().getString(R.string.comment));
        viewPager.setAdapter(adapter);
    }

    public  void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
