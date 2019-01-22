package com.example.noizs.recyclerviewtest.network

import com.google.gson.annotations.SerializedName

data class OrderDetail(
    @SerializedName("book_list") val book_list: List<Book>?,
    @SerializedName("food_list") val food_list: List<Food>?,
    @SerializedName("music_list") val music_list: List<Music>?
)

data class Music(
    var id : String,
    @SerializedName("album") val album: String,
    @SerializedName("artist") val artist: String,
    @SerializedName("price") val price: Int,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("track") val track: Int
)

data class Book(
    var id : String,
    @SerializedName("ISBN") val ISBN: String,
    @SerializedName("author") val author: String,
    @SerializedName("book_name") val book_name: String,
    @SerializedName("pages") val pages: Int,
    @SerializedName("price") val price: Int,
    @SerializedName("publication") val publication: String,
    @SerializedName("publish_date") val publish_date: String
)

data class Food(
    var id : String,
    @SerializedName("amount") val amount: Int,
    @SerializedName("order_name") val order_name: String,
    @SerializedName("price") val price: Int
)

