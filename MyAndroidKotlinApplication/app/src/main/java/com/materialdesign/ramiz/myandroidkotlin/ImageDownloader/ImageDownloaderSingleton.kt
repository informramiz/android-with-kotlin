package com.materialdesign.ramiz.myandroidkotlin.ImageDownloader

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by ramiz on 11/6/17.
 * Defining a layer on top of
 */

object ImageDownloaderSingleton {
    //this should be injected with Dagger2 but may
    //be for a later day

    //Do you see the benefit of ImageDownloader interface???
    //We can just plugin a different image downloader and other
    //code in app will not need a single line of code change. Cool na?
    private val imageDownloader: ImageDownloader = PicassoImageDownloader()

    fun loadImage(context: Context, url: String, imageView: ImageView) {
        imageDownloader.loadImage(context, url, imageView)
    }
}