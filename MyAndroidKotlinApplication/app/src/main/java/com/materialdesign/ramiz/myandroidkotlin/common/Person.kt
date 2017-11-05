package com.materialdesign.ramiz.myandroidkotlin.common

import android.util.Log

/**
 * Created by ramiz on 11/5/17.
 */

open class Person(open val name: String, open val age: Int) {

    //secondary constructor
    constructor(person: Person) : this(person.name, person.age) {

    }

    open fun describe(): String {
        return "Person name is $name, age is $age"
    }

    init {
        Log.i(javaClass.simpleName, "Person initialized with name $name and age $age")
    }
}