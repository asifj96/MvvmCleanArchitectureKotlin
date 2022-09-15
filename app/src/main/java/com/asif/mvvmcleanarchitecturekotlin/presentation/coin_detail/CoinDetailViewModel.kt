package com.asif.mvvmcleanarchitecturekotlin.presentation.coin_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asif.mvvmcleanarchitecturekotlin.common.Resource
import com.asif.mvvmcleanarchitecturekotlin.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase
) : ViewModel() {

    private val _state: MutableLiveData<CoinDetailState> = MutableLiveData()
    val state: MutableLiveData<CoinDetailState> = _state


    fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->

            when (result) {

                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}