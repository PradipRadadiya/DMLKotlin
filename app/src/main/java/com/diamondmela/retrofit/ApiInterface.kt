package com.diamondmela.retrofit

import com.diamondmela.home.model.banner.BannerItem
import com.diamondmela.home.model.header.HeaderItem
import com.diamondmela.home.model.most_popular.MostPopularItem
import com.diamondmela.home.model.most_selling.MostSellingItem
import com.diamondmela.referral.model.ReferralItem
import com.diamondmela.signup_signin.model.login_item.LoginItem
import com.diamondmela.transaction.model.TransactionItem
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.GET


interface ApiInterface {

    //Login API
    @FormUrlEncoded
    @POST("dmlapi/customers/ValidateUser/")
    fun Login(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("notification_token") token: String,
        @Field("device_id") deviceId: String
    ): Call<LoginItem>

    //Sign Up API
    @FormUrlEncoded
    @POST("dmlapi/customers/registercustomer/")
    fun signUp(
        @Field("firstname") firstName: String,
        @Field("lastname") lastName: String,
        @Field("email") email: String,
        @Field("contact_number") contactNumber: String,
        @Field("community") community: String,
        @Field("street") street: String,
        @Field("country_id") countryId: String,
        @Field("region") region: String,
        @Field("city") city: String,
        @Field("postcode") postcode: String,
        @Field("entity_customer") entityCustomer: String,
        @Field("password") password: String,
        @Field("confirmation") confirmation: String
    ): Call<JsonObject>

//    *********************************REFERRAL******************************************

    //Referral list
    @FormUrlEncoded
    @POST("dmlapi/customers/getallreferrals")
    fun getReferral(@Field("customer_id") customerId: String): Call<ReferralItem>

    //Add Referral
    @FormUrlEncoded
    @POST("dmlapi/customers/createreferral")
    fun addReferral(
        @Field("franchisee_status") franchiseeStatus: String,
        @Field("firstname") firstName: String,
        @Field("lastname") lastname: String,
        @Field("email") email: String,
        @Field("group_id") groupId: String,
        @Field("password") password: String,
        @Field("referral_comission") referralCommission: String,
        @Field("parent_franchise_id") parentFranchiseId: String,
        @Field("telephone") telephone: String,
        @Field("referral_type") referralType: String,
        @Field("_isfranchisee") isFranchisee: String
    ): Call<JsonObject>

    //Delete Referral
    @FormUrlEncoded
    @POST("dmlapi/customers/deletereferral")
    fun deleteReferral(@Field("referral_customer_id") referralCustomerId: String): Call<JsonObject>


    //*************************************Transaction*********************************************

    @FormUrlEncoded
    @POST("dmlapi/transaction/transactionview/")
    fun transactonList(
        @Field("customer_id") customerId: String,
        @Field("pagesize") page: String
    ): Call<TransactionItem>


    //************************************Home*****************************************************
    //Banner Slider
    @GET("dmlapi/home/gethomeslider")
    fun getBannerImage(): Call<BannerItem>

    //Header Slider
    @GET("dmlapi/home/getallcategorys")
    fun getHeader(): Call<HeaderItem>

    //Most Selling Product
    @GET("dmlapi/home/bestsellerproduct")
    fun getMostSEllingProduct(): Call<MostSellingItem>

    //Popular Product
    @GET("dmlapi/home/getpopularproduct")
    fun getPopularProduct(): Call<MostPopularItem>

}
