package com.diamondmela.home.model.header


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("category_img")
    val categoryImg: String,
    @SerializedName("entity_id")
    val entityId: String,
    @SerializedName("icon_img")
    val iconImg: String,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("is_anchor")
    val isAnchor: String,
    @SerializedName("level")
    val level: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("path")
    val path: String,
    @SerializedName("position")
    val position: String
)