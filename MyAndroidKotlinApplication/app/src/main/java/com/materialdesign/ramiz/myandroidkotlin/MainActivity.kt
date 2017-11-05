package com.materialdesign.ramiz.myandroidkotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity: AppCompatActivity() {

    var x = 1 //inferred type will be Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Fab clicked", Snackbar.LENGTH_SHORT);
        }

        tryKotlinLoops()
    }

    private fun tryKotlinLoops() {
        val items = listOf("I ", "am ", "Ramiz ", "Raja")
        //let's try kotlin loops
        var str: String = ""
        for (item in items) {
            str += item
        }
        textView.text = "String concatenated in loop is: $str"

        //if we need index? Still easy
        for (index in items.indices) {
            //let's call some old java style code
            //and add a custom view at run time
            val newTextView = TextView(this)
            newTextView.gravity = Gravity.CENTER
            rootLayout.addView(newTextView)

            newTextView.text = "Item at $index is ${items[index]}"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun sumXY(x: Int, y: Int): Int = x + y

    fun maxOf(x: Int, y: Int) = if (x > y) x else y

    fun returnInt(): Int? {
        return null
    }

    fun returnStringLength(obj: Any): Int? {
        //type check
        if (obj !is String) return null

        //now obj is automatically type casted to String type
        //due to check above
        return obj.length
    }
}
