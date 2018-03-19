package com.treever_template_tester.comman;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.treever_template_tester.R;
import com.treever_template_tester.ui.main_screen.MainActivity;

/**
 * Created by Abgaryan on 3/19/18.
 */

public class DialogHelper {


    public  void showErrorPopup(final MainActivity context, String message) {

        if (context != null && !((Activity) context).isFinishing()) {
            new AlertDialog.Builder(context, R.style.DialogTheme).setCancelable(false)
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    })
                    .show();
        }
    }

    public static void showNoInternetError(final Context context) {
        if (context != null && !((Activity) context).isFinishing()) {
            new android.support.v7.app.AlertDialog.Builder(context)
                    .setTitle(R.string.dialog_connection_off_title)
                    .setMessage(R.string.dialog_connection_off_message)
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    .setIcon(android.R.drawable.ic_menu_info_details)
                    .show();
            ;
        }
    }
}
