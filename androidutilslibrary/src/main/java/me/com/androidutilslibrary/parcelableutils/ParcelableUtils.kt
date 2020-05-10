package me.com.androidutilslibrary.parcelableutils

import android.os.Parcel
import android.os.Parcelable

object ParcelableUtils {
    /**
     * @param parceable parcelable
     * @return byte array
     */
    fun marshall(parceable: Parcelable): ByteArray {
        val parcel = Parcel.obtain()
        parceable.writeToParcel(parcel, 0)
        val bytes = parcel.marshall()
        parcel.recycle()
        return bytes
    }

    /**
     * @param bytes byte array
     * @return Parcel
     */
    fun unmarshall(bytes: ByteArray): Parcel {
        val parcel = Parcel.obtain()
        parcel.unmarshall(bytes, 0, bytes.size)
        parcel.setDataPosition(0) // This is extremely important!
        return parcel
    }

    /**
     * @param bytes   byte array
     * @param creator creator of parcelable
     * @param <T>     generic
     * @return generic
    </T> */
    fun <T> unmarshall(bytes: ByteArray, creator: Parcelable.Creator<T>): T {
        val parcel = unmarshall(bytes)
        val result = creator.createFromParcel(parcel)
        parcel.recycle()
        return result
    }
}