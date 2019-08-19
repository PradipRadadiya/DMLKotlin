package com.diamondmela.home.model.banner


import com.google.gson.annotations.SerializedName

data class SliderImage(
    @SerializedName("background_type")
    val backgroundType: String,
    @SerializedName("bg_fit")
    val bgFit: String,
    @SerializedName("bg_position")
    val bgPosition: String,
    @SerializedName("bg_repeat")
    val bgRepeat: String,
    @SerializedName("class_attr")
    val classAttr: String,
    @SerializedName("data_attr")
    val dataAttr: String,
    @SerializedName("date_from")
    val dateFrom: String,
    @SerializedName("date_to")
    val dateTo: String,
    @SerializedName("delay")
    val delay: String,
    @SerializedName("enable_link")
    val enableLink: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("id_attr")
    val idAttr: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("kenburn_effect")
    val kenburnEffect: String,
    @SerializedName("layers")
    val layers: List<Any>,
    @SerializedName("save_performance")
    val savePerformance: String,
    @SerializedName("slide_order")
    val slideOrder: String,
    @SerializedName("slide_thumb")
    val slideThumb: String,
    @SerializedName("slide_transition")
    val slideTransition: String,
    @SerializedName("slot_amount")
    val slotAmount: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("transition_duration")
    val transitionDuration: String,
    @SerializedName("transition_rotation")
    val transitionRotation: String
)