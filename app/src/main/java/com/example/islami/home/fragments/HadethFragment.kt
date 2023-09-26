package com.example.islami.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.hadethDetails.ConstantsHdeath
import com.example.islami.hadethDetails.HadehDetailsActivity
import com.example.islami.home.fragments.adapter.HadethAdapter

class HadethFragment:Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HadethAdapter
    private lateinit var itemList: MutableList<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
          initRecyclerView()
        recyclerView.adapter = adapter

    }

    private fun createSettingItem() {
        itemList = mutableListOf()
        for (i in 1..50) {
            val hadethNum = " حديث رقم $i"
            itemList.add(hadethNum)
        }
    }

    private fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.recyclerView4)
        createSettingItem()
        adapter = HadethAdapter(itemList)
        adapter.onHadethClickListener = object : HadethAdapter.OnHadethClickListener {
            override fun onHadethClick(position: Int, name: String) {
              //  Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()
                showSuraDetails(position,name)
            }
        }
    }
    fun showSuraDetails(pos:Int,name:String){
        val intent=Intent(requireContext(),HadehDetailsActivity::class.java)
        intent.putExtra(ConstantsHdeath.EXTRA_HADEH_NAME,name)
        intent.putExtra(ConstantsHdeath.EXTRA_HADEH_pos,pos)
        startActivity(intent)

    }
}