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

        //tryKotlinLoops()
//        tryWhen()
//        tryRanges()
//        tryLambdaExpressions()
//        tryPojo()
//        tryExtensions()
        tryNullSafety()
    }

    private fun tryLambdaExpressions() {
        addTextViewWithText("Testing Lambdas on Collections...", gravity = Gravity.START)

        val items = listOf("orange", "banana", "apple", "strawberry", "grapes", "olive")
        items
                .filter { it.startsWith("o") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { addTextViewWithText(it) }
    }

    private fun tryRanges() {
        val x = 5
        val y = 9

        if (x in 1..y) {
            textView.text = "$x fits in range 0-$y"
        }


        //iterating over ranges, cool?
        addTextViewWithText("Forward range(1-5)", Gravity.START)

        for (i in 1..5) {
            addTextViewWithText(i)
        }

        //iterate backward
        //iterating over ranges, cool?
        addTextViewWithText("Backward range(10-0) with step 2", Gravity.START)

        for (i in 10 downTo 0 step 2) {
            //iterating over ranges, cool?
            addTextViewWithText("$i")
        }
    }

    private fun addTextViewWithText(value: Any, gravity: Int = Gravity.CENTER) {
        //let's call some old java style code
        //and add a custom view at run time
        val newTextView = TextView(this)
        newTextView.gravity = gravity
        rootLayout.addView(newTextView)
        newTextView.text = "$value"
    }

    private fun tryWhen() {
        textView.text = "Description of string : ${describe(1)}"
    }

    private fun describe(obj: Any): String {
        return when (obj) {
            1 -> "one"
            "Ramiz" -> " Raja"
            is Long -> "is Long"
            !is String -> "not String"
            else -> "I don't know"
        }
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

    //create a POJO, it's that easy really?
    data class User(val name: String, val email: String)

    private fun tryPojo() {
        val user1 = User("Ramiz Raja", "informramiz@gmail.com")
        addTextViewWithText("POJO User info: ${user1.name} has email ID ${user1.email}", gravity = Gravity.START)

        val user2 = User ("Ramiz Raja", "informramiz@gmail.com")
        addTextViewWithText("user1 == user2 ? ${user1 == user2}")
    }

    //try extensions
    fun String.myUpperCase(): String {
        return this.toUpperCase();
    }

    private fun tryExtensions() {
        val str = "This is my string".myUpperCase()
        addTextViewWithText("Testing extensions...", gravity = Gravity.START)
        addTextViewWithText("My custom uppper case extensions: $str")
    }

    private fun tryNullSafety() {
        val str: String? = "This can be null"

        textView.text = str?.let{"String is not null"} ?: "String is null" 
    }
}
