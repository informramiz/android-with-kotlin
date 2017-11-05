package com.materialdesign.ramiz.myandroidkotlin.common

/**
 * Created by ramiz on 11/5/17.
 */
object CommonUtils {
    //write a generic type function
    fun <T> compare(arr1: Array<T>, arr2: Array<T>): Boolean{
        if (arr1.size != arr2.size) return false

        return arr1.indices.none { arr1[it] != arr2[it] }
    }

    //try a type projection
    fun copy(from: Array<out Any>, to: Array<Any>) {
        //do the copy
    }

    fun tryCopy() {
        val intArray: Array<Int> = arrayOf(1, 2, 3)
        val anyArray = Array<Any>(3) {""}

        copy(intArray, anyArray)
    }
}