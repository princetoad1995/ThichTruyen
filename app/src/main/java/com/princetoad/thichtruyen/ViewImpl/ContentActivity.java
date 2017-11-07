package com.princetoad.thichtruyen.ViewImpl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.Common.Domain.ContentDTO;
import com.princetoad.thichtruyen.Presenter.ContentPresenter;
import com.princetoad.thichtruyen.PresenterImpl.ContentPresenterImpl;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.ContentView;

public class ContentActivity extends BaseActivity implements ContentView{
    private int idBook, idChap, numberChap;
    private TextView contentId;
    private ContentPresenter controller;
    private GestureDetector gestureDetector;
    private ScrollView scrollViewContent;
    private final int SWIPE_THRESHOLD = 30, SWIPE_VELOCTITY_THRESHOLD = 10;
    private Toolbar toolbarContent;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        contentId = (TextView) findViewById(R.id.content_id);
        scrollViewContent = (ScrollView) findViewById(R.id.scrollViewContent);
        toolbarContent = (Toolbar) findViewById(R.id.toolbar_content);
//        toolbarContent.setTitleTextColor(getResources().getColor(R.color.colorWhile));

        Intent i = getIntent();
        idBook = (int) i.getSerializableExtra(Constant.INFO_BOOK.ID_BOOK);
        idChap = (int) i.getSerializableExtra(Constant.INFO_BOOK.ID_CHAP);
        numberChap = (int) i.getSerializableExtra(Constant.INFO_BOOK.NUMBER_CHAP);

        toolbarContent.setTitle("CHAP " + idChap);
        setSupportActionBar(toolbarContent);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbarContent.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        controller = new ContentPresenterImpl(ContentActivity.this);
        controller.getContent();

        gestureDetector = new GestureDetector(ContentActivity.this, new MyGesture());
        contentId.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    class MyGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // Keo tu trai sang phai
            if (e2.getX() - e1.getX() > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCTITY_THRESHOLD){
                if(idChap > 1){
                    idChap--;
                    controller.getContent();
                }
            }
            // Keo tu phai sang trai
            if (e1.getX() - e2.getX() > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCTITY_THRESHOLD){
                if(idChap < numberChap){
                    idChap++;
                    controller.getContent();
                }
            }
            toolbarContent.setTitle("CHAP " + idChap);
            scrollViewContent.smoothScrollTo(0,0);
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    public void setContent(ContentDTO content) {
        contentId.setText(content.getContent());
    }

    @Override
    public int getTruyenId() {
        return idBook;
    }

    @Override
    public int getChapId() {
        return idChap;
    }
}
