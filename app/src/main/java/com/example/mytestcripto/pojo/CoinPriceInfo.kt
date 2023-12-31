package com.example.mytestcripto.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mytestcripto.api.ApiFactory.BASE_IMAGE_URL
import com.example.mytestcripto.utils.convertTimestampToRealTime
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String? = null,

    @SerializedName("MARKET")
    @Expose
    val market: String? = null,
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromsymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val tosymbol: String? = null,


    @SerializedName("LASTMARKET")
    @Expose
    val lastmarket: String? = null,

    @SerializedName("PRICE")
    @Expose
    val price: Double = 0.0,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastupdate: Int = 0,

    @SerializedName("IMAGEURL")
    @Expose
    val imageurl: String? = null
){
    fun getFormattedTime() : String{
       return convertTimestampToRealTime(lastupdate.toLong())
    }
    fun getFullImageUrl() : String{
        return BASE_IMAGE_URL + imageurl
    }
}