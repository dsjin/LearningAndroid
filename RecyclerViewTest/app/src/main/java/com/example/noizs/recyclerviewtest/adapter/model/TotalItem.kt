package com.example.noizs.recyclerviewtest.adapter.model

import com.example.noizs.recyclerviewtest.adapter.BaseOrderDetailItem
import com.example.noizs.recyclerviewtest.adapter.OrderDetailType

data class TotalItem(
    val totalPrice : String
): BaseOrderDetailItem(OrderDetailType.TYPE_TOTAL)