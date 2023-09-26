package com.example.islami.hadethDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class HadethDetailsAdapter :RecyclerView.Adapter<HadethDetailsAdapter.SettingAdapter>(){
    private var items:List<String>?=null

    class SettingAdapter(itemView:View):RecyclerView.ViewHolder(itemView){
        var hadethDetails:TextView= itemView.findViewById(R.id.hadeth_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingAdapter {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeth_details,parent,false)
        return SettingAdapter(view)
    }

    override fun getItemCount(): Int {
        return items?.size ?:0
    }

    override fun onBindViewHolder(holder: SettingAdapter, position: Int) {
        val  contants:String? =items?.get(position)
        holder.hadethDetails.text=contants
    }
    fun updateDate(hadeth:List<String>){
        this.items=hadeth
        notifyDataSetChanged()
    }
}