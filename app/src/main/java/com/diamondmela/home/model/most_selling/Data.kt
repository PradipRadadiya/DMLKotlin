package com.diamondmela.home.model.most_selling


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("attribute_set_id")
    val attributeSetId: String,
    @SerializedName("cat_index_position")
    val catIndexPosition: String,
    @SerializedName("custom_price")
    val customPrice: String,
    @SerializedName("dml_only")
    val dmlOnly: String,
    @SerializedName("entity_id")
    val entityId: String,
    @SerializedName("final_price")
    val finalPrice: String,
    @SerializedName("indexed_price")
    val indexedPrice: String,
    @SerializedName("max_price")
    val maxPrice: String,
    @SerializedName("min_price")
    val minPrice: String,
    @SerializedName("minimal_price")
    val minimalPrice: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("sku")
    val sku: String,
    @SerializedName("small_image")
    val smallImage: String,
    @SerializedName("sold_quantity")
    val soldQuantity: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("tier_price")
    val tierPrice: Any,
    @SerializedName("type_id")
    val typeId: String
)