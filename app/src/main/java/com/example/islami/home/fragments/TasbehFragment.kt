package com.example.islami.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islami.R

class TasbehFragment :Fragment(){
private lateinit var tasbehName:Button
private lateinit var imageRotate :ImageView
private lateinit var tasbehNumber:TextView
private lateinit var click:TextView

private var generalCounter=0
private var counter=0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasbehName = view.findViewById(R.id.bu_tasgeh_name)
        imageRotate = view.findViewById(R.id.sebha_rotat)
        tasbehNumber = view.findViewById(R.id.tv_tasbeh_num)
        click = view.findViewById(R.id.click_tv)
        click.setOnClickListener {
            val clk_rotate = AnimationUtils.loadAnimation(
                requireActivity(),R.anim.rotate
            )
            imageRotate.startAnimation(clk_rotate)
            counter++
            generalCounter++
            when (generalCounter) {
                33 -> {
                    counter=0
                    tasbehName.text = "الحمد لله"
                }
                66 -> {
                    counter=0
                    tasbehName.text = "الله اكبر"
                }
                100 -> {
                    counter = 0
                    generalCounter=0
                    tasbehName.text = "سبحان الله"
                }
            }
            tasbehNumber.text = counter.toString()




        }
    }
}