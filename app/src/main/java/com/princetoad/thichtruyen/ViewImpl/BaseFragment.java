package com.princetoad.thichtruyen.ViewImpl;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.BaseView;

/**
 * Created by PRINCE D. TOAD on 3/29/2017.
 */

public abstract class BaseFragment extends Fragment implements BaseView {
    private ProgressDialogImpl pDialog = null;
    private Toolbar toolbar;

    public void showLoadingDialog(String title) {
        pDialog.showLoadingDialog(title);
    }

    public void hideLoadingDialog() {
        pDialog.hideLoadingDialog();
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pDialog = new ProgressDialogImpl(getContext());
//        FacebookServiceImpl.init(this);
//        GoogleServiceImpl.init(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void showMessage(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Thông báo");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public void showMessageCustom(String message) {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_alert);

        TextView message_content = (TextView) dialog.findViewById(R.id.message_content);
        Button btn_message_yes = (Button) dialog.findViewById(R.id.btn_message_yes);

        message_content.setText(message);
        btn_message_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == Constant.GOOGLE.SIGN_IN) {
//            GoogleServiceImpl.onActivityResult(data);
//        } else {
//            FacebookServiceImpl.onActivityResult(requestCode, resultCode, data);
//        }
    }

    protected void setToolbar(View view, String name) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(name);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (getActivity()).finish();
            }
        });
    }


}
