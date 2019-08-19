package com.diamondmela.referral.model


import com.google.gson.annotations.SerializedName

data class ReferralItem(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: String
)