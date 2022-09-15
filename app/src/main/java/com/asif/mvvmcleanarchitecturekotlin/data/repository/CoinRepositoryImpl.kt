package com.asif.mvvmcleanarchitecturekotlin.data.repository

import com.asif.mvvmcleanarchitecturekotlin.data.remote.CoinPaprikaApi
import com.asif.mvvmcleanarchitecturekotlin.data.remote.dto.CoinDetailDto
import com.asif.mvvmcleanarchitecturekotlin.data.remote.dto.CoinDto
import com.asif.mvvmcleanarchitecturekotlin.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}