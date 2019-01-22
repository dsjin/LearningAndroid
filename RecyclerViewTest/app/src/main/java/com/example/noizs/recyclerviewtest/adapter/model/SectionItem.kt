package com.example.noizs.recyclerviewtest.adapter.model

import com.example.noizs.recyclerviewtest.adapter.BaseOrderDetailItem
import com.example.noizs.recyclerviewtest.adapter.OrderDetailType

data class SectionItem(
    val section : String,
    val color : Int
) : BaseOrderDetailItem(OrderDetailType.TYPE_SECTION)