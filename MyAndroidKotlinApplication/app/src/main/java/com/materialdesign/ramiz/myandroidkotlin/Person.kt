package com.materialdesign.ramiz.myandroidkotlin

import android.util.Log

/**
 * Created by ramiz on 11/5/17.
 */

class Person(val name: String, val age: Int) {
    val customerKey = name.toUpperCase()

    //secondary constructor
    constructor(person: Person) : this(person.name, person.age) {

    }

    init {
        Log.i(javaClass.simpleName, "Person initialized with name $name and age $age")
    }
}