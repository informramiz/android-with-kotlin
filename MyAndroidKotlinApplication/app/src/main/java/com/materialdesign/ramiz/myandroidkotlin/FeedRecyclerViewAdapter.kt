package com.materialdesign.ramiz.myandroidkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.materialdesign.ramiz.myandroidkotlin.Imagedownloader.ImageDownloaderSingleton

/**
 * Created by ramiz on 11/6/17.
 */
class FeedRecyclerViewAdapter(val context: Context, val imageUrls: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mOnClickListener: FeedOnClickListener? = null

    override fun getItemCount(): Int {
        return imageUrls.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.list_item_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is FeedViewHolder) {
            ImageDownloaderSingleton.loadImage(context, imageUrls[position], holder.imageView)
        }
    }

    fun setOnClickListener(onClickListener: FeedOnClickListener?) {
        this.mOnClickListener = onClickListener
    }

    class FeedViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView!!.findViewById(R.id.feedCardImageView)
    }

    interface FeedOnClickListener {
        fun onClick(position: Int)
    }
}