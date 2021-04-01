package com.example.thebareminimumii;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class Loading {


       private Activity loading_dialog;
       private AlertDialog dialog;

       Loading(Activity myActivity)
       {
           loading_dialog = myActivity;
       }
       void startloading_dialog() {
           AlertDialog.Builder builder = new AlertDialog.Builder(loading_dialog);
           LayoutInflater inflater = loading_dialog.getLayoutInflater();
           builder.setView(inflater.inflate(R.layout.loading_dialog, null));
           builder.setCancelable(false);

           dialog = builder.create();
           dialog.show();
       }
           void dismissDialog()
           {
             dialog.dismiss();
           }
       }


