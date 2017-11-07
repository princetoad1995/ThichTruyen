package com.princetoad.thichtruyen.ViewImpl.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.princetoad.thichtruyen.Common.Constant;
import com.princetoad.thichtruyen.Common.Domain.TruyenDTO;
import com.princetoad.thichtruyen.Common.Util;
import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.InfomationView;
import com.princetoad.thichtruyen.ViewImpl.ContentActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by PRINCETOAD on 09/10/2017.
 */

@SuppressLint("ValidFragment")
public class InfomationFragment extends Fragment implements InfomationView{
    private TextView title, author, number_chap, genres, description, countSee, countLike;
    private ImageView img_info;
    private TruyenDTO truyenDTO;
    private Button btnRead;

    public InfomationFragment(TruyenDTO truyenDTO){
        this.truyenDTO = truyenDTO;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.infomation_fragment, container, false);

        init(view);
        control();

        return view;
    }

    private void init(View view){
        title = (TextView) view.findViewById(R.id.title_book_info);
        author = (TextView) view.findViewById(R.id.author_info);
        number_chap = (TextView) view.findViewById(R.id.number_chap_info);
        genres = (TextView) view.findViewById(R.id.genres_info);
        description = (TextView) view.findViewById(R.id.description_info);
        img_info = (ImageView) view.findViewById(R.id.img_info);
        countSee = (TextView) view.findViewById(R.id.count_see_info);
        countLike = (TextView) view.findViewById(R.id.count_like_info);
        btnRead = (Button) view.findViewById(R.id.btn_read);

        title.setText(truyenDTO.getTen());
        author.setText(truyenDTO.getTacgia());
        number_chap.setText(truyenDTO.getSochuong() + "");
        genres.setText(Util.getType(getContext(), truyenDTO));
        description.setText(truyenDTO.getMota());
        Picasso.with(getContext()).load(truyenDTO.getAnhbia()).fit().centerCrop().into(img_info);
        countSee.setText(truyenDTO.getLuotxem() + "");
        countLike.setText(truyenDTO.getYeuthich() + "");
    }

    private void control(){
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ContentActivity.class);
                i.putExtra(Constant.INFO_BOOK.ID_BOOK, truyenDTO.getId());
                i.putExtra(Constant.INFO_BOOK.ID_CHAP, 1);
                i.putExtra(Constant.INFO_BOOK.NUMBER_CHAP, truyenDTO.getSochuong());
                startActivity(i);
            }
        });
    }
}
