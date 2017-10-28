package com.princetoad.thichtruyen.ViewImpl.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.princetoad.thichtruyen.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by PRINCETOAD on 09/10/2017.
 */

public class CommentFragment extends Fragment{
    private SwipeRefreshLayout swipeComment;
    private CircleImageView img_ava;
    private EditText edtComment;
    private ListView recyclerCmt;

    public CommentFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comment_fragment, container, false);
        swipeComment = (SwipeRefreshLayout) view.findViewById(R.id.swipe_comment);
        edtComment = (EditText) view.findViewById(R.id.edt_cmt);
        recyclerCmt = (ListView) view.findViewById(R.id.listview_cmt);

        return view;
    }


}
