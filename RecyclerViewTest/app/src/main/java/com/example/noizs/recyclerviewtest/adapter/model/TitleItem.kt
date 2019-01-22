package com.example.noizs.recyclerviewtest.adapter.model

import com.example.noizs.recyclerviewtest.adapter.BaseOrderDetailItem
import com.example.noizs.recyclerviewtest.adapter.OrderDetailType

data class TitleItem(
    val title : String
) : BaseOrderDetailItem(OrderDetailType.TYPE_TITLE)