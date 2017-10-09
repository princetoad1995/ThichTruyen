package com.princetoad.thichtruyen.ViewImpl.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.princetoad.thichtruyen.Common.Adapter.AdapterListChap;
import com.princetoad.thichtruyen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCETOAD on 09/10/2017.
 */

public class ChapterFragment extends Fragment{
    private int mListSize;
    private ListView listChap;
    private AdapterListChap adapter;
    private List<Integer> list;

    public ChapterFragment(int listSize){
        mListSize = listSize;
        list = new ArrayList<>();

        for (int i = 1; i <= mListSize; i++){
            list.add(i);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chapter_fragment, container, false);
        listChap = (ListView) view.findViewById(R.id.list_chap);
        adapter = new AdapterListChap(getContext(), list);
        listChap.setAdapter(adapter);
        return view;
    }
}
