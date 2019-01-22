package com.example.noizs.recyclerviewtest.adapter

import com.example.noizs.recyclerviewtest.R
import com.example.noizs.recyclerviewtest.adapter.model.*
import com.example.noizs.recyclerviewtest.network.OrderDetail
import com.example.noizs.recyclerviewtest.network.Book
import com.example.noizs.recyclerviewtest.network.Food
import com.example.noizs.recyclerviewtest.network.Music


class OrderDetailConverter{
    companion object {
        fun createUserDetail(name : String) : UserDetailItem? {
            return UserDetailItem(name)
        }

        fun createTitle(yourOrderTitle: String): TitleItem? {
            return TitleItem(yourOrderTitle)
        }

        fun createTotal(orderDetail: OrderDetail?, currency : String): TotalItem? {
            return TotalItem("${getTotalPrice(orderDetail)} $currency")
        }

        fun createNotice(): NoticeItem? {
            return NoticeItem()
        }

        fun createButton(): ButtonItem? {
            return ButtonItem()
        }

        fun createEmpty(): EmptyItem? {
            return EmptyItem()
        }

        fun createNoOrder() : NoOrderItem?{
            return NoOrderItem()
        }

        fun createSectionAndOrder(orderDetail : OrderDetail?, foodTitle : String, bookTitle : String, musicTitle : String, currency : String): List<BaseOrderDetailItem>? {
            val list : ArrayList<BaseOrderDetailItem> = ArrayList()
            orderDetail?.let{
                list.addAll(getFoodOrderDetailList(it.food_list, foodTitle, currency))
                list.addAll(getBookOrderDetailList(it.book_list, bookTitle, currency))
                list.addAll(getMusicOrderDetailList(it.music_list, musicTitle, currency))
            }
            return list
        }

        private fun getFoodOrderDetailList(foodList : List<Food>?, foodTitle: String, currency: String) : List<BaseOrderDetailItem>{
            val foodOrderDetailList : ArrayList<BaseOrderDetailItem> = ArrayList()
            foodList?.let{
                if (it.isNotEmpty()){
                    foodOrderDetailList.add(SectionItem(foodTitle, R.color.sky_light_blue))
                    foodList.forEachIndexed{
                        index, item -> kotlin.run {
                            item.id = "food$index"
                            foodOrderDetailList.add(OrderItem(item.id,item.order_name, "x ${item.amount}", "${item.price} $currency", OrderType.TYPE_FOOD))
                        }
                    }
                }
            }
            return foodOrderDetailList
        }

        private fun getBookOrderDetailList(bookList : List<Book>?, bookTitle : String, currency: String) : List<BaseOrderDetailItem>{
            val bookOrderDetailList : ArrayList<BaseOrderDetailItem> = ArrayList()
            bookList?.let{
                if (it.isNotEmpty()){
                    bookOrderDetailList.add(SectionItem(bookTitle, R.color.funny_dark_pink))
                    bookList.forEachIndexed{
                        index, item -> kotlin.run {
                            item.id = "book$index"
                            bookOrderDetailList.add(OrderItem(item.id ,item.book_name, item.author, "${item.price} $currency", OrderType.TYPE_BOOK))
                        }
                    }
                }
            }
            return bookOrderDetailList
        }

        private fun getMusicOrderDetailList(musicList : List<Music>?, musicTitle : String, currency: String) : List<BaseOrderDetailItem>{
            val musicOrderDetailItem : ArrayList<BaseOrderDetailItem> = ArrayList()
            musicList?.let{
                if (it.isNotEmpty()){
                    musicOrderDetailItem.add(SectionItem(musicTitle, R.color.dark_honest_green))
                    musicList.forEachIndexed{
                        index, item -> kotlin.run {
                            item.id = "music$index"
                            musicOrderDetailItem.add(OrderItem(item.id, item.album, item.artist, "${item.price} $currency", OrderType.TYPE_MUSIC))
                        }
                    }
                }
            }
            return musicOrderDetailItem
        }

        private fun getTotalPrice(orderDetail: OrderDetail?) : Int{
            var sum = 0
            sum += getTotalFoodPrice(orderDetail?.food_list)
            sum += getTotalBookPrice(orderDetail?.book_list)
            sum += getTotalMusicPrice(orderDetail?.music_list)
            return sum
        }

        private fun getTotalFoodPrice(list : List<Food>?) : Int{
            list?.let {
                return it.sumBy { arg -> arg.price }
            }
            return 0
        }

        private fun getTotalBookPrice(list : List<Book>?) : Int{
            list?.let {
                return it.sumBy { arg -> arg.price }
            }
            return 0
        }

        private fun getTotalMusicPrice(list : List<Music>?) : Int{
            list?.let {
                return it.sumBy { arg -> arg.price }
            }
            return 0
        }


        private fun createSummary(orderDetail : OrderDetail?, foodTitle : String, bookTitle : String, musicTitle : String, currency : String) : List<SummaryItem>{
            val list : ArrayList<SummaryItem> = ArrayList()
            orderDetail?.let {
                val foodSummary = getFoodSummary(orderDetail.food_list, foodTitle, currency)
                foodSummary?.let{
                    list.add(foodSummary)
                }
                val bookSummary = getBookSummary(orderDetail.book_list, bookTitle, currency)
                bookSummary?.let{
                    list.add(bookSummary)
                }
                val musicSummary = getMusicSummary(orderDetail.music_list, musicTitle, currency)
                musicSummary?.let {
                    list.add(musicSummary)
                }
            }
            return list
        }

        private fun getFoodSummary(foodList : List<Food>?, foodTitle: String, currency: String) : SummaryItem?{
            foodList?.let {
                if (it.isNotEmpty()){
                    return SummaryItem(foodTitle, "${getTotalFoodPrice(foodList)} $currency")
                }
            }
            return null
        }

        private fun getMusicSummary(musicList : List<Music>?, musicTitle : String, currency: String) : SummaryItem?{
            musicList?.let {
                if (it.isNotEmpty()){
                    return SummaryItem(musicTitle, "${getTotalMusicPrice(musicList)} $currency")
                }
            }
            return null
        }

        private fun getBookSummary(bookList : List<Book>?, bookTitle : String, currency: String) : SummaryItem?{
            bookList?.let {
                if (it.isNotEmpty()){
                    return SummaryItem(bookTitle, "${getTotalBookPrice(bookList)} $currency")
                }
            }
            return null
        }

    }
}