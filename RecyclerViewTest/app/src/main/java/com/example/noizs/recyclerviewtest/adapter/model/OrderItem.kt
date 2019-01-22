package com.example.noizs.recyclerviewtest.adapter.model

import com.example.noizs.recyclerviewtest.adapter.BaseOrderDetailItem
import com.example.noizs.recyclerviewtest.adapter.OrderDetailType

data class OrderItem(
    val id : String,
    val name : String,
    val detail : String,
    val price : String,
    val itemType : Int
): BaseOrderDetailItem(OrderDetailType.TYPE_ORDER)