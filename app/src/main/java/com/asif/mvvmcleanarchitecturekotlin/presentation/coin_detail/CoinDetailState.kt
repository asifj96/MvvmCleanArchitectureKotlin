package com.asif.mvvmcleanarchitecturekotlin.presentation.coin_detail

import com.asif.mvvmcleanarchitecturekotlin.domain.model.CoinDetail


data class CoinDetailState(

    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""

)
