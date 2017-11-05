package com.materialdesign.ramiz.myandroidkotlin

/**
 * Created by ramiz on 11/5/17.
 */
open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") }
    fun c() { print("c") }
}

//inheriting from both A and B will
//result in ambiguity for function f(),
//how do we result it then? Let's see
open class C: A(), B {
    //we have to override function f()
    //to resolve ambiguity
    override fun f() {
        //this is how selected super class can be called
        super<A>.f()
        super<B>.f()
        print("C")
    }
}