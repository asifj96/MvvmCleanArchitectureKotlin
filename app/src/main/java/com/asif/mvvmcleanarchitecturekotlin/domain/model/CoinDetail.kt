package com.asif.mvvmcleanarchitecturekotlin.domain.model

import com.asif.mvvmcleanarchitecturekotlin.data.remote.dto.TeamMember


data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>? = null,
    val team: List<TeamMember>? = null
)
