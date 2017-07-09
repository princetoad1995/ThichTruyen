package com.princetoad.thichtruyen.ViewImpl;

import android.os.Bundle;
import android.widget.ImageView;

import com.princetoad.thichtruyen.Presenter.MainPresenter;
import com.princetoad.thichtruyen.PresenterImpl.MainPresenterImpl;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.MainView;
import com.squareup.picasso.Picasso;

public class MainActivity extends BaseActivity implements MainView{
    private MainPresenter controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainPresenterImpl(MainActivity.this);
        controller.getListTruyen();
    }

    @Override
    public void setUrl(String url) {
        ImageView img = (ImageView) findViewById(R.id.img);
        Picasso.with(this).load(url).into(img);
    }
}
