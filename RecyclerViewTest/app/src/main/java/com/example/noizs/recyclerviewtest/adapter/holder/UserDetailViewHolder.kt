package com.example.noizs.recyclerviewtest.adapter.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noizs.recyclerviewtest.R

class UserDetailViewHolder : RecyclerView.ViewHolder{
    var name : TextView
    constructor(itemView : View) : super(itemView){
        name = itemView.findViewById(R.id.tv_user_name)
    }
}