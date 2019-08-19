package com.diamondmela.signup_signin.model.login_item


import com.google.gson.annotations.SerializedName

data class DefaultBillingNew(
    @SerializedName("attribute_set_id")
    val attributeSetId: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country_id")
    val countryId: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("entity_id")
    val entityId: String,
    @SerializedName("entity_type_id")
    val entityTypeId: String,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("increment_id")
    val incrementId: Any,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("parent_id")
    val parentId: String,
    @SerializedName("postcode")
    val postcode: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("region_id")
    val regionId: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("telephone")
    val telephone: String,
    @SerializedName("updated_at")
    val updatedAt: String
)