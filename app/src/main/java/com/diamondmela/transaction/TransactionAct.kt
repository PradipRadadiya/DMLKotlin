package com.diamondmela.transaction

import android.annotation.SuppressLint
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diamondmela.BaseActivity
import com.diamondmela.R
import com.diamondmela.home.HomeAct
import com.diamondmela.home.HomeAct.Companion.customerId
import com.diamondmela.retrofit.APIClient
import com.diamondmela.retrofit.ApiInterface
import com.diamondmela.transaction.adapter.TransactionAdapter
import com.diamondmela.transaction.model.TransactionItem
import com.diamondmela.util.AppConstants
import com.diamondmela.util.AppLogger
import com.diamondmela.util.NetworkUtils
import kotlinx.android.synthetic.main.activity_transaction.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TransactionAct : BaseActivity() {

    var adapter: TransactionAdapter? = null
    //page count
    private var page_count = 1
    private var flag_scroll = false
    private var previousTotal = 0 // The total number of items in the dataset after the last load
    private var loading = true // True if we are still waiting for the last set of data to load.
    private var visibleThreshold =
        0 // The minimum amount of items to have below your current scroll position before loading more.
    private var firstVisibleItem: Int = 0
    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0

    private var gridLayout: GridLayoutManager? = null

    private var dataList: ArrayList<com.diamondmela.transaction.model.Data>? = null

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_transaction
    }

    override fun init() {
        dataList = ArrayList()
    }

    override fun initView() {
    }

    @SuppressLint("WrongConstant")
    override fun postInitView() {
        gridLayout = GridLayoutManager(this@TransactionAct, 1)
        gridLayout!!.orientation = LinearLayoutManager.VERTICAL
        recycleViewTransaction.layoutManager = gridLayout
    }

    override fun addListener() {
        recycleViewTransaction.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                visibleItemCount = recyclerView.childCount
                totalItemCount = gridLayout!!.getItemCount()
                firstVisibleItem = gridLayout!!.findFirstVisibleItemPosition()

                if (flag_scroll) {
                    AppLogger.e("if flag scroll" + flag_scroll.toString())
                } else {
                    if (loading) {
                        AppLogger.e("else - if flag scroll" + loading.toString())
                        if (totalItemCount > previousTotal) {
                            loading = false
                            previousTotal = totalItemCount
                            //Log.e("flag-IF", (totalItemCount > previousTotal) + "");
                        }
                    }
                    if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold) {
                        // End has been reached
                        // Do something
                        AppLogger.e("else seconf if flag scroll" + loading.toString())
                        if (NetworkUtils.isOnline(this@TransactionAct)) {
                            AppLogger.e("total count--------------------$page_count")
                            AppLogger.e("page_count--------------------$page_count")
                            page_count++
                            transactionList(customerId, page_count.toString())
                        } else {
                            //internet not connected
                            AppLogger.e("connection-------internet connection is off")
                        }
                        loading = true
                    }

                }
            }

        }

        )
    }

    override fun loadData() {
        adapter = dataList?.let { TransactionAdapter(this@TransactionAct, it) }

        recycleViewTransaction.adapter = adapter
        transactionList(customerId, page_count.toString())
    }

    private fun transactionList(customerId: String, page: String) {
        showProgressDialog("Transaction", "Please wait..")
        val apiInterface = APIClient.client?.create(ApiInterface::class.java)
        val callApi = apiInterface?.transactonList(customerId = HomeAct.customerId, page = page)
        callApi?.enqueue(object : Callback<TransactionItem> {
            override fun onResponse(call: Call<TransactionItem>, response: Response<TransactionItem>) {
                AppLogger.response(response.body().toString())
                hideProgressDialog()
                if (response.body()?.status.equals(AppConstants.STATUS_CODE_SUCCESS)) {
                    dataList?.addAll(response.body()!!.data as ArrayList<com.diamondmela.transaction.model.Data>);
                    adapter?.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<TransactionItem>, t: Throwable) {
                hideProgressDialog()
            }

        })

    }

}
