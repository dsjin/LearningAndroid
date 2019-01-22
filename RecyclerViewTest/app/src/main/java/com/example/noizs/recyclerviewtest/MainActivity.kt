package com.example.noizs.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noizs.recyclerviewtest.adapter.*
import com.example.noizs.recyclerviewtest.adapter.model.OrderItem
import com.example.noizs.recyclerviewtest.network.FakeNetwork
import com.example.noizs.recyclerviewtest.network.Food
import com.example.noizs.recyclerviewtest.network.OrderDetail



class MainActivity : AppCompatActivity() {
    var rvOrderDetail : RecyclerView? = null
    var orderAdapter : OrderAdapter? = null
    var orderDetail : OrderDetail? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        setUpView()
        callService()
    }

    private fun callService() {
        FakeNetwork.getFakeOrderDetail(object : FakeNetwork.OnResultCallback{
            override fun onOrderDetailCallback(orderDetail : OrderDetail?) {
                this@MainActivity.orderDetail = orderDetail
                val orderDetailList = getOrderDetail()
                val empty : ArrayList<BaseOrderDetailItem> = ArrayList()
                update(empty , orderDetailList)
            }
        })
    }

    private fun update(oldOrderDetailList: ArrayList<BaseOrderDetailItem>, newOrderDetailList: ArrayList<BaseOrderDetailItem>) {
        orderAdapter?.setOrderItemList(newOrderDetailList)
        val diffResult : DiffUtil.DiffResult = DiffUtil.calculateDiff(OrderListDiffCallback(oldOrderDetailList, newOrderDetailList))
        diffResult.dispatchUpdatesTo(orderAdapter!!)
    }

    private fun getOrderDetail() : ArrayList<BaseOrderDetailItem> {
        val name = "Sleeping For Less"
        val yourOrderTitle = getString(R.string.your_order)
        val summaryTitle = getString(R.string.summary)

        val foodTitle = getString(R.string.food)
        val bookTitle = getString(R.string.book)
        val musicTitle = getString(R.string.music)
        val currency = getString(R.string.baht_unit)

        val orderDetailItemList : ArrayList<BaseOrderDetailItem> = ArrayList()
        orderDetailItemList.add(OrderDetailConverter.createUserDetail(name)!!)
        orderDetailItemList.add(OrderDetailConverter.createTitle(yourOrderTitle)!!)
        if (isOrderDetailAvaliable(orderDetail)){
            orderDetailItemList.addAll(OrderDetailConverter.createSectionAndOrder(orderDetail, foodTitle, bookTitle, musicTitle, currency)!!)
            orderDetailItemList.add(OrderDetailConverter.createTitle(summaryTitle)!!)
            orderDetailItemList.add(OrderDetailConverter.createTotal(orderDetail, currency)!!)
            orderDetailItemList.add(OrderDetailConverter.createNotice()!!)
            orderDetailItemList.add(OrderDetailConverter.createButton()!!)
        }else{
            orderDetailItemList.add(OrderDetailConverter.createNoOrder()!!)
            orderDetailItemList.add(OrderDetailConverter.createTitle(summaryTitle)!!)
            orderDetailItemList.add(OrderDetailConverter.createTotal(orderDetail, currency)!!)
        }
        orderDetailItemList.add(OrderDetailConverter.createEmpty()!!)

        return orderDetailItemList
    }

    fun removeItem(orderItem: OrderItem?) : Boolean{
        orderDetail?.let{
            orderItem?.let {
                when(orderItem.itemType){
                    OrderType.TYPE_BOOK -> {
                        val filteredElement = orderDetail?.book_list?.filter { book -> book.id == orderItem.id }
                        if (filteredElement!!.isNotEmpty()){
                            val index = orderDetail?.book_list?.indexOf(filteredElement[0])
                            val arrayList = orderDetail?.book_list as ArrayList
                            arrayList.removeAt(index!!)
                            return true
                        }
                    }
                    OrderType.TYPE_FOOD -> {
                        val filteredElement = orderDetail?.food_list?.filter { food -> food.id == orderItem.id }
                        if (filteredElement!!.isNotEmpty()){
                            val index = orderDetail?.food_list?.indexOf(filteredElement[0])
                            val arrayList = orderDetail?.food_list as ArrayList
                            arrayList.removeAt(index!!)
                            return true
                        }
                    }
                    OrderType.TYPE_MUSIC -> {
                        val filteredElement = orderDetail?.music_list?.filter { music -> music.id == orderItem.id }
                        if (filteredElement!!.isNotEmpty()){
                            val index = orderDetail?.music_list?.indexOf(filteredElement[0])
                            val arrayList = orderDetail?.music_list as ArrayList
                            arrayList.removeAt(index!!)
                            return true
                        }
                    }
                }
            }
        }
        return false
    }

    private fun isOrderDetailAvaliable(orderDetail: OrderDetail?): Boolean{
        orderDetail?.let{
            val checkBook = orderDetail.book_list != null && orderDetail.book_list.isNotEmpty()
            val checkMusic = orderDetail.music_list != null && orderDetail.music_list.isNotEmpty()
            val checkFood = orderDetail.food_list != null && orderDetail.food_list.isNotEmpty()
            return checkBook || checkMusic || checkFood
        }
        return false
    }

    private fun setUpView() {
        rvOrderDetail?.layoutManager = LinearLayoutManager(this)
        orderAdapter = OrderAdapter()
        rvOrderDetail?.adapter = orderAdapter
        orderAdapter?.setItemClickListener(object : OrderAdapter.OnItemClickListener{
            override fun onPositiveButtonClick() {
                Toast.makeText(this@MainActivity, "Positive Button Clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onNegativeButtonClick() {
                Toast.makeText(this@MainActivity, "Negative Button Clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onRemoveItem(orderItem: OrderItem) {
                val oldOrderList = getOrderDetail()
                if(removeItem(orderItem)){
                    update(oldOrderList, getOrderDetail())
                }
            }
        })
    }

    private fun bindView() {
        rvOrderDetail = findViewById(R.id.rv_order_detail)
    }
}
