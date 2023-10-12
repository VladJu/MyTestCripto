package com.example.mytestcripto.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestcripto.R
import com.example.mytestcripto.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter(
    private val context:Context
    ) : RecyclerView.Adapter<CoinInfoAdapter.CoinViewHolder>() {

    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCoinClickListener : OnCoinClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_coin_info,
            parent,
            false
        )
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder){
            val symbolsTemplate=context.resources.getString(
                R.string.symbols_template
            )
            val lastTimeUpdateTemplate=context.resources.getString(
                R.string.last_time_update_template
            )
            tvSymbols.text= String.format(symbolsTemplate, coin.tosymbol)
            tvPrice.text=coin.price.toString()
            tvLastTimeUpdate.text= String.format(lastTimeUpdateTemplate,coin.getFormattedTime())
            Picasso.get().load(coin.getFullImageUrl()).into(ivLogoCoin)
            itemView.setOnClickListener {
                onCoinClickListener?.onClick(coin)
            }
        }

    }

    override fun getItemCount() = coinInfoList.size

    inner class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivLogoCoin: ImageView = itemView.findViewById(R.id.ivLogoCoin)
        val tvSymbols:  TextView= itemView.findViewById(R.id.tvSymbols)
        val tvPrice: TextView= itemView.findViewById(R.id.tvPrice)
        val tvLastTimeUpdate: TextView= itemView.findViewById(R.id.tvLastTimeUpdate)

    }

    interface OnCoinClickListener{
        fun onClick(coinPriceInfo: CoinPriceInfo)
    }
}