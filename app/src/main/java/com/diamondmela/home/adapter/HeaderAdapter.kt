package com.diamondmela.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.diamondmela.R
import com.diamondmela.home.model.header.Data
import com.diamondmela.util.AppLogger
import kotlinx.android.synthetic.main.fragment_home_item_header.view.*

class HeaderAdapter(private val activity: FragmentActivity?, private var itemArrayList: ArrayList<Data>) :
    RecyclerView.Adapter<HeaderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_home_item_header, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        val data = itemArrayList[i]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return itemArrayList.size
    }


    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        fun setData(data: Data?) {
            itemView.imgHeaderIcon.setImageURI(data?.iconImg)
            AppLogger.e(data?.iconImg.toString())
            itemView.tvHeaderName.text = data.let { data?.name }
        }

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View) {

        }

        override fun onLongClick(v: View): Boolean {
            return false
        }
    }

}
