package com.materialdesign.ramiz.myandroidkotlin.ImageDownloader

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by ramiz on 11/6/17.
 */
open class PicassoImageDownloader : ImageDownloader {
    override fun loadImage(context: Context, url: String, imageView: ImageView) {
        Picasso
                .with(context)
                .load(url)
                .error(android.R.drawable.ic_delete)
                .into(imageView)
    }

}