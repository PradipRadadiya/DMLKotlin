package com.diamondmela.home.model.most_selling


import com.google.gson.annotations.SerializedName

data class MostSellingItem(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: String
)