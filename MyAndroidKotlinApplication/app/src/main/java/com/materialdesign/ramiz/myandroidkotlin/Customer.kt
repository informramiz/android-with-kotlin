package com.materialdesign.ramiz.myandroidkotlin

/**
 * Created by ramiz on 11/5/17.
 */
class Customer(val id: String, override val name: String, override val age: Int) : Person(name, age) {
    //secondary constructors
    constructor(customer: Customer) : this(customer.id, customer.name, customer.age) {

    }

    constructor(id: String, person: Person) : this(id, person.name, person.age) {

    }

    override fun describe(): String {
        return super.describe().replace("Person", "Customer") + ", and customer id is $id"
    }
}