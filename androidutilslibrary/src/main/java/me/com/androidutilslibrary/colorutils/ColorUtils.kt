package me.com.androidutilslibrary.colorutils

import android.graphics.Color
import kotlin.math.min
import kotlin.math.roundToInt

object ColorUtils {
    /**
     * https://stackoverflow.com/questions/33072365/how-to-darken-a-given-color-int
     *
     * @param color  color provided
     * @param factor factor to make color darker
     * @return int as darker color
     */
    fun manipulateColor(color: Int, factor: Float): Int {
        val a = Color.alpha(color)
        val r = (Color.red(color) * factor).roundToInt()
        val g = (Color.green(color) * factor).roundToInt()
        val b = (Color.blue(color) * factor).roundToInt()
        return Color.argb(a,
                min(r, 255),
                min(g, 255),
                min(b, 255))
    }
}