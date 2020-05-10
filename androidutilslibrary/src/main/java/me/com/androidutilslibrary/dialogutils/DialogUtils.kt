package me.com.androidutilslibrary.dialogutils

import android.content.Context
import androidx.appcompat.app.AlertDialog

object DialogUtils {
    /**
     * @param context                   context
     * @param title                     dialog title
     * @param message                   dialog message
     * @param positiveButtonStringValue positive
     * @return return alert dialog builder
     */
    @JvmStatic
    fun buildDialog(context: Context?, title: String?, message: String?, positiveButtonStringValue: String?): AlertDialog.Builder {
        val builder = AlertDialog.Builder(context!!)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(positiveButtonStringValue) { dialog, _ -> dialog.dismiss() }
        return builder
    }
}