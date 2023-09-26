package com.example.islami.suraDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class VersesAdapter:RecyclerView.Adapter<VersesAdapter.ViewHolder>() {
    private var items:List<String>?=null
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var contant :TextView=itemView.findViewById(R.id.sura_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_verse,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items?.size ?:0

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contants:String? =items?.get(position)
        holder.contant.text =contants

    }
    fun changData(verses:List<String>){
        this.items=verses
        notifyDataSetChanged() // reload
    }
}