package com.example.noizs.recyclerviewtest.adapter.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noizs.recyclerviewtest.R

class TitleViewHolder : RecyclerView.ViewHolder{
    var title : TextView
    constructor(itemView : View) : super(itemView){
        title = itemView.findViewById(R.id.tv_title)
    }
}