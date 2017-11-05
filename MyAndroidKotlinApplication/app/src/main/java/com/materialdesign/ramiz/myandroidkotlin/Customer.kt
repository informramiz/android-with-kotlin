package com.materialdesign.ramiz.myandroidkotlin

/**
 * Created by ramiz on 11/5/17.
 */
class Customer(val id: String, override val name: String, override val age: Int) : Person(name, age) {
    //secondary constructor
    constructor(customer: Customer) : this(customer.id, customer.name, customer.age) {

    }
}