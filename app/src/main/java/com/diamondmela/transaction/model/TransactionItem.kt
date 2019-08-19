package com.diamondmela.transaction.model


import com.google.gson.annotations.SerializedName

data class TransactionItem(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("customer_id")
    val customerId: String,
    @SerializedName("final_totalamount")
    val finalTotalamount: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("total_credit")
    val totalCredit: Int,
    @SerializedName("total_debit")
    val totalDebit: Int,
    @SerializedName("total_deposite")
    val totalDeposite: Int,
    @SerializedName("total_tds")
    val totalTds: Int
)