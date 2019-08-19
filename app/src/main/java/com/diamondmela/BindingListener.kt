package com.diamondmela

interface BindingListener {
    fun init()
    fun initView()
    fun postInitView()
    fun addListener()
    fun loadData()
}