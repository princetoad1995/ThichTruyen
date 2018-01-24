package com.princetoad.thichtruyen.Common.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.princetoad.thichtruyen.Common.Domain.TypeDTO;
import com.princetoad.thichtruyen.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 1/22/2018.
 */

public class AdapterListType extends BaseAdapter{
    private List<TypeDTO> listType;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterListType(List<TypeDTO> listType, Context context) {
        this.listType = listType;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listType.size();
    }

    @Override
    public Object getItem(int i) {
        return listType.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = layoutInflater.inflate(R.layout.custom_list_type, null);
            holder = new ViewHolder();
            holder.avatar = (ImageView) view.findViewById(R.id.avatar_type);
            holder.ten = (TextView) view.findViewById(R.id.ten_type);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        TypeDTO typeDTO = listType.get(i);
        Picasso.with(context).load(typeDTO.getAvatar()).fit().centerCrop().into(holder.avatar);
        holder.ten.setText(typeDTO.getTen());

        return view;
    }

    static class ViewHolder {
        ImageView avatar;
        TextView ten;
    }
}
