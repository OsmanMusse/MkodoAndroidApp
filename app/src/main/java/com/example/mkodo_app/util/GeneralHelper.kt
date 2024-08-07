package com.example.mkodo_app.util

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.io.IOException
import java.nio.charset.Charset
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

object GeneralHelper {


    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS,
        afterObserve: () -> Unit = {}
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {

            override fun onChanged(value: T) {
                data = value
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }
        this.observeForever(observer)

        afterObserve.invoke()

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            this.removeObserver(observer)
            throw TimeoutException("LiveData value was never set.")
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
    }




    fun getJSONFromAssets(context: Context): String?{
        var json: String? = null
        val charset: Charset = Charsets.UTF_8

        try {
            val myUsersJsonFile = context.assets.open("Draw.json")
            val size = myUsersJsonFile.available()
            val buffer = ByteArray(size)
            myUsersJsonFile.read(buffer)
            myUsersJsonFile.close()
            json = String(buffer,charset)
        } catch (ex: IOException){
            ex.printStackTrace()
            return null
        }

        return json
    }
}