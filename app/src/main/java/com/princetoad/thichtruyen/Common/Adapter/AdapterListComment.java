package com.princetoad.thichtruyen.Common.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.princetoad.thichtruyen.Common.Domain.CommentDTO;
import com.princetoad.thichtruyen.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by PRINCETOAD on 13/10/2017.
 */

public class AdapterListComment extends BaseAdapter{
    private Context context;
    private List<CommentDTO> list;

    public AdapterListComment(Context context, List<CommentDTO> list) {
        this.context = context;
        this.list = list;
    }

    private class ViewHolder{
        CircleImageView cus_ava_cmt;
        TextView cus_name_cmt, cus_comment;
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
            view = mInflater.inflate(R.layout.custom_list_comment, null);
            holder = new ViewHolder();
            holder.cus_ava_cmt = (CircleImageView) view.findViewById(R.id.cus_ava_cmt);
            holder.cus_name_cmt = (TextView) view.findViewById(R.id.cus_name_cmt);
            holder.cus_comment = (TextView) view.findViewById(R.id.cus_comment);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        CommentDTO commentDTO = (CommentDTO) getItem(i);
//        Picasso.with(context).load()
        holder.cus_name_cmt.setText(commentDTO.getUserDTO().getUsername());
        holder.cus_comment.setText(commentDTO.getContent());

        return view;
    }
}
