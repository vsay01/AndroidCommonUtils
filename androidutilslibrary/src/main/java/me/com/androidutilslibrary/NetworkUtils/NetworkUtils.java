package me.com.androidutilslibrary.NetworkUtils;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

public class NetworkUtils {
    /**
     *
     * @param context context
     * @return true if mobile has internet connection otherwise return false
     */
    public static boolean isOnline(Context context) {
        if (context != null) {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                return netInfo != null && netInfo.isConnectedOrConnecting();
            }
            return false;
        }
        return false;
    }
}
