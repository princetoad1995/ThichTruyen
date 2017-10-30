package com.princetoad.thichtruyen.ViewImpl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.Common.Domain.ContentDTO;
import com.princetoad.thichtruyen.Presenter.ContentPresenter;
import com.princetoad.thichtruyen.PresenterImpl.ContentPresenterImpl;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.ContentView;

public class ContentActivity extends BaseActivity implements ContentView{
    private int idBook, idChap;
    private TextView contentId;
    private ContentPresenter controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        contentId = (TextView) findViewById(R.id.content_id);

        Intent i = getIntent();
        idBook = (int) i.getSerializableExtra(Constant.INFO_BOOK.ID_BOOK);
        idChap = (int) i.getSerializableExtra(Constant.INFO_BOOK.ID_CHAP);

        controller = new ContentPresenterImpl(ContentActivity.this);
        controller.getContent();
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
