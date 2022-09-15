package com.asif.mvvmcleanarchitecturekotlin.data.remote

import com.asif.mvvmcleanarchitecturekotlin.data.remote.dto.CoinDetailDto
import com.asif.mvvmcleanarchitecturekotlin.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CoinPaprikaApi {

    @Headers(
        "Content-Type:application/json",
        "accept:application/json"
    )
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @Headers(
        "Content-Type:application/json",
        "accept:application/json"
    )
    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}