package com.princetoad.thichtruyen.ViewImpl;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.princetoad.thichtruyen.R;
import com.princetoad.thichtruyen.View.BaseView;

/**
 * Created by PRINCE D. TOAD on 3/29/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pDialog = new ProgressDialogImpl(this);
//        FacebookServiceImpl.init(this);
//        GoogleServiceImpl.init(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public void showMessage(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
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
        final Dialog dialog = new Dialog(this);
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

    protected void setToolbar(String name) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
