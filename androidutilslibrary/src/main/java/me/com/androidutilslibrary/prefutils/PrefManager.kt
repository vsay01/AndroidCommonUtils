package me.com.androidutilslibrary.colorutils

import android.content.Context
import android.content.SharedPreferences

object PrefManager {
    /**
     * Obtains a specified preference by passing a key.
     *
     * @param key
     * @return The specified preference
     */
    fun getSharedPreferences(context: Context, key: String?): SharedPreferences {
        return context.getSharedPreferences(key, Context.MODE_PRIVATE)
    }

    /**
     * @param prefs
     * @param key
     * @param value
     */
    fun setString(prefs: SharedPreferences, key: String?, value: String?) {
        prefs.edit().putString(key, value).apply()
    }

    /**
     * @param prefs
     * @param key
     * @param defaultValue
     * @return Returns the string paired with the key, or the defaultValue if nothing is returned.
     */
    fun getString(prefs: SharedPreferences, key: String?, defaultValue: String?): String? {
        return prefs.getString(key, defaultValue)
    }

    /**
     * @param prefs
     * @param key
     */
    fun remove(prefs: SharedPreferences, key: String?) {
        prefs.edit().remove(key).apply()
    }

    /**
     * @param prefs
     * @return
     */
    fun clear(prefs: SharedPreferences): Boolean {
        return prefs.edit().clear().commit()
    }
}