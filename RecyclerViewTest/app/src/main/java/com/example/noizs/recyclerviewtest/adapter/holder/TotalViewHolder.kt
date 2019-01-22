package com.example.noizs.recyclerviewtest.adapter.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noizs.recyclerviewtest.R

class  TotalViewHolder : RecyclerView.ViewHolder{
    var tvTotalPrice : TextView
    constructor(itemView : View) : super(itemView){
        tvTotalPrice = itemView.findViewById(R.id.tv_total_price)
    }
}