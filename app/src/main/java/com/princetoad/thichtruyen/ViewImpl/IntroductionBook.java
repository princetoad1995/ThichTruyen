package com.princetoad.thichtruyen.ViewImpl;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

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
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        truyenDTO = new TruyenDTO();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new InfomationFragment(truyenDTO), getResources().getString(R.string.introduction));
        adapter.addFragment(new ChapterFragment(truyenDTO.getSochuong()), getResources().getString(R.string.chapter));
        adapter.addFragment(new CommentFragment(), getResources().getString(R.string.comment));
        viewPager.setAdapter(adapter);
    }
}
