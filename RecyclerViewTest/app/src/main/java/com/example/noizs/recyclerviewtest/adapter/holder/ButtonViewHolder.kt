package com.example.noizs.recyclerviewtest.adapter.holder

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.noizs.recyclerviewtest.R

class ButtonViewHolder : RecyclerView.ViewHolder {
    var btnPositive : Button
    var btnNegative : Button
    constructor(itemView : View) : super(itemView){
        btnPositive = itemView.findViewById(R.id.btn_positive)
        btnNegative = itemView.findViewById(R.id.btn_negative)
    }
}