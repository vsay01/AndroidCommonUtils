package me.com.androidutilslibrary.DialogUtils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class DialogUtils {
    /**
     * @param context                   context
     * @param title                     dialog title
     * @param message                   dialog message
     * @param positiveButtonStringValue positive
     * @return return alert dialog builder
     */
    public static AlertDialog.Builder buildDialog(Context context, String title, String message, String positiveButtonStringValue) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton(positiveButtonStringValue, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        return builder;
    }
}
