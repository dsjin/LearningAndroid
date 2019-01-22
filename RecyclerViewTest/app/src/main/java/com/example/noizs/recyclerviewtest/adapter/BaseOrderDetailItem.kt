package com.example.noizs.recyclerviewtest.adapter

open class BaseOrderDetailItem(val type: Int){
    fun getOrderType() : Int{
        return type
    }
}