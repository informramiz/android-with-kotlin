package com.materialdesign.ramiz.myandroidkotlin.ImageDownloader

import android.content.Context
import android.widget.ImageView

/**
 * Created by ramiz on 11/6/17.
 * Defining it as inteface to add a layer betwee
 * actual image downloading library and my code
 * so that code can be easily switched between different
 * image downloaders.
 */
interface ImageDownloader {
    fun loadImage(context: Context, url: String, imageView: ImageView)
}