package com.materialdesign.ramiz.myandroidkotlin

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Created by ramiz on 11/5/17.
 */

open class MyCustomView : View {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    //let's define some inner class
    inner class MyInnerClass {
        //but how do we access super class from inner class?
        //easy pizy, just try super@super-class-name
        fun doSome() {
            super@MyCustomView.toString()
        }
    }
}