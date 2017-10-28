package com.princetoad.thichtruyen.Common.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class AdapterListBook extends BaseAdapter {
    private List<TruyenDTO> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterListBook(List<TruyenDTO> list, Context context) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    private class ViewHolder{
        ImageView avatar_book;
        TextView name_book;
        TextView author_book;
        TextView like_book;
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
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null){
            view = layoutInflater.inflate(R.layout.custom_list_book, null);
            holder = new ViewHolder();
            holder.avatar_book = (ImageView) view.findViewById(R.id.avatar_book);
            holder.name_book = (TextView) view.findViewById(R.id.name_book);
            holder.author_book = (TextView) view.findViewById(R.id.author_book);
            holder.like_book = (TextView) view.findViewById(R.id.like_book);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // fix issue list = 0
        if (list.size() > 0) {
            TruyenDTO truyenDTO = list.get(i);
            Log.d("list size", list.size() + "");
            Picasso.with(context).load(truyenDTO.getAnhbia()).fit().centerCrop().into(holder.avatar_book);
            holder.name_book.setText(truyenDTO.getTen());
            holder.author_book.setText("Tác giả : " + truyenDTO.getTacgia());
            holder.like_book.setText("Like : " + truyenDTO.getYeuthich() + "| Lượt xem : " + truyenDTO.getLuotxem());
        }

        return view;
    }
}
