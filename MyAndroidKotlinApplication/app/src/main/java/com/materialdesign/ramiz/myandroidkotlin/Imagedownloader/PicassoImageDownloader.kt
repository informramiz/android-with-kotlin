package com.materialdesign.ramiz.myandroidkotlin.Imagedownloader

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by ramiz on 11/6/17.
 * This specific ImageDownloader implementation uses
 * picasso to library
 */
open class PicassoImageDownloader : ImageDownloader {
    override fun loadImage(context: Context, url: String, imageView: ImageView) {
        Picasso
                .with(context)
                .load(url)
                .error(android.R.drawable.ic_delete)
                .resize(1200, 800)
                .into(imageView)
    }

}