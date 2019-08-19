package com.diamondmela.transaction.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.diamondmela.R
import com.diamondmela.util.showInfoToast
import kotlinx.android.synthetic.main.fragment_referral_list_item.view.tvOrderId
import kotlinx.android.synthetic.main.fragment_referral_list_item.view.tvTransactionAmt
import kotlinx.android.synthetic.main.frahment_transaction_list_item.view.*

class TransactionAdapter(
    private val activity: FragmentActivity?,
    private var itemArrayList: ArrayList<com.diamondmela.transaction.model.Data>
) :
    RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.frahment_transaction_list_item, viewGroup, false)
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
        fun setData(data: com.diamondmela.transaction.model.Data?) {
            itemView.tvOrderId.text = itemArrayList[adapterPosition].incrementId
            itemView.tvTransactionAmt.text = itemArrayList[adapterPosition].transctionPrice.toString()
            itemView.tvCrDr.text = itemArrayList[adapterPosition].description
        }

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)

        }

        override fun onClick(v: View) {
            activity?.showInfoToast("information click")
        }

        override fun onLongClick(v: View): Boolean {
            return false
        }
    }

}
