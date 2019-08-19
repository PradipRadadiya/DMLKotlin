package com.diamondmela.transaction.model


import com.google.gson.annotations.SerializedName

data class OrderItem(
    @SerializedName("product_increment_id")
    val productIncrementId: String,
    @SerializedName("product_metalweight")
    val productMetalweight: String,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("product_price")
    val productPrice: String,
    @SerializedName("product_sku")
    val productSku: String,
    @SerializedName("product_stonequality")
    val productStonequality: String,
    @SerializedName("product_stoneweight")
    val productStoneweight: String
)