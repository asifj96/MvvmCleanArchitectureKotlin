package com.asif.mvvmcleanarchitecturekotlin.presentation.coin_list

import com.asif.mvvmcleanarchitecturekotlin.domain.model.Coin


data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""

)
