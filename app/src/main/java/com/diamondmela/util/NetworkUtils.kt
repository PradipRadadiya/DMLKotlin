package com.diamondmela.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

object NetworkUtils {

    fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    fun isConnected(context: Context): Boolean {
        val cm = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected) {
            try {
                val url = URL("https://www.google.com/")
                val urlc = url.openConnection() as HttpURLConnection
                urlc.setRequestProperty("User-Agent", "test")
                urlc.setRequestProperty("Connection", "close")
                urlc.connectTimeout = 1000 // mTimeout is in seconds
                urlc.connect()
                return if (urlc.responseCode == 200) {
                    true
                } else {
                    false
                }
            } catch (e: IOException) {
                AppLogger.e("Error checking internet connection" + e.message)
                return false
            }

        }

        return false

    }
}
