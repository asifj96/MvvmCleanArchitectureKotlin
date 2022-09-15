package com.asif.mvvmcleanarchitecturekotlin.presentation.coin_list.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asif.mvvmcleanarchitecturekotlin.R
import com.asif.mvvmcleanarchitecturekotlin.databinding.FragmentCoinListBinding
import com.asif.mvvmcleanarchitecturekotlin.domain.model.Coin
import com.asif.mvvmcleanarchitecturekotlin.presentation.coin_list.CoinListViewModel
import com.asif.mvvmcleanarchitecturekotlin.presentation.coin_list.adapter.CoinListAdapter
import timber.log.Timber

class CoinListFragment : Fragment() {
    private lateinit var mBinding: FragmentCoinListBinding

    private val coinListViewModel: CoinListViewModel by activityViewModels()
    private lateinit var coinListAdapter: CoinListAdapter

    fun CoinListFragment() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_coin_list, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val progressDialog = ProgressDialog(context)
        progressDialog.setCancelable(false)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Loading ...")

        coinListViewModel.state.observe(viewLifecycleOwner) { state ->
            state?.let {

                if (state.error.isNotBlank()) {
                    if (progressDialog.isShowing)
                        progressDialog.dismiss()

                    mBinding.tvError.visibility = View.VISIBLE
                    mBinding.tvError.text = state.error
                }
                if (state.isLoading) {
                    progressDialog.show()
                } else {
                    progressDialog.dismiss()
                    setCoinListAdapter(
                        it.coins
                    )
                }
            }
        }

    }

    private fun setCoinListAdapter(coinsArrayList: List<Coin>) {
        if (coinsArrayList.isNotEmpty()) {
            mBinding.tvError.visibility = View.GONE
            mBinding.rvCoinListItem.visibility = View.VISIBLE
            mBinding.rvCoinListItem.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            mBinding.rvCoinListItem.itemAnimator = DefaultItemAnimator()
            coinListAdapter =
                CoinListAdapter(
                    coinsArrayList, ::onCoinsCallback
                )
            mBinding.rvCoinListItem.adapter = coinListAdapter
        }
    }

    private fun onCoinsCallback(coin: Coin) {

        val action = CoinListFragmentDirections.actionCoinListFragmentToCoinDetailFragment(coin.id)
        findNavController().navigate(action)
    }
}