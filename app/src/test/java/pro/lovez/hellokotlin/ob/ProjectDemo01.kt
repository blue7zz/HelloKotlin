package pro.lovez.hellokotlin.ob

import org.junit.Test


/**
 * 1. class 声明
 * 2. 构造函数，主构造函数 次构造函数
 * 3. init初始化
 * 4. 继承
 */
class ProjectDemo01 {

    /**
     * 1. class 声明类
     * 2. constructor 构造函数 可以有一个主构造函数或者多个次构造函数，可以省略
     * 3. 次构造函数
     * 4. 初始化代码块 init
     * 5. 构造函数的修饰符 需要加在前面
     */
    class Invoice constructor(firestName: String) {

        /**
         * init
         * init 实际上是主构造函数的一部分
         * 主构造函数不能包含任何代码，初始化代码可以放到i这里作为初始化块
         */
        init {
            println("init block")
            println(firestName)
        }

        /**
         * 次构造函数，this 需要委托给主构造函数
         * name: String = "默认"
         */
        constructor(name: String = "默认", age: Int) : this("") {}

        constructor() : this("1") {
            println("empty init")
        }
    }

    //=================继承 开始=================
    /**
     * 所有类都从超类Any 继承来的
     *  Any 只有这三个函数
     *  1. equals()
     *  2. hashCode()
     *  3. toString()
     *
     *  kotlin 里面默认不可以被别人类继承，需要open 修饰
     */
    open class Example(p: Int) {
        constructor(name: String, age: Int) : this(p = 10)

        init {
            println("super class init")
        }

        open val x: Int
            get() {
                return 1
            }

        open fun nv() {
            println("super nv")
        }
    }

    /**
     * 调用超类的构造，函数，以及属性 是super.??
     * 关于覆盖方法，可以覆盖，超类必须 open进行修饰
     * 继承类必须在方法前加入 override
     */
    class Dericed : Example {
        constructor() : super(name = "小明", age = 10)

        init {
            println("child class init")
        }

        override fun nv() {

        }

        override var x: Int
            get() = super.x
            set(value) {
                x
            }
    }

    open class A {
        open fun f() {
            println("A -- f")
        }
    }

    interface B {
        fun f() {
            println("B -- f")
        }
    }

    /**
     * 如果同时继承和实现接口中有一个方法名称，必须要覆盖这个方法名称
     */
    class C() : A(), B {
        override fun f() {
            super<A>.f()
            super<B>.f()
        }
    }


    @Test
    fun mainTest() {
        //关于val var 两个属性，
        //val 表示只读，只能初始化一次
        //var 可以复写多次，当然覆盖属性是
        val a: Int
        var b: Int

        //1.创建实例
        //关于创建实例的流程是
        //先执行主构造函数初始化init,如果有次构造函数，再执行次构造函数
        //main constructor   ->  constructor
//        val invoice = Invoice()
//        val invoice1 = Invoice("小明")

        //继承
        val dericed = Dericed()
        dericed.x

        //关于派生类初始化顺序

    }


}

//抽象
open class Base {
    open fun f() {}
}

abstract class Dericed : Base() {

}