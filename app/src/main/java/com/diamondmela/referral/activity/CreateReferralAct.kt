package com.diamondmela.referral.activity

import com.diamondmela.BaseActivity
import com.diamondmela.R
import kotlinx.android.synthetic.main.activity_create_referral.*

class CreateReferralAct : BaseActivity() {
    override fun getLayoutResourceId(): Int {
        return R.layout.activity_create_referral
    }

    override fun init() {
        bindToolBar(getString(R.string.create_referral))
    }

    override fun initView() {
    }

    override fun postInitView() {
    }

    override fun addListener() {
        btnManageReferral.setOnClickListener {
            finish()
        }
    }

    override fun loadData() {
    }
}
