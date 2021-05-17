package com.ardnn.mymanga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnItemClickListener<Comic> {
    // classes
    private lateinit var comicsAdapter: ComicsAdapter

    // widgets
    private lateinit var rvComics: RecyclerView
    private lateinit var btnProfile: ImageView

    // attributes
    private val datasetName: String = "dataset.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get dataset comics from assets folder
        ComicsData.getDataset(this, datasetName)

        // initialize objects
        comicsAdapter = ComicsAdapter()

        // initialize widget
        rvComics = findViewById(R.id.rv_comics_main)

        btnProfile = findViewById(R.id.iv_profile_main)
        btnProfile.setOnClickListener {
            val goToProfile = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(goToProfile)
        }

    }

    override fun onStart() {
        super.onStart()

        comicsAdapter.setClickListener(this)
        comicsAdapter.setComics(ComicsData.listData)

        rvComics.layoutManager = LinearLayoutManager(this)
        rvComics.setHasFixedSize(true)
        rvComics.adapter = comicsAdapter
    }

    override fun onClick(comic: Comic) {
        // go to detail activity
        val goToDetail = Intent(this, DetailActivity::class.java)
        goToDetail.putExtra(DetailActivity.EXTRA_COMICS, comic)
        startActivity(goToDetail)
    }

}