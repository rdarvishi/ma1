package com.example.ma1;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

    }

    public void showProgressDialog(View view) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("task");
        progressDialog.setMessage("pleas wait");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //  progressDialog.setProgress(0);
        progressDialog.show();


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            // process simulation
//            public void run() {
//                progressDialog.dismiss();
//
//            }
//        }, 3000l);


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progressDialog == null)
                    return;
                if (progressDialog.getProgress() < progressDialog.getMax()) {
                    progressDialog.incrementProgressBy(1);
                } else {
                    progressDialog.dismiss();
                }

            }
        }, 0, 100);


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (progressDialog == null)
                    return;
                if (progressDialog.getSecondaryProgress() < progressDialog.getMax()) {
                    progressDialog.incrementSecondaryProgressBy(1);
                }
            }
        }, 0, 70);

    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // type 1
//        builder.setTitle("Alert dialog")
//                .setMessage("do you want to delet file ")
//                .setCancelable(false).setIcon(R.drawable.yellow)
//                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(DialogActivity.this,"file deleted",Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setNegativeButton("NO",null)
//                .setNeutralButton("Cancel",null)
//                .show();

        //type 2

//        builder.setTitle("question ?")
//
//                .setCancelable(false)
//                .setSingleChoiceItems(new String[]{"A", "B", "C", "D"}, 1, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(DialogActivity.this, which +" selected", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setPositiveButton("OK",null)
//                .show();

        //    type 3
        builder.setTitle("select what u want")
//                .setMessage("")
                .setCancelable(true)
                .setMultiChoiceItems(new String[]{"item0", "itemA", "itemB", "itemC", "itemD"}, new boolean[]{false, true, true, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(DialogActivity.this, "item" + which + " is " + isChecked, Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("OK", null)
                .show();


    }

    public void showDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_tic__tac__toe);

        dialog.show();
    }

    public void dropIn(View view) {


        ImageView im = (ImageView) view;
        im.setTranslationY(-1000f);
        im.setImageResource(R.drawable.red);
        im.animate()
                .translationY(0f)
                .setDuration(1000l);


    }


}
