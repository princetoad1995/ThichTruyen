package com.princetoad.thichtruyen.ViewImpl.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.princetoad.thichtruyen.R;

/**
 * Created by PRINCETOAD on 09/10/2017.
 */

public class CommentFragment extends Fragment{

    public CommentFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.comment_fragment, container, false);
    }
}
