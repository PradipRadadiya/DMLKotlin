package com.diamondmela.signup_signin

import com.diamondmela.BaseActivity
import com.diamondmela.R
import com.diamondmela.home.HomeAct
import com.diamondmela.retrofit.APIClient
import com.diamondmela.retrofit.ApiInterface
import com.diamondmela.signup_signin.model.login_item.LoginItem
import com.diamondmela.util.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_sign_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInAct : BaseActivity() {

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_sign_in
    }

    override fun init() {
    }

    override fun initView() {
    }

    override fun postInitView() {
    }

    override fun addListener() {
        //Click onSign in button
        btnSignIn.setOnClickListener {
            val valid: Boolean
            valid = validateSignUp()
            if (valid) {
                if (cbRememberPwd.isChecked) {
                    checkLogin(edFnm.text.toString(), edPassword.text.toString())
                } else {
                    showErrorToast("Please select remember password.")
                }
            }
        }

        //click on forgot password
        tvForgotPwd.setOnClickListener {

        }

        //click on create on account
        tvCreateAccount.setOnClickListener {

        }
    }

    private fun checkLogin(emailPhone: String, password: String) {
        showProgressDialog("Login", "Please wait..")
        val apiInterface = APIClient.client?.create(ApiInterface::class.java)
        val callApi =
            apiInterface?.Login(
                emailPhone,
                password,
                CommonUtils.getDeviceID(this@SignInAct),
                CommonUtils.getDeviceID(this@SignInAct)
            )

        callApi!!.enqueue(object : Callback<LoginItem> {

            override fun onResponse(call: Call<LoginItem>, response: Response<LoginItem>) {
                AppLogger.response(response.body().toString())
                hideProgressDialog()
                if(response.isSuccessful){
                    if (response.body()?.status.equals(AppConstants.STATUS_CODE_SUCCESS)){
                        showSuccessToast("Login successfully.")
                        val session = SharedPreferenceSession(this@SignInAct)
                        val gson = Gson()
                        val jsonString = gson.toJson(response.body())
                        session.saveLoginData(jsonString)
                        session.saveDefaultBilling(response.body()?.data?.defaultBillingNew.toString())
                        session.saveDefaultShipping(response.body()?.data?.defaultShippingNew.toString())
                        startNewActivity(HomeAct::class.java)
                        finish()
                    }

                }
            }

            override fun onFailure(call: Call<LoginItem>, t: Throwable) {
                hideProgressDialog()
            }
        })

    }

    private fun validateSignUp(): Boolean {
        if (!Validator.checkEmptyInputText(edFnm, getString(R.string.pls_enter_email_or_phone))) {
            return false
        } else if (!Validator.checkEmptyInputText(edPassword, getString(R.string.pls_enter_password))) {
            return false
        }
        return true
    }

    override fun loadData() {

    }

}
