package com.diamondmela.referral.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.diamondmela.R
import com.diamondmela.referral.model.Data
import com.diamondmela.retrofit.APIClient
import com.diamondmela.retrofit.ApiInterface
import com.diamondmela.util.showInfoToast
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.fragment_referral_list_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReferralAdapter(private val activity: FragmentActivity?, private var itemArrayList: ArrayList<Data>) :
    RecyclerView.Adapter<ReferralAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_referral_list_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        val data = itemArrayList[i]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return itemArrayList.size
    }

    fun removeAt(position: Int) {
        itemArrayList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        @SuppressLint("SetTextI18n")
        fun setData(data: Data?) {
            itemView.tvOrderId.text = ": "+(data?.firstname ?: "") + (data?.lastname ?: "")
            itemView.tvTransactionAmt.text = ": "+data?.referralComission ?: ""
        }

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
            itemView.btnDelete.setOnClickListener {
                deleteReferral(itemArrayList[adapterPosition].entityId)
            }
        }
        override fun onClick(v: View) {
            activity?.showInfoToast("information click")
        }

        override fun onLongClick(v: View): Boolean {
            return false
        }
    }

    private fun deleteReferral(referralCustomerId : String) {
        val apiInterface = APIClient.client?.create(ApiInterface::class.java)
        val callApi = apiInterface?.deleteReferral(referralCustomerId)
        callApi?.enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

            }
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {

            }

        })
    }
}
