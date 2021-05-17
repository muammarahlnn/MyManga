package com.ardnn.mymanga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ProfileActivity : AppCompatActivity() {

    // widgets
    private lateinit var btnBack: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var clBiodata: ConstraintLayout

    // animations
    private lateinit var animTopToBottom: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // initialization
        btnBack = findViewById(R.id.iv_back_profile)
        tvTitle = findViewById(R.id.tv_title_about)
        clBiodata = findViewById(R.id.cl_biodata_profile)
        animTopToBottom = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom)

        // set animation
        btnBack.animation = animTopToBottom
        tvTitle.animation = animTopToBottom
        clBiodata.animation = animTopToBottom

        // if btn back clicked
        btnBack.setOnClickListener {
            finish()
        }
    }
}