package me.com.androidutilslibrary.unitutils

import android.content.Context

class UnitUtils {
    /**
     * @param px      pixel value
     * @param context context
     * @return dp value
     */
    fun pxToDp(px: Int, context: Context?): Int {
        if (context == null) {
            return 0
        }
        val scale = context.resources.displayMetrics.density
        return (px / scale + 0.5f).toInt()
    }

    companion object {
        /**
         * @param dps     dps value
         * @param context context
         * @return return pixel value
         */
        fun dpToPx(dps: Int, context: Context?): Int {
            if (context == null) {
                return 0
            }
            val scale = context.resources.displayMetrics.density
            return (dps * scale + 0.5f).toInt()
        }
    }
}