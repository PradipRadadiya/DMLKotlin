package com.diamondmela.home.model.most_popular


import com.google.gson.annotations.SerializedName

data class ProductImg(
    @SerializedName("attribute_set_id")
    val attributeSetId: String,
    @SerializedName("custom_price")
    val customPrice: String,
    @SerializedName("dml_only")
    val dmlOnly: String,
    @SerializedName("download_flag")
    val downloadFlag: Int,
    @SerializedName("entity_id")
    val entityId: String,
    @SerializedName("is_salable")
    val isSalable: String,
    @SerializedName("is_sold")
    val isSold: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("original_sku")
    val originalSku: String,
    @SerializedName("qty")
    val qty: String,
    @SerializedName("rts_stone_quality")
    val rtsStoneQuality: Any,
    @SerializedName("sku")
    val sku: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("stock")
    val stock: String,
    @SerializedName("stock_item")
    val stockItem: StockItem,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("type_id")
    val typeId: String,
    @SerializedName("url_path")
    val urlPath: String
)