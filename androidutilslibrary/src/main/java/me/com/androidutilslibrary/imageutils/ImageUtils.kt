package me.com.androidutilslibrary.imageutils

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

object ImageUtils {
    /**
     *
     * @param context context
     * @param image image that want to be saved
     * @param imageUniqueId unique image id
     * @param directoryName directory name where image will be saved
     * @return saved image path
     */
    fun saveImage(context: Context, image: Bitmap, imageUniqueId: Long, directoryName: String): String? {
        var savedImagePath: String? = null
        val imageFileName = "JPEG_$imageUniqueId.jpg"
        val storageDir = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                .toString() + directoryName)
        var success = true
        if (!storageDir.exists()) {
            success = storageDir.mkdirs()
        }
        if (success) {
            val imageFile = File(storageDir, imageFileName)
            savedImagePath = imageFile.absolutePath
            try {
                val fOut: OutputStream = FileOutputStream(imageFile)
                image.compress(Bitmap.CompressFormat.JPEG, 100, fOut)
                fOut.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            savedImagePath = saveToInternalStorage(context, image, imageUniqueId, directoryName)
        }
        return savedImagePath
    }

    private fun saveToInternalStorage(context: Context, bitmapImage: Bitmap, movieId: Long, directoryName: String): String {
        val cw = ContextWrapper(context)
        // path to /data/data/yourapp/app_data/imageDir
        val directory = cw.getDir(directoryName, Context.MODE_PRIVATE)
        // Create imageDir
        val mypath = File(directory, "JPEG_$movieId.jpg")
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(mypath)
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                fos!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return mypath.absolutePath
    }
}