package com.example.mytestcripto

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mytestcripto.adapters.CoinInfoAdapter
import com.example.mytestcripto.databinding.ActivityCoinPriceListBinding
import com.example.mytestcripto.pojo.CoinPriceInfo

class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    private val binding by lazy {
        ActivityCoinPriceListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter(this)
//        adapter.onCoinClickListener= object : CoinInfoAdapter.OnCoinClickListener{
//            override fun onClick(coinPriceInfo: CoinPriceInfo) {
//                Log.d("InfoAboutOneCoin", "Инфо: ${coinPriceInfo.fromsymbol}")
//            }
//        }
        binding.rvCoinPriceList.adapter=adapter
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this) {
           adapter.coinInfoList=it
        }

    }

}