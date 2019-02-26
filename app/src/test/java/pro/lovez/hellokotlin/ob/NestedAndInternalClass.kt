package pro.lovez.hellokotlin.ob

import org.junit.Test


class NestedAndInternalClass {

    @Test
    fun main() {


    }

}

class Outer {
    private val bar: Int = 1

    //可以内部类
    class Nested {
        fun foo() = 2
    }
}