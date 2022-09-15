package com.asif.mvvmcleanarchitecturekotlin.presentation.coin_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asif.mvvmcleanarchitecturekotlin.common.disableClick
import com.asif.mvvmcleanarchitecturekotlin.databinding.ItemCoinListBinding
import com.asif.mvvmcleanarchitecturekotlin.domain.model.Coin

class CoinListAdapter(
    private var coinsItemList: List<Coin>,
    private val clickItem: (Coin) -> Unit,
) : RecyclerView.Adapter<CoinListAdapter.CoinsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsViewHolder {

        val binding =
            ItemCoinListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CoinsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {
        val coinObj = coinsItemList[position]

        holder.bindItems(coinObj)

    }

    override fun getItemCount(): Int {
        return coinsItemList.size
    }

    inner class CoinsViewHolder(private val binding: ItemCoinListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(
            coinObj: Coin
        ) {
            binding.tvRank.text = "${coinObj.rank}."
            binding.tvName.text = coinObj.name
            binding.tvSymbol.text = "(${coinObj.symbol})"
            binding.tvStatus.text = if (coinObj.isActive) {
                "active"
            } else {
                "inactive"
            }

            binding.root.setOnClickListener {
                if (disableClick()) {
                    clickItem.invoke(coinObj)
                }
            }
        }
    }
}