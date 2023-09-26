package com.example.islami.home.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class HadethAdapter(var items:List<String> ) :RecyclerView.Adapter<HadethAdapter.SettingAdapter>(){
    class SettingAdapter(ItemView:View) :RecyclerView.ViewHolder(ItemView){
        var itemHadethName:TextView=itemView.findViewById(R.id.item_hadeth_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingAdapter {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeth_name,parent,false)
        return SettingAdapter(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SettingAdapter, position: Int) {
        val hadethName = items[position]
        holder.itemHadethName.text=hadethName
        if (onHadethClickListener!=null){
            holder.itemView.setOnClickListener {
                onHadethClickListener?.onHadethClick(position,hadethName)
            }
        }
    }
    var onHadethClickListener:OnHadethClickListener?=null
    interface OnHadethClickListener{
        fun onHadethClick(position: Int,name:String)
    }
}