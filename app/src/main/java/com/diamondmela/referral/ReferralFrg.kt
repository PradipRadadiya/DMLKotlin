package com.diamondmela.referral

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diamondmela.BaseFragment
import com.diamondmela.R
import com.diamondmela.home.HomeAct.Companion.customerId
import com.diamondmela.referral.activity.CreateReferralAct
import com.diamondmela.referral.adapter.ReferralAdapter
import com.diamondmela.referral.model.Data
import com.diamondmela.referral.model.ReferralItem
import com.diamondmela.retrofit.APIClient
import com.diamondmela.retrofit.ApiInterface
import com.diamondmela.util.AppLogger
import com.diamondmela.utility.SwipeToDeleteCallback
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_referral.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReferralFrg : BaseFragment() {
    private var btnCreateReferral: MaterialButton? = null
    private lateinit var rootView: View
    lateinit var referralList: ArrayList<ReferralItem>

    override fun myFragmentView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater.inflate(R.layout.fragment_referral, parent, false)
        return rootView
    }

    override fun init() {
        btnCreateReferral = rootView.findViewById(R.id.btnCreateReferral)
    }

    override fun initView() {
    }

    override fun postInitView() {
    }

    override fun addListener() {
        btnCreateReferral?.setOnClickListener {
            startNewActivity(CreateReferralAct::class.java)
        }
    }

    override fun loadData() {
        referralList()
    }

    private fun referralList() {
        showProgressDialog("Referral", "Please wait..")
        val apiInterface = APIClient.client?.create(ApiInterface::class.java)
        val callApi = apiInterface?.getReferral(customerId = customerId)
        callApi?.enqueue(object : Callback<ReferralItem> {
            override fun onFailure(call: Call<ReferralItem>, t: Throwable) {
                hideProgressDialog()
                AppLogger.e(t.message.toString())
            }

            override fun onResponse(call: Call<ReferralItem>, response: Response<ReferralItem>) {
                hideProgressDialog()
                AppLogger.response(response.body().toString())
                val linearLayoutManager = LinearLayoutManager(activity)
                recycleViewReferral.layoutManager = linearLayoutManager

                val swipeHandler = object : SwipeToDeleteCallback(activity) {
                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                        val adapter = recycleViewReferral.adapter as ReferralAdapter
                        adapter.removeAt(viewHolder.adapterPosition)
                    }
                }
                val itemTouchHelper = ItemTouchHelper(swipeHandler)
                itemTouchHelper.attachToRecyclerView(recycleViewReferral)

                val adapter = ReferralAdapter(activity, response.body()!!.data as ArrayList<Data>)
                recycleViewReferral.adapter = adapter
            }
        })
    }


}
