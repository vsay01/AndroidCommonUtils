package me.com.androidutilslibrary.unitutils

import android.content.Context

object UnitUtils {
    /**
     * @param px      pixel value
     * @param context context
     * @return dp value
     */
    fun pxToDp(px: Int, context: Context): Int {
        val scale = context.resources.displayMetrics.density
        return (px / scale + 0.5f).toInt()
    }

    /**
     * @param dps     dps value
     * @param context context
     * @return return pixel value
     */
    fun dpToPx(dps: Int, context: Context): Int {
        val scale = context.resources.displayMetrics.density
        return (dps * scale + 0.5f).toInt()
    }
}