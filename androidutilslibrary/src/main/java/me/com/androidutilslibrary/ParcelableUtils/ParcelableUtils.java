package me.com.androidutilslibrary.ParcelableUtils;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableUtils {
    /**
     * @param parceable parcelable
     * @return byte array
     */
    public static byte[] marshall(Parcelable parceable) {
        Parcel parcel = Parcel.obtain();
        parceable.writeToParcel(parcel, 0);
        byte[] bytes = parcel.marshall();
        parcel.recycle();
        return bytes;
    }

    /**
     * @param bytes byte array
     * @return Parcel
     */
    public static Parcel unmarshall(byte[] bytes) {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(bytes, 0, bytes.length);
        parcel.setDataPosition(0); // This is extremely important!
        return parcel;
    }

    /**
     * @param bytes   byte array
     * @param creator creator of parcelable
     * @param <T>     generic
     * @return generic
     */
    public static <T> T unmarshall(byte[] bytes, Parcelable.Creator<T> creator) {
        Parcel parcel = unmarshall(bytes);
        T result = creator.createFromParcel(parcel);
        parcel.recycle();
        return result;
    }
}
