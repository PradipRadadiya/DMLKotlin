package com.diamondmela.home.model.banner


import com.google.gson.annotations.SerializedName

data class BannerItem(
    @SerializedName("banner_image")
    val bannerImage: String,
    @SerializedName("slider_image")
    val sliderImage: List<SliderImage>,
    @SerializedName("status")
    val status: String
)