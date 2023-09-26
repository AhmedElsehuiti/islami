package com.example.islami.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.R
import com.example.islami.home.HomeActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val backgroundImage: ImageView=findViewById(R.id.imageView2)
        val slideAnimation =AnimationUtils.loadAnimation(this,R.anim.side_slide)
        backgroundImage.startAnimation(slideAnimation)
        Handler(Looper.getMainLooper())
            .postDelayed({
                         startHomeActivity()
            },2000)
    }

    private fun startHomeActivity() {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}