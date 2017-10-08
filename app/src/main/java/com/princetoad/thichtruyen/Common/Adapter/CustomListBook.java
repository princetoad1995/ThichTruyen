package com.princetoad.thichtruyen.Common.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by PRINCETOAD on 10/07/2017.
 */

public class CustomListBook extends BaseAdapter {
    private List<TruyenDTO> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomListBook(List<TruyenDTO> list, Context context) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.custom_list_book, null);
        ImageView avatar_book = (ImageView) view.findViewById(R.id.avatar_book);
        TextView name_book = (TextView) view.findViewById(R.id.name_book);
        TextView author_book = (TextView) view.findViewById(R.id.author_book);
        TextView like_book = (TextView) view.findViewById(R.id.like_book);

        // fix issue list = 0
        if (list.size() > 0) {
            TruyenDTO truyenDTO = list.get(i);

            Picasso.with(context).load(truyenDTO.getAnhbia()).into(avatar_book);
            name_book.setText(truyenDTO.getTen());
            author_book.setText("Tác giả : " + truyenDTO.getTacgia());
            like_book.setText("Số lượt thích : " + truyenDTO.getYeuthich());
        }

        return view;
    }
}
