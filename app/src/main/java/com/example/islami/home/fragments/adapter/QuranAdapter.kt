package com.example.islami.home.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class QuranAdapter(private var items:List<String>):RecyclerView.Adapter<QuranAdapter.SettingAdapter>() {
    class SettingAdapter(itemView:View):RecyclerView.ViewHolder(itemView){
        val textView :TextView=itemView.findViewById(R.id.chapter_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingAdapter {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chapter_name,parent,false)
        return SettingAdapter(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SettingAdapter, position: Int) {
        val suraName = items[position]
        holder.textView.text = suraName
        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position,suraName)

            }

        }
    }
    var onItemClickListener : OnItemClickListener?=null
    interface OnItemClickListener{
        fun onItemClick(position: Int,name:String)
    }
}