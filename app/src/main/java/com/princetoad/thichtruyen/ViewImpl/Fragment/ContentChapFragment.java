package com.princetoad.thichtruyen.ViewImpl.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.Common.Domain.ContentDTO;
import com.princetoad.thichtruyen.Presenter.ContentPresenter;
import com.princetoad.thichtruyen.PresenterImpl.ContentPresenterImpl;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.ContentView;
import com.princetoad.thichtruyen.ViewImpl.BaseFragment;

/**
 * Created by PRINCE D. TOAD on 1/28/2018.
 */

public class ContentChapFragment extends BaseFragment implements ContentView{
    private TextView nameContentChap, contentChap;
    private int idTruyen, idChap;
    private ContentPresenter controller;
    private View layoutErr;
    private ScrollView scrollViewContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_chap, container, false);
        nameContentChap = (TextView) view.findViewById(R.id.content_name_chap);
        contentChap = (TextView) view.findViewById(R.id.content);
        layoutErr = view.findViewById(R.id.layout_err_content);
        scrollViewContent = (ScrollView) view.findViewById(R.id.scrollViewContent);

        idTruyen = getArguments().getInt(Constant.INFO_BOOK.ID_BOOK);
        idChap = getArguments().getInt(Constant.INFO_BOOK.ID_CHAP);

        controller = new ContentPresenterImpl(ContentChapFragment.this);
        controller.getContent();

        return view;
    }

    @Override
    public void setContent(ContentDTO content) {
        if (content.getTenChap() == null){
            nameContentChap.setVisibility(View.GONE);
        }
        nameContentChap.setText(content.getTenChap());
        contentChap.setText(content.getContent());
    }

    @Override
    public int getTruyenId() {
        return idTruyen;
    }

    @Override
    public int getChapId() {
        return idChap;
    }

    @Override
    public void showLayoutErr() {
        layoutErr.setVisibility(View.VISIBLE);
        scrollViewContent.setVisibility(View.GONE);
    }

    @Override
    public void hideLayoutErr() {
        layoutErr.setVisibility(View.GONE);
        scrollViewContent.setVisibility(View.VISIBLE);
    }
}
