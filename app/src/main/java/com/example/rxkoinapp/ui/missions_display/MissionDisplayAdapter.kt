package com.example.rxkoinapp.ui.missions_display

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rxkoinapp.databinding.MissionsItemBinding
import com.example.rxkoinapp.domain.Mission

class MissionDisplayAdapter: ListAdapter<Mission, MissionDisplayAdapter.MissionDisplayViewHolder>
    (MissionDisplayDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionDisplayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MissionsItemBinding.inflate(inflater, parent, false)
        return MissionDisplayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MissionDisplayViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MissionDisplayViewHolder(private val binding: MissionsItemBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun bind(item: Mission){
                binding.missionName.text = item.missionName
                binding.missionWebsite.text = item.website
            }
        }
}

class MissionDisplayDiffCallback(): DiffUtil.ItemCallback<Mission>(){
    override fun areItemsTheSame(oldItem: Mission, newItem: Mission): Boolean {
        return oldItem.missionId == newItem.missionId
    }

    override fun areContentsTheSame(oldItem: Mission, newItem: Mission): Boolean {
        return (oldItem.missionName == newItem.missionName &&
                oldItem.website == newItem.website)
    }
}