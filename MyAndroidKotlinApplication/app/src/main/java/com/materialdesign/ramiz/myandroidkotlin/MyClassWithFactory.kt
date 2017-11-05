package com.materialdesign.ramiz.myandroidkotlin

/**
 * Created by ramiz on 11/5/17.
 */
open class MyClassWithFactory {
    //we need a factory method like static methods in Java
    //companion is the word we are looking for
    companion object Factory{
        fun create(): MyClassWithFactory = MyClassWithFactory()
    }

    fun justForPractice() {
        //call factory method from here
        MyClassWithFactory.create()
    }
}