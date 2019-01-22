package com.example.noizs.recyclerviewtest.adapter.holder

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noizs.recyclerviewtest.R
import kotlinx.android.synthetic.main.view_order.view.*
import org.w3c.dom.Text

class OrderViewHolder : RecyclerView.ViewHolder{
    var tvOrderName : TextView
    var tvOrderDetail : TextView
    var tvOrderPrice : TextView
    var container : LinearLayout
    constructor(itemView : View) : super(itemView){
        tvOrderName = itemView.findViewById(R.id.tv_order_name)
        tvOrderDetail = itemView.findViewById(R.id.tv_order_detail)
        tvOrderPrice = itemView.findViewById(R.id.tv_order_price)
        container = itemView.findViewById(R.id.ll_order)
    }
}