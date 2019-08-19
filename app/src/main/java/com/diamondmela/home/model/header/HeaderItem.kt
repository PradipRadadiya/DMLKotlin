package com.diamondmela.home.model.header


import com.google.gson.annotations.SerializedName

data class HeaderItem(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: String
)