package me.com.androidutilslibrary.DateUtils;

import android.net.ParseException;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * @param inputDate         string input Date
     * @param inputDatePattern  input date pattern
     * @param outputDatePattern output date pattern
     * @return for instance:
     * inputDatePattern: "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
     * outputDatePattern: "MMM, dd yyyy", "MMM dd, yyyy 'at' HH:mm a"
     */
    public static String getFormattedDateFromStringInputDate(String inputDate, String inputDatePattern, String outputDatePattern) {

        Date parsed;
        String outputDate = "";

        SimpleDateFormat df_input = new SimpleDateFormat(inputDatePattern, java.util.Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputDatePattern, java.util.Locale.getDefault());

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
            Log.d(DateUtils.class.getName(), e.getMessage());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        return outputDate;
    }
}