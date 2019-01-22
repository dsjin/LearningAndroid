package com.example.noizs.recyclerviewtest.adapter.model

import com.example.noizs.recyclerviewtest.adapter.BaseOrderDetailItem
import com.example.noizs.recyclerviewtest.adapter.OrderDetailType

data class UserDetailItem(
    val name : String
) : BaseOrderDetailItem(OrderDetailType.TYPE_USER_DETAIL)