package com.ardnn.mymanga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    // widgets
    private lateinit var tvMyComics: TextView
    private lateinit var tvSlogan: TextView
    private lateinit var ivLogoComics: ImageView

    // animations
    private lateinit var animSplash: Animation
    private lateinit var animBottomToTop: Animation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // initialize widgets
        tvMyComics = findViewById(R.id.tv_mycomics_splash)
        tvSlogan = findViewById(R.id.tv_slogan_splash)
        ivLogoComics = findViewById(R.id.iv_logo_comics_splash)

        // load animations
        animSplash = AnimationUtils.loadAnimation(this, R.anim.splash_logo)
        animBottomToTop = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top)

        // run animation
        tvMyComics.animation = animSplash
        ivLogoComics.animation = animSplash
        tvSlogan.animation = animBottomToTop

        // set timer for 1.5 second
        Handler(Looper.getMainLooper()).postDelayed({
            val goToMain: Intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(goToMain)
            finish()
        }, 1500)
    }
}