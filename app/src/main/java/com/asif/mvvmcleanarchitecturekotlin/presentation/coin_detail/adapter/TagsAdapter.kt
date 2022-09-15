package com.asif.mvvmcleanarchitecturekotlin.presentation.coin_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asif.mvvmcleanarchitecturekotlin.databinding.ItemTagsListBinding

class TagsAdapter(
    private var tagsItemList: List<String>
) : RecyclerView.Adapter<TagsAdapter.TagViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {

        val binding =
            ItemTagsListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        val name = tagsItemList[position]

        holder.bindItems(name)

    }

    override fun getItemCount(): Int {
        return tagsItemList.size
    }

    inner class TagViewHolder(private val binding: ItemTagsListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(
            name: String
        ) {
            binding.tvTag.text = name
        }
    }
}