package com.ardnn.mymanga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import com.github.florent37.shapeofview.shapes.ArcView
import com.github.florent37.shapeofview.shapes.CircleView
import com.github.florent37.shapeofview.shapes.RoundRectView

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_COMICS = "extra_comics"
    }

    // widgets
    private lateinit var tvDetailTitle: TextView
    private lateinit var tvDetailAuthor: TextView
    private lateinit var tvDetailPublisher: TextView
    private lateinit var tvDetailSynopsis: TextView
    private lateinit var ivDetailImage: ImageView
    private lateinit var ivDetailWallpaper: ImageView
    private lateinit var ivFavorite: ImageView
    private lateinit var btnFavorite: CircleView
    private lateinit var btnBack: CircleView
    private lateinit var btnHome: Button
    private lateinit var avDetailWallpaper: ArcView
    private lateinit var rrvDetailImage: RoundRectView

    // animations
    private lateinit var animTopToBottom: Animation
    private lateinit var animBottomToTop: Animation
    private lateinit var animLeftToRight: Animation
    private lateinit var animRightToLeft: Animation
    private lateinit var llDetailData: LinearLayout
    
    // attributes
    private lateinit var comic: Comic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // get comic object from previous intent
        comic = intent.getParcelableExtra<Comic>(EXTRA_COMICS) as Comic

        // add isFavorite attributes to map
        if (ComicsData.favoriteComicsMap[comic.title.toString()] == null) {
            ComicsData.favoriteComicsMap[comic.title.toString()] = false
        }

        // initialize widgets
        tvDetailTitle = findViewById(R.id.tv_detail_title)
        tvDetailAuthor = findViewById(R.id.tv_detail_author)
        tvDetailPublisher = findViewById(R.id.tv_detail_publisher)
        tvDetailSynopsis = findViewById(R.id.tv_detail_synopsis)

        ivDetailImage = findViewById(R.id.iv_detail_image)
        ivDetailWallpaper = findViewById(R.id.iv_detail_wallpaper)
        ivFavorite = findViewById(R.id.iv_favorite_detail)

        btnHome = findViewById(R.id.btn_home_detail)
        btnBack = findViewById(R.id.cv_back_detail)
        btnFavorite = findViewById(R.id.cv_favorite_detail)

        avDetailWallpaper = findViewById(R.id.av_detail_wallpaper)
        rrvDetailImage = findViewById(R.id.rrv_detail_image)
        llDetailData = findViewById(R.id.ll_detail_data)

        // set widgets content
        tvDetailTitle.text = comic.title
        tvDetailAuthor.text = comic.author
        tvDetailPublisher.text = comic.publisher
        tvDetailSynopsis.text = comic.synopsis

        ivDetailImage.setImageResource(comic.image)
        ivDetailWallpaper.setImageResource(comic.wallpaper)

        ivFavorite.setImageResource(
            if (!ComicsData.favoriteComicsMap[comic.title]!!)
                R.drawable.ic_favorite_white
            else
                R.drawable.ic_favorite_blue
        )



        // load animations
        animTopToBottom = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom)
        animBottomToTop = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top)
        animLeftToRight = AnimationUtils.loadAnimation(this, R.anim.left_to_right)
        animRightToLeft = AnimationUtils.loadAnimation(this, R.anim.right_to_left)

        // run animations
        avDetailWallpaper.animation = animTopToBottom
        rrvDetailImage.animation = animLeftToRight
        btnBack.animation = animLeftToRight
        btnFavorite.animation = animRightToLeft
        tvDetailTitle.animation = animRightToLeft
        llDetailData.animation = animBottomToTop
        tvDetailSynopsis.animation = animBottomToTop

        // if button clicked
        btnBack.setOnClickListener(this)
        btnFavorite.setOnClickListener(this)
        btnHome.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cv_back_detail -> {
                finish()
            }
            R.id.cv_favorite_detail -> {
                if (!ComicsData.favoriteComicsMap[comic.title]!!) {
                    ivFavorite.setImageResource(R.drawable.ic_favorite_blue)
                    Toast.makeText(this, "You liked ${tvDetailTitle.text}", Toast.LENGTH_SHORT).show()
                    ComicsData.favoriteComicsMap[comic.title.toString()] = true
                } else {
                    ivFavorite.setImageResource(R.drawable.ic_favorite_white)
                    Toast.makeText(this, "You disliked ${tvDetailTitle.text}", Toast.LENGTH_SHORT).show()
                    ComicsData.favoriteComicsMap[comic.title.toString()] = false
                }
            }
            R.id.btn_home_detail -> {
                finish()
            }
        }
    }

}