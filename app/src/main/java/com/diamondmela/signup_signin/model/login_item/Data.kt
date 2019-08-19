package com.diamondmela.signup_signin.model.login_item


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("attribute_set_id")
    val attributeSetId: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("community")
    val community: String,
    @SerializedName("confirmation")
    val confirmation: Any,
    @SerializedName("contact_number")
    val contactNumber: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("country_id")
    val countryId: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("customer_theme")
    val customerTheme: String,
    @SerializedName("default_billing")
    val defaultBilling: String,
    @SerializedName("default_billing_new")
    val defaultBillingNew: DefaultBillingNew,
    @SerializedName("default_shipping")
    val defaultShipping: String,
    @SerializedName("default_shipping_new")
    val defaultShippingNew: DefaultShippingNew,
    @SerializedName("deleted_products")
    val deletedProducts: String,
    @SerializedName("device_id")
    val deviceId: String,
    @SerializedName("disable_auto_group_change")
    val disableAutoGroupChange: String,
    @SerializedName("download_products")
    val downloadProducts: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("entity")
    val entity: String,
    @SerializedName("entity_customer")
    val entityCustomer: String,
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
    @SerializedName("gstin")
    val gstin: String,
    @SerializedName("increment_id")
    val incrementId: Any,
    @SerializedName("invoice_setting")
    val invoiceSetting: String,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("_isfranchisee")
    val isfranchisee: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("notification_token")
    val notificationToken: String,
    @SerializedName("pancardno")
    val pancardno: String,
    @SerializedName("parent_id")
    val parentId: Int,
    @SerializedName("password_hash")
    val passwordHash: String,
    @SerializedName("postcode")
    val postcode: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("region_id")
    val regionId: String,
    @SerializedName("store_id")
    val storeId: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("telephone")
    val telephone: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("website_id")
    val websiteId: String
)