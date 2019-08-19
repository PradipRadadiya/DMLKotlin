package com.diamondmela.home.model.most_popular


import com.google.gson.annotations.SerializedName

data class MostPopularItem(
    @SerializedName("product_img")
    val productImg: List<ProductImg>,
    @SerializedName("status")
    val status: String
)