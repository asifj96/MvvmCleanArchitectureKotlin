package com.asif.mvvmcleanarchitecturekotlin.presentation.coin_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asif.mvvmcleanarchitecturekotlin.data.remote.dto.TeamMember
import com.asif.mvvmcleanarchitecturekotlin.databinding.ItemTeamMemberListBinding

class TeamsAdapter(
    private var teamMemberList: List<TeamMember>
) : RecyclerView.Adapter<TeamsAdapter.TeamMemberViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberViewHolder {

        val binding =
            ItemTeamMemberListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TeamMemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamMemberViewHolder, position: Int) {
        val teamMemberObj = teamMemberList[position]

        holder.bindItems(teamMemberObj)

    }

    override fun getItemCount(): Int {
        return teamMemberList.size
    }

    inner class TeamMemberViewHolder(private val binding: ItemTeamMemberListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(
            teamMemberObj: TeamMember
        ) {
            binding.tvName.text = teamMemberObj.name
            binding.tvPosition.text = teamMemberObj.position
        }
    }
}