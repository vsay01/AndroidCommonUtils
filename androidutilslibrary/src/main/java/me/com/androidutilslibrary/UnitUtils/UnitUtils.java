package me.com.androidutilslibrary.UnitUtils;

import android.content.Context;

public class UnitUtils {
    /**
     * @param dps     dps value
     * @param context context
     * @return return pixel value
     */
    public static int dpToPx(int dps, Context context) {
        if (context == null) {
            return 0;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dps * scale + 0.5f);
    }

    /**
     * @param px      pixel value
     * @param context context
     * @return dp value
     */
    public int pxToDp(int px, Context context) {
        if (context == null) {
            return 0;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((px / scale) + 0.5f);
    }
}
