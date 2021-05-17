package com.ardnn.mymanga

import android.app.Activity
import android.content.res.TypedArray

object ComicsData {
    private val dataset = arrayListOf<ArrayList<String>>()
    private lateinit var comicImages: TypedArray
    private lateinit var comicWallpapers: TypedArray
    val favoriteComicsMap = mutableMapOf<String, Boolean>()

    fun getDataset(context: Activity, filename: String) {
        // get comic's data (string)
        val text = context.assets.open(filename).bufferedReader().use {
            it.readText()
        }
        val comics = text.split("\n").toList()
        for (i in comics.indices) {
            val data = comics[i].split(";").toList()
            dataset.add(data as ArrayList<String>)
        }

        // get comic's images and wallpapers
        comicImages = context.resources.obtainTypedArray(R.array.comic_images)
        comicWallpapers = context.resources.obtainTypedArray(R.array.comic_wallpapers)

    }

    val listData: ArrayList<Comic>
        get() {
            val list = arrayListOf<Comic>()
            for (i in dataset.indices) {
                val comic = Comic(
                    dataset[i][0],
                    dataset[i][1],
                    dataset[i][2],
                    dataset[i][3],
                    dataset[i][4],
                    comicImages.getResourceId(i, -1),
                    comicWallpapers.getResourceId(i, -1)
                )

                list.add(comic)
            }

            return list
        }

}