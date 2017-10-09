package com.princetoad.thichtruyen.Common.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.princetoad.thichtruyen.Common.Domain.ContentDTO;
import com.princetoad.thichtruyen.R;

import java.util.List;

/**
 * Created by PRINCETOAD on 09/10/2017.
 */

public class AdapterListChap extends BaseAdapter{
    private Context context;
    private List<Integer> list;

    public AdapterListChap(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView nameChap;
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
        return list.indexOf(getItem(i));
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_list_chap, null);
            holder = new ViewHolder();
            holder.nameChap = (TextView) convertView.findViewById(R.id.name_chap);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Integer stt = (Integer) getItem(i);

        holder.nameChap.setText("Chap " + stt);

        return convertView;
    }
}
