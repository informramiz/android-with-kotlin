package com.materialdesign.ramiz.myandroidkotlin

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.v4.view.GestureDetectorCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.Window
import com.materialdesign.ramiz.myandroidkotlin.Imagedownloader.ImageDownloaderSingleton

import kotlinx.android.synthetic.main.activity_full_image.*
import kotlinx.android.synthetic.main.content_full_image.*

class FullImageActivity : AppCompatActivity(){
    companion object {
        val EXTRA_URL = "image_url"
    }

    private var mSimpleGestureDetector: GestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imageUrl = intent.getStringExtra(EXTRA_URL)
        ImageDownloaderSingleton.loadImage(this, imageUrl, fullImageView)

        mSimpleGestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener(){
            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                toggleImmersiveMode()
                return true
            }
        })

        registerListeners()
        enterImmersiveMode()
    }

    private fun registerListeners() {
        this.window.decorView.setOnSystemUiVisibilityChangeListener { it ->
            //system bars will only be "visible" if none of the
            // LOW_PROFILE, HIDE_NAVIGATION, or FULLSCREEN flags are set.
            if ((it and View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                //The system bars are visible. Make any desired
                // adjustments to your UI, such as showing the action bar or
                // other navigational controls.
                supportActionBar?.show()
            } else {
                supportActionBar?.hide()
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mSimpleGestureDetector?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onDestroy() {
        super.onDestroy()
        exitImmersiveMode()
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private fun isSystemUiVisible(): Boolean {
        return window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_IMMERSIVE != View.SYSTEM_UI_FLAG_IMMERSIVE
    }

    private fun toggleImmersiveMode() {
        when(isSystemUiVisible()) {
            true -> enterImmersiveMode()
            else -> exitImmersiveMode()
        }

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private fun enterImmersiveMode() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                or View.SYSTEM_UI_FLAG_IMMERSIVE
                )
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private fun exitImmersiveMode() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }
}
