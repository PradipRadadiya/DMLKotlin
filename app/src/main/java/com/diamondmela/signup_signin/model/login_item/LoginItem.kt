package com.diamondmela.signup_signin.model.login_item


import com.google.gson.annotations.SerializedName

data class LoginItem(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("customer_role")
    val customerRole: String,
    @SerializedName("status")
    val status: String
)


