package com.example.islami.hadethDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R


class HadehDetailsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HadethDetailsAdapter
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        setSupportActionBar(findViewById(R.id.toolbar2))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        textView = findViewById(R.id.hadeth_tv)
        initRecyclerView()
        val hadethName: String = intent.getStringExtra(ConstantsHdeath.EXTRA_HADEH_NAME) as String
        val hadethPos = intent.getIntExtra(ConstantsHdeath.EXTRA_HADEH_pos, -1)
        textView.text = hadethName
        readHadethFile(hadethPos)
    }

    private fun readHadethFile(pos: Int) {
        //pos+1.txt
        val fileName = "h${pos + 1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val hadeth: List<String> = fileContent.split("\n")
        adapter.updateDate(hadeth)
    }
    private fun initRecyclerView(){
        recyclerView =findViewById(R.id.recyclerView5)
        adapter=HadethDetailsAdapter()
        recyclerView.adapter=adapter

    }
}
