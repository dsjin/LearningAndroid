package com.example.noizs.recyclerviewtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.noizs.recyclerviewtest.R
import com.example.noizs.recyclerviewtest.adapter.holder.*
import com.example.noizs.recyclerviewtest.adapter.model.*



class OrderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var orderDetailItemList : ArrayList<BaseOrderDetailItem>
    private var onItemClickListener : OnItemClickListener?

    init {
        orderDetailItemList = ArrayList()
        onItemClickListener = null
    }

    fun setOrderItemList(orderDetailItemList: ArrayList<BaseOrderDetailItem>){
        this.orderDetailItemList = orderDetailItemList
    }

    fun setItemClickListener(listener: OnItemClickListener){
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            OrderDetailType.TYPE_USER_DETAIL -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_user_detail, parent, false)
                return UserDetailViewHolder(view)
            }
            OrderDetailType.TYPE_TITLE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_title, parent, false)
                return TitleViewHolder(view)
            }
            OrderDetailType.TYPE_SECTION -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_section, parent, false)
                return SectionViewHolder(view)
            }
            OrderDetailType.TYPE_ORDER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_order, parent, false)
                return OrderViewHolder(view)
            }
            OrderDetailType.TYPE_SUMMARY -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_summary, parent, false)
                return SummaryViewHolder(view)
            }
            OrderDetailType.TYPE_TOTAL -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_total, parent, false)
                return TotalViewHolder(view)
            }
            OrderDetailType.TYPE_NOTICE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_notice, parent, false)
                return NoticeViewHolder(view)
            }
            OrderDetailType.TYPE_BUTTON -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_button, parent, false)
                return ButtonViewHolder(view)
            }
            OrderDetailType.TYPE_EMPTY -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_empty, parent, false)
                return EmptyViewHolder(view)
            }
            OrderDetailType.TYPE_NO_ORDER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_no_order, parent, false)
                return NoOrderViewHolder(view)
            }
        }
        throw NullPointerException("View Type $viewType doesn't match with any existing order detail type")
    }

    override fun getItemCount(): Int {
        return orderDetailItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = orderDetailItemList[position]
        if (holder is UserDetailViewHolder){
            setupUserDetail(item as UserDetailItem, holder)
        }else if(holder is TitleViewHolder){
            setupTitle(item as TitleItem, holder)
        }else if(holder is SectionViewHolder){
            setupSection(item as SectionItem, holder)
        }else if(holder is OrderViewHolder){
            setupOrderDetail(item as OrderItem, holder)
        }else if(holder is SummaryViewHolder){
            setupSummary(item as SummaryItem, holder)
        }else if(holder is TotalViewHolder){
            setupTotal(item as TotalItem, holder)
        }else if(holder is NoticeViewHolder){
            setupNotice(item as NoticeItem, holder)
        }else if(holder is ButtonViewHolder){
            setupButton(item as ButtonItem, holder)
        }else if(holder is EmptyViewHolder){
            setupEmpty(item as EmptyItem, holder)
        }else if(holder is NoOrderViewHolder){
            setupNoOrder(item as NoOrderItem, holder)
        }
    }

    private fun setupNoOrder(noOrderItem: NoOrderItem, holder: NoOrderViewHolder) {

    }

    private fun setupEmpty(emptyItem: EmptyItem, holder: EmptyViewHolder) {

    }

    private fun setupButton(buttonItem: ButtonItem, holder: ButtonViewHolder) {
        holder.btnNegative.setOnClickListener{
            onItemClickListener?.onNegativeButtonClick()
        }
        holder.btnPositive.setOnClickListener{
            onItemClickListener?.onPositiveButtonClick()
        }
    }

    private fun setupNotice(noticeItem: NoticeItem, holder: NoticeViewHolder) {
    }

    private fun setupTotal(totalItem: TotalItem, holder: TotalViewHolder) {
        holder.tvTotalPrice.text = totalItem.totalPrice
    }

    private fun setupSummary(summaryItem: SummaryItem, holder: SummaryViewHolder) {
        holder.tvSummaryName.text = summaryItem.name
        holder.tvSummaryPrice.text = summaryItem.price
    }

    private fun setupOrderDetail(orderItem: OrderItem, holder: OrderViewHolder) {
        holder.tvOrderName.text = orderItem.name
        holder.tvOrderDetail.text = orderItem.detail
        holder.tvOrderPrice.text = orderItem.price
        holder.container.setOnLongClickListener {
            onItemClickListener?.onRemoveItem(orderItem)
            true
        }
    }

    private fun setupSection(sectionItem: SectionItem, holder: SectionViewHolder) {
        holder.section.text = sectionItem.section
        holder.layout.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, sectionItem.color))
    }

    private fun setupTitle(titleItem: TitleItem, holder: TitleViewHolder) {
        holder.title.text = titleItem.title
    }

    private fun setupUserDetail(userDetailItem: UserDetailItem, holder: UserDetailViewHolder) {
        holder.name.text = userDetailItem.name
    }

    override fun getItemViewType(position: Int): Int {
        return orderDetailItemList[position].type
    }

    interface OnItemClickListener {
        fun onPositiveButtonClick()

        fun onNegativeButtonClick()

        fun onRemoveItem(orderItem: OrderItem)
    }
}