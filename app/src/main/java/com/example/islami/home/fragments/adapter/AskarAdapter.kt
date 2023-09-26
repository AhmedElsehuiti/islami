package com.example.islami.home.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.home.fragments.items.SettingItems

class AskarAdapter(private var items:List<SettingItems>):RecyclerView.Adapter<AskarAdapter.SettingAdapter>() {

    class SettingAdapter(itemView:View):RecyclerView.ViewHolder(itemView){
        val azkar_title:TextView =itemView.findViewById(R.id.azkar_name)
        val number_of_azkar:TextView=itemView.findViewById(R.id.number_of_azker)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingAdapter {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_azkar,parent,false)
        return SettingAdapter(view)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: SettingAdapter, position: Int) {
        val item = items[position]
        holder.azkar_title.text = item.azkar_title
        holder.number_of_azkar.text = item.number_of_azkar.toString()
        if(onAzkarClickListener!=null){
            holder.itemView.setOnClickListener {
                onAzkarClickListener?.onAzkarClick(position,item)
            }
        }
    }
    var onAzkarClickListener:OnAzkarClickListener?=null
    interface OnAzkarClickListener{
        fun onAzkarClick(pos:Int,azkarName:SettingItems)
    }

}