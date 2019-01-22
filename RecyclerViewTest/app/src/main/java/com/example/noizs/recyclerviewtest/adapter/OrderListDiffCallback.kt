package com.example.noizs.recyclerviewtest.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.noizs.recyclerviewtest.adapter.model.OrderItem
import com.example.noizs.recyclerviewtest.adapter.model.SectionItem
import com.example.noizs.recyclerviewtest.adapter.model.SummaryItem
import com.example.noizs.recyclerviewtest.adapter.model.TotalItem
import com.example.noizs.recyclerviewtest.network.OrderDetail

class OrderListDiffCallback : DiffUtil.Callback {

    val oldOrderList : List<BaseOrderDetailItem>
    val newOrderList : List<BaseOrderDetailItem>

    constructor(oldOrderList: List<BaseOrderDetailItem>, newOrderList : List<BaseOrderDetailItem>){
        this.newOrderList = newOrderList
        this.oldOrderList = oldOrderList
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newItem = newOrderList[newItemPosition]
        val oldItem = oldOrderList[oldItemPosition]
        if (newItem.type == oldItem.type) {
            if (newItem is SectionItem && oldItem is SectionItem){
                return newItem.section == oldItem.section
            }else if(newItem is OrderItem && oldItem is OrderItem){
                return newItem.id == oldItem.id
            }else if(newItem is SummaryItem && oldItem is SummaryItem){
                return newItem.name == oldItem.name
            }
            return true
        }
        return false
    }

    override fun getOldListSize(): Int {
        return oldOrderList.size
    }

    override fun getNewListSize(): Int {
        return newOrderList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newItem = newOrderList[newItemPosition]
        val oldItem = oldOrderList[oldItemPosition]
        if (newItem.type == oldItem.type) {
            if (newItem is SectionItem && oldItem is SectionItem){
                return newItem.section == oldItem.section && newItem.color == oldItem.color
            }else if(newItem is OrderItem && oldItem is OrderItem){
                return newItem.id == oldItem.id && newItem.name == oldItem.name && newItem.detail == oldItem.detail && newItem.price == oldItem.price && newItem.itemType == oldItem.itemType
            }else if(newItem is SummaryItem && oldItem is SummaryItem){
                return newItem.name == oldItem.name
            }else if(newItem is TotalItem && oldItem is TotalItem){
                return newItem.totalPrice == oldItem.totalPrice
            }
            return true
        }
        return false
    }
}