package com.diamondmela.home.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.diamondmela.BaseFragment

import com.diamondmela.R
import com.diamondmela.home.HomeAct
import com.diamondmela.home.adapter.BannerAdapter
import com.diamondmela.home.adapter.HeaderAdapter
import com.diamondmela.home.model.banner.BannerItem
import com.diamondmela.home.model.header.Data
import com.diamondmela.home.model.header.HeaderItem
import com.diamondmela.home.model.most_popular.MostPopularItem
import com.diamondmela.home.model.most_selling.MostSellingItem
import com.diamondmela.retrofit.APIClient
import com.diamondmela.retrofit.ApiInterface
import com.diamondmela.util.AppLogger
import kotlinx.android.synthetic.main.activity_transaction.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFrg : BaseFragment() {
    override fun myFragmentView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, parent, false)
    }

    override fun init() {

    }

    override fun initView() {

    }

    override fun postInitView() {

    }

    override fun addListener() {
//        viewPagerBanner.addOnPageChangeListener(object )
    }

    override fun loadData() {
        GlobalScope.launch {
            var header = async {
                loadHeader()
            }
            var mostPopular = async {
                loadMostSellingProduct()
            }
            var popularProducts = async {
                loadMostPopularProduct()
            }
            var banner = async {
                loadBanner()
            }
        }
    }

    private fun loadBanner() {
        val apiInterface = APIClient.client?.create(ApiInterface::class.java)
        val callApi = apiInterface?.getBannerImage()
        callApi?.enqueue(object : Callback<BannerItem> {
            override fun onResponse(call: Call<BannerItem>, response: Response<BannerItem>) {
                AppLogger.response(response.body().toString())
                // Initialize a new pager adapter instance with list
                val adapter = response.body()?.sliderImage?.let { BannerAdapter(it) }

                // Finally, data bind the view pager widget with pager adapter
                viewPagerBanner.adapter = adapter
                springDotsIndicator.setViewPager(viewPagerBanner)
            }

            override fun onFailure(call: Call<BannerItem>, t: Throwable) {

            }

        })
    }


    private fun loadHeader() {
        val apiInterface = APIClient.client?.create(ApiInterface::class.java)
        val callApi = apiInterface?.getHeader()
        callApi?.enqueue(object : Callback<HeaderItem> {
            override fun onResponse(call: Call<HeaderItem>, response: Response<HeaderItem>) {
                AppLogger.response(response.body().toString())
                val gridLayout = GridLayoutManager(activity, 1)
                gridLayout.orientation = LinearLayoutManager.HORIZONTAL
                recycleviewHeader.layoutManager = gridLayout
                val adapter = HeaderAdapter(activity, response.body()?.data as ArrayList<Data>)
                recycleviewHeader.adapter = adapter
            }

            override fun onFailure(call: Call<HeaderItem>, t: Throwable) {
                AppLogger.error(t.message.toString())
            }
        })
    }

    private fun loadMostSellingProduct() {
        val apiInterface = APIClient.client?.create(ApiInterface::class.java)
        val callApi = apiInterface?.getMostSEllingProduct()
        callApi?.enqueue(object : Callback<MostSellingItem> {
            override fun onResponse(call: Call<MostSellingItem>, response: Response<MostSellingItem>) {
                AppLogger.response(response.body().toString())
            }

            override fun onFailure(call: Call<MostSellingItem>, t: Throwable) {

            }

        })
    }

    private fun loadMostPopularProduct() {
        val apiInterface = APIClient.client?.create(ApiInterface::class.java)
        val callApi = apiInterface?.getPopularProduct()
        callApi?.enqueue(object : Callback<MostPopularItem> {
            override fun onResponse(call: Call<MostPopularItem>, response: Response<MostPopularItem>) {
                AppLogger.response(response.body().toString())
            }

            override fun onFailure(call: Call<MostPopularItem>, t: Throwable) {

            }

        })
    }
}
