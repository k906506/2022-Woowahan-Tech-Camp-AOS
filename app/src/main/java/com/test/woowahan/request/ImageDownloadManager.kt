package com.test.woowahan.request

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.LruCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

object ImageDownloadManager {

    @Synchronized
    suspend fun getImage(url: String): Bitmap? = suspendCancellableCoroutine { continuation ->
        val urlConnection = URL(url).openConnection() as HttpURLConnection
        GlobalScope.launch(Dispatchers.IO) {
            try {
                if (urlConnection.responseCode == 200) {
                    val stream = BufferedInputStream(urlConnection.inputStream)
                    val bitmap = BitmapFactory.decodeStream(stream)
                    continuation.resume(bitmap) {}
                } else {

                }
            } catch (e: Exception) {

            } finally {
                urlConnection.disconnect()
            }
        }
    }
}