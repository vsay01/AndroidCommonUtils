package me.com.androidutilslibrary.networkutils

import android.content.Context
import android.net.ConnectivityManager

object NetworkUtils {
    /**
     *
     * @param context context
     * @return true if mobile has internet connection otherwise return false
     */
    @JvmStatic
    fun isOnline(context: Context?): Boolean {
        context?.let {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return try {
                val netInfo = cm.activeNetworkInfo
                netInfo != null && netInfo.isConnectedOrConnecting

            } catch (exception: Exception) {
                false
            }
        }
        return false
    }
}