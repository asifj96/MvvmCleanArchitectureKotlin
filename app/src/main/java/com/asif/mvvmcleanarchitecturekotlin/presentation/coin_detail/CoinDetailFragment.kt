package com.asif.mvvmcleanarchitecturekotlin.presentation.coin_detail

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asif.mvvmcleanarchitecturekotlin.R
import com.asif.mvvmcleanarchitecturekotlin.data.remote.dto.TeamMember
import com.asif.mvvmcleanarchitecturekotlin.databinding.FragmentCoinDetailBinding
import com.asif.mvvmcleanarchitecturekotlin.presentation.coin_detail.adapter.TagsAdapter
import com.asif.mvvmcleanarchitecturekotlin.presentation.coin_detail.adapter.TeamsAdapter

class CoinDetailFragment : Fragment() {

    private val coinDetailViewModel: CoinDetailViewModel by activityViewModels()
    private lateinit var mBinding: FragmentCoinDetailBinding
    private val args: CoinDetailFragmentArgs by navArgs()
    private lateinit var tagsAdapter: TagsAdapter
    private lateinit var teamsAdapter: TeamsAdapter


    fun CoinDetailFragment() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_coin_detail, container, false)

        coinDetailViewModel.getCoin(args.coinId)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressDialog = ProgressDialog(context)
        progressDialog.setCancelable(false)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Loading ...")

        coinDetailViewModel.state.observe(viewLifecycleOwner) { state ->
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

                    state.coin.let { coinObj ->

                        coinObj?.let {
                            mBinding.tvRank.text = "${coinObj.rank}. "
                            mBinding.tvName.text = coinObj.name
                            mBinding.tvSymbol.text = "(${coinObj.symbol})"
                            mBinding.tvStatus.text = if (coinObj.isActive) {
                                "active"
                            } else {
                                "inactive"
                            }
                            mBinding.tvDescription.text = coinObj.description

                            coinObj.tags.let { name ->
                                if (name != null) {
                                    setTagsAdapter(name)
                                }
                            }

                            coinObj.team?.let { teamMemberArrayList ->
                                setTeamMemberAdapter(teamMemberArrayList)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setTagsAdapter(tagsArrayList: List<String>) {
        val gridLayoutManager = GridLayoutManager(
            requireContext(), 2, RecyclerView.VERTICAL,
            false
        )
        mBinding.tvTagsHeader.text = "Tags"
        mBinding.tvError.visibility = View.GONE
        mBinding.tvTagsHeader.visibility = View.VISIBLE
        mBinding.rvTagsListItem.visibility = View.VISIBLE
        mBinding.rvTagsListItem.layoutManager = gridLayoutManager
        mBinding.rvTagsListItem.itemAnimator = DefaultItemAnimator()
        tagsAdapter =
            TagsAdapter(
                tagsArrayList
            )
        mBinding.rvTagsListItem.adapter = tagsAdapter
    }

    private fun setTeamMemberAdapter(teamMemberArrayList: List<TeamMember>) {
        if (teamMemberArrayList.isNotEmpty()) {
            mBinding.tvError.visibility = View.GONE
            mBinding.tvTeamHeader.visibility = View.VISIBLE
            mBinding.tvTeamHeader.text = "Team Member"
            mBinding.rvTeamListItem.visibility = View.VISIBLE
            mBinding.rvTeamListItem.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            mBinding.rvTeamListItem.itemAnimator = DefaultItemAnimator()
            teamsAdapter =
                TeamsAdapter(
                    teamMemberArrayList
                )
            mBinding.rvTeamListItem.adapter = teamsAdapter
        }
    }
}