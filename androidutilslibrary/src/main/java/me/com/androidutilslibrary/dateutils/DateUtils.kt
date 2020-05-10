package me.com.androidutilslibrary.dateutils

import android.net.ParseException
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    /**
     * @param inputDate         string input Date
     * @param inputDatePattern  input date pattern
     * @param outputDatePattern output date pattern
     * @return for instance:
     * inputDatePattern: "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
     * outputDatePattern: "MMM, dd yyyy", "MMM dd, yyyy 'at' HH:mm a"
     */
    fun getFormattedDateFromStringInputDate(inputDate: String, inputDatePattern: String, outputDatePattern: String): String {
        val parsed: Date?
        var outputDate = ""
        val dfInput = SimpleDateFormat(inputDatePattern, Locale.getDefault())
        val dfOutput = SimpleDateFormat(outputDatePattern, Locale.getDefault())
        try {
            parsed = dfInput.parse(inputDate)
            parsed?.let {
                outputDate = dfOutput.format(it)
            }
        } catch (e: ParseException) {
            Log.d(DateUtils::class.java.name, e.message ?: "")
        } catch (e: java.text.ParseException) {
            e.printStackTrace()
        }
        return outputDate
    }
}