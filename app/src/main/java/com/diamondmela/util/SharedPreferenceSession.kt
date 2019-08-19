package com.diamondmela.util

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor


class SharedPreferenceSession(mContext: Context) {
    private val sharedPreferences: SharedPreferences
    private val editor: Editor

    val loginData: String?
        get() = sharedPreferences.getString(LOGIN_DATA, "")

    val defaultBilling: String?
        get() = sharedPreferences.getString(DEFAULT_BILLING, "")

    val defaultShipping: String?
        get() = sharedPreferences.getString(DEFAULT_SHIPPING, "")


    init {
        sharedPreferences = mContext.getSharedPreferences(SHARED, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun saveLoginData(loginData: String) {
        editor.putString(LOGIN_DATA, loginData)
        editor.commit()
    }

    fun saveDefaultBilling(fnm: String) {
        editor.putString(DEFAULT_BILLING, fnm)
        editor.commit()
    }

    fun saveDefaultShipping(em: String) {
        editor.putString(DEFAULT_SHIPPING, em)
        editor.commit()
    }


    companion object {
        private const val SHARED = "DEMO"
        private const val LOGIN_DATA = "login_data"
        private const val DEFAULT_BILLING = "default_billing"
        private const val DEFAULT_SHIPPING = "default_shipping"
    }

}
