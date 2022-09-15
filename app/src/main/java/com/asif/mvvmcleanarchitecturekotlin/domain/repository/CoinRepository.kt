package com.asif.mvvmcleanarchitecturekotlin.domain.repository

import com.asif.mvvmcleanarchitecturekotlin.data.remote.dto.CoinDetailDto
import com.asif.mvvmcleanarchitecturekotlin.data.remote.dto.CoinDto


interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}