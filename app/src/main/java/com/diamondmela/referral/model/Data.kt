package com.diamondmela.referral.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("attribute_set_id")
    val attributeSetId: String,
    @SerializedName("contact_number")
    val contactNumber: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("created_in")
    val createdIn: String,
    @SerializedName("disable_auto_group_change")
    val disableAutoGroupChange: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("entity_id")
    val entityId: String,
    @SerializedName("entity_type_id")
    val entityTypeId: String,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("franchise_referral_status")
    val franchiseReferralStatus: String,
    @SerializedName("franchisee_status")
    val franchiseeStatus: String,
    @SerializedName("group_id")
    val groupId: String,
    @SerializedName("increment_id")
    val incrementId: Any,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("_isfranchisee")
    val isfranchisee: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("parent_franchise_id")
    val parentFranchiseId: String,
    @SerializedName("password_hash")
    val passwordHash: String,
    @SerializedName("referral_comission")
    val referralComission: String,
    @SerializedName("referral_type")
    val referralType: String,
    @SerializedName("store_id")
    val storeId: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("website_id")
    val websiteId: String
)