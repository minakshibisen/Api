package com.example.api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api.databinding.ItemDashboardBinding
import com.example.api.ui.DashboardActivity

class DashboardAdapter(dashboardActivity: DashboardActivity) : RecyclerView.Adapter<DashboardAdapter.Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        return Viewholder(
            ItemDashboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder:Viewholder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 0
    }

    class Viewholder(var binding: ItemDashboardBinding):RecyclerView.ViewHolder(binding.root){
    }
}