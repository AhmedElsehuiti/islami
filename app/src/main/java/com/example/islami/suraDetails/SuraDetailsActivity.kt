package com.example.islami.suraDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
class SuraDetailsActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        textView=findViewById(R.id.title_text_view)
        initRecyclerView()

        val sura_name:String=   intent.getStringExtra(Constants.EXTRA_SURA_NAME) as String
        val sura_pos =  intent.getIntExtra(Constants.EXTRA_SURA_pos,-1)
        textView.text=sura_name
        readSuraFile(sura_pos)

    }
    private fun readSuraFile(pos:Int){
        //pos+1.txt
        val fileName="${pos+1}.txt"
        val fileContent =  assets.open(fileName).bufferedReader().use { it.readText() }
        val verses:List<String> =fileContent.split("\n")
        adapter.changData(verses )

        //show verses in recyclerView


    }
    private fun initRecyclerView(){
        recyclerView=findViewById(R.id.recyclerView3)
        adapter = VersesAdapter()
        recyclerView.adapter=adapter

    }
}