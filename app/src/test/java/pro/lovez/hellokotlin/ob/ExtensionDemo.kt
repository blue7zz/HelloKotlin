package pro.lovez.hellokotlin.ob

import org.junit.Test
import pro.lovez.hellokotlin.demo.*;

/**
 *  扩展一个类的新功能无需继承或者使用像装饰者这样的任何类型设计模式，  这种通过叫做 扩展 的特殊声明完成。
 *  Kotlin支持，1：扩展函数 2：扩展属性
 **/

/**
 * 扩展函数
 * 1. 声明一个扩展函数，我们需要用一个 接收者类型 也就是被扩展的类型作为他的前缀
 */
class ExtensionDemo {

    @Test
    fun main() {
        val listInt = mutableListOf(1, 2, 3)
        listInt.swap(0, 1)
        println(listInt)

        val listStr = mutableListOf<String>("123", "321", "4444", "555")
        //listStr.swap(0,1) 调用不了，接收者<泛型> 对应响应的环境
        listStr.swapAll(0, 1)
    }

    /**
     * 接收者      MutableList
     * 扩展函数     swap
     *
     */
    fun MutableList<Int>.swap(index1: Int, index2: Int) {
        println(this.javaClass.simpleName)
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }

    /**
     * 增加全部泛型， 对任何MutableList<T> 起作用
     */
    fun <T> MutableList<T>.swapAll(index1: Int, index2: Int) {
        println(this.javaClass.simpleName)
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }


}


/***
 * 扩展函数是静态解析的
 * 1.扩展函数是静态分发的
 * 2.扩展函数是由函数调用所在的表达式的类型来决定的，而不是由表达式运行时求值结果决定的
 *
 *  虽然下面demo 上传入的是D() ，但是输出的还是printFoo 函数参数 C的foo。 实际调用，取决于成员函数的类型
 *
 * **/

open class C

class D : C()

fun C.foo() = "c"
fun D.foo() = "d"
class ExtensionDemo1 {

    @Test
    fun main() {
        printFoo(D())
    }

    fun printFoo(c: C) {
        println(c.foo())
    }
}


/**
 * 可空接收者
 * 可以为 可空的接收者类型定义扩展。
 * 这样的扩展可以在对象变量上调用。
 */

class ExtensionDemo2 {
    @Test
    fun main() {
        var i: Int? = null
        i.toString()
    }

    fun Any?.toString(): String {
        println("没有？？？？")
        if (this == null) return "null"
        return toString()
    }

    fun Any.toString1(): String {
        println("可为空")
        return toString()
    }
}


/**
 *
 * 扩展属性
 * 伴生对象的扩展
 *  1. 扩展没有实际将成员插入类中，幕后字段是无效的，所有不能有初始化
 *
 *  扩展的作用域
 *  1.本包内自动导入
 *  2.额外包需要手动导入，大多时候我们在顶层定义扩展，就会直接出现在包里
 *
 */


class ExtensionDemo3 {
    @Test
    fun main() {
        ExtensionDemo3.foo()
        var i: Int = 1;
        i.ep()
        i.ep1()
    }

    val <T> List<T>.listIndex: Int
        get() = size - 1
//    val ExtensionDemo3.bar = 10 //扩展属性不能有初始化器  XXXX

    /***
     * 伴生对象的扩展
     */
    companion object {}

    fun ExtensionDemo3.Companion.foo() {
        println("compaion.foo 扩展")
    }
}


/**
 * 扩展声明为成员
 * 在一个类内部你可以为另一个类声明扩展。
 * 在这样的扩展内部，有多个 【隐式接收者】，其中的对象成员可以无需通过限定符访问。
 * 扩展声明所在的类实例 称为 【分发接收者】
 * 扩展方法调用所在的接收者类型的实例称为 【扩展接收者】
 */


class D4 {
    fun bar() {
        println("D4 bar")
    }
}

/**
 * 分发接收者？？
 */
class C4 {
    fun baz() {
        println("C4 baz")
    }

    fun D4.foo() {
        bar()  //无需通过限定符访问 调用D4 bar  隐式接收者 调用D4
        baz()  // 调用 C4.baz         隐式接收者 调用 C4
    }

    /**
     * D4 扩展接收者？
     */
    fun caller(d: D4) {
        d.foo()  //调用扩展函数
    }
}

/**
 *
 */

open class D41 {}

class D411 : D41() {}

open class C41 {
    open fun D41.foo() {
        println("D41.foo in c")
    }

    open fun D411.foo() {
        println("D411.foo in c")
    }

    fun caller(d: D41) {
        d.foo() //调用扩展函数
    }
}

class C411 : C41() {
    override fun D41.foo() {
        println("D41.foo in C411")
    }

    override fun D411.foo() {
        println("D411.foo in C411")
    }

}

class ExntensionDemo4 {
    @Test
    fun main() {
        //因为是静态解析的，所以只能调用D41的 foo方法   D41.fooin c  或者 D41.foo in C411
        C41().caller(D41()) // C41 解析 foo  为 D41.foo in C
        C411().caller(D41())     //C411 解析foo 为 D41.foo in C411
        C41().caller(D411())    //C41解析 foo 为 D41.foo in C
    }
}



