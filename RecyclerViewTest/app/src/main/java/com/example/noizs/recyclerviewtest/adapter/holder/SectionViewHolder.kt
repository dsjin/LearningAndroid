package com.example.noizs.recyclerviewtest.adapter.holder

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noizs.recyclerviewtest.R

class SectionViewHolder : RecyclerView.ViewHolder {
    var section : TextView
    var layout : LinearLayout
    constructor(itemView : View) : super(itemView){
        section = itemView.findViewById(R.id.tv_section)
        layout = itemView.findViewById(R.id.ll_section)
    }
}