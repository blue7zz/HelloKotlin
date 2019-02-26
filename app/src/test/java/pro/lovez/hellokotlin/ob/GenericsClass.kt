package pro.lovez.hellokotlin.ob

import org.junit.Test
import java.lang.StringBuilder
import java.util.*

class GenericsClass {

    /**
     * 简单的泛型
     */
    class Box<T>(t: T) {
        var value = t
    }


    @Test
    fun main() {

        /**
         * 这里<Int> 可以省略，因为可以从参数推断出来具体的泛型
         */
        val box = Box<Int>(1)


        val ints = arrayOf(1, 2, 3)
        val any = Array<Any>(3) { "" }

        //期望的是 Array<Any>
        //copy(ints, any)
        val stringBuilder: CharSequence = StringBuilder("123")
        fill(arrayOf(ExntensionDemo4()), "")
        fill(arrayOf(stringBuilder), "")

    }

    /**
     * in ??
     */
    fun fill(dest: Array<in String>, value: String) {
//        in String 有什么用？
        dest.get(0)
    }

    fun copy(from: Array<Any>, to: Array<Any>) {
        assert(from.size == to.size)
        for (i in from.indices) {
            to[i] = from[i]
        }
    }


    /**
     * 型变 - Java类型系统中最棘手的部分之一是通配类型。
     *  为什么Java需要那些神秘的通配符？？
     *  Effection Java：利用有限制通配符来提升API的灵活性
     *
     *  你只能从中 读取 的对生称为生产者(Extens)
     *      List<? extends Foo>
     *  你只能 写入的对象为消费者(Super)
     *      List<? super String>

     * Kotlin中没有，通配符类型
     *
     * 1. 声明处型变(declaration-site variance)
     * 2. 类型投影(type projections)
     *
     *
     *  out - 型变注解  生产？
     *  in - 逆变 ： 只可以被消费而不可以被生产  消费？
     *
     */

    fun demo(strs: Source<String>) {
        //Source<String> >> Source<Any>
        val obejcts: Source<Any> = strs  // 这个没问题，因为T是一个out参数
    }

    fun demo1(x: Comparable<Number>) {
        x.compareTo(1.0) // 1.0 拥有类型Double 它是Number的子类型
        //因此，我们可以将x赋值给类型为 Comparable<Double>的变量
        //Double:Number
        //Comparable<Number> -> Comparable<Double> ???
        val y: Comparable<Double> = x //OK

    }

    fun demo2(x: Comparable<A>) {
        x.compareTo(A1())
    }


    //<? super T>
    // 必须是他的父类？？？？
    fun demo3(x: Comparable<A>) {
        x.compareTo(A1())
        x.compareTo(A())
//        x.compareTo(Base1())
    }
}

open class Base1 {

}

open class A : Base1() {
}

open class A1 : A() {
}


interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

/**
 * source 确保它仅从Source<T>成员中返回，生产
 *
 * out T   ==  <? extends String>   ?参数必须是String的子类？  上界
 * in T  == <? super String>        ? 是 String 的父类？   下界
 *
 */
interface Source<out T> {
    fun nextT(): T
}


/**
 * 星投影
 *
 * Nothing
 *
 * 有时你想说，你对类型参数一无所知，但仍然希望以安全的方式使用它。
 *
 * 1.Foo<out T: TUpper> T是一个具有上界Tupper的协变类型参数   Foo<*> == Foo<out Tupper>
 *
 * 2.Foo<in T>, T是一个逆变类型参数  Foo<*> 等价于 Foo<in Nothing> 这意味着当T 未知时，没有什么可以安全的方式写入Foo<*>
 *
 * 3.对于 Foo<T : Tupper> 其中T是一个具有上界Tupper的不型变类型参数，
 *      Foo<*>对于读取值时等价于Foo<out Tupper>
 *      而对于写值时等价于Foo<in Nothing>
 *
 *
 *  interface Function <in T,out U>
 *  1. Function<*,String>  ==  Fuction<in Nothing,String>
 *  2. Function<Int,*>  == Function<Int,out Any?>
 *  3. Function<*,*>   == Function<in Nothing,out Any?>
 *
 */


//泛型函数
class Genericsf {
    // 这里T
    fun <T> singletonList(item: T): List<T> {
        return arrayListOf()
    }

    fun <T> T.basicToString(): String {
        //扩展函数
        return ""
    }

}



