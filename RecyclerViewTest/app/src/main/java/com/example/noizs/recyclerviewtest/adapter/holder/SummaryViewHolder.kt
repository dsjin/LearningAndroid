package com.example.noizs.recyclerviewtest.adapter.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noizs.recyclerviewtest.R
class SummaryViewHolder : RecyclerView.ViewHolder{
    var tvSummaryName : TextView
    var tvSummaryPrice : TextView
    constructor(itemView : View) : super(itemView){
        tvSummaryName = itemView.findViewById(R.id.tv_summary_name)
        tvSummaryPrice = itemView.findViewById(R.id.tv_summary_price)
    }
}