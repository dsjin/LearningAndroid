package com.example.noizs.recyclerviewtest.adapter.model

import com.example.noizs.recyclerviewtest.adapter.BaseOrderDetailItem
import com.example.noizs.recyclerviewtest.adapter.OrderDetailType

data class SummaryItem(
    val name : String,
    val price : String
): BaseOrderDetailItem(OrderDetailType.TYPE_SUMMARY)