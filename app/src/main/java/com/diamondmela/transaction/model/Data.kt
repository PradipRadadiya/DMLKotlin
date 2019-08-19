package com.diamondmela.transaction.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("create_date")
    val createDate: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("increment_id")
    val incrementId: String,
    @SerializedName("order_item")
    val orderItem: List<OrderItem>,
    @SerializedName("transction_price")
    val transctionPrice: Int
)