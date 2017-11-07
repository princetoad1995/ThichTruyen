package com.princetoad.thichtruyen.ViewImpl.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.princetoad.thichtruyen.Common.Adapter.AdapterListChap;
import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.Common.Util;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.ViewImpl.ContentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCETOAD on 09/10/2017.
 */

@SuppressLint("ValidFragment")
public class ChapterFragment extends Fragment{
    private int mListSize, mIdTruyen;
    private ListView listChap;
    private AdapterListChap adapter;
    private List<Integer> list;

    @SuppressLint("ValidFragment")
    public ChapterFragment(int listSize, int idTruyen){
        mListSize = listSize;
        mIdTruyen = idTruyen;
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

        listChap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getContext(), ContentActivity.class);
                i.putExtra(Constant.INFO_BOOK.ID_BOOK, mIdTruyen);
                i.putExtra(Constant.INFO_BOOK.ID_CHAP, position + 1);
                i.putExtra(Constant.INFO_BOOK.NUMBER_CHAP, mListSize);
                startActivity(i);
            }
        });

        return view;
    }
}
