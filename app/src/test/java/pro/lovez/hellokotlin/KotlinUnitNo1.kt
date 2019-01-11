package pro.lovez.hellokotlin

//包声明

//as 避免引用多个同样名称的类，重命名
import pro.lovez.hellokotlin.R as bR


/**
 * 基础 <br/>
 *
 * 1.基础类型
 *
 */
class KotlinUnitNo1 {
//    const val s:String = ""


    object DataProviderManage {
        const val s: String = "123123"
        val s1: String = ""

        fun hahahahah() {
            var exampleUnitTest =ExampleUnitTest()

            exampleUnitTest.goo1()
            exampleUnitTest.goo2()
            exampleUnitTest.goo3()
        }


    }

    /**
     * 有一个构造函数，多个次构造函数
     *
     * 默认自带一个没有参数的构造函数
     */
    class classDemo constructor() {


        var name: String = "111"
            get() {
                return "1"
            }

        init {
            var d = DataProviderManage.s1
//            println("类初始化1")
//            DataProviderManage.hahahahah()
//            DataProviderManage.hello()


            var naa = null




            println(DataProviderManage.lastIndex)
        }

        val DataProviderManage.lastIndex:String
        get() = "${s} hahaha"

        fun Any?.toString(): String {
            if (this == null) return "null11"
            return toString()
        }

        fun DataProviderManage.hello() {
            print("我是扩展函数Hello")
        }


        fun testFuc() {

        }


        init {
            println("类初始化2")
        }

    }

    /**
     * 1.怎么创建类
     * 2.类的构造函数
     * 3.类的初始化函数
     * 4.
     */
    class classDemo1 private constructor(var ara: String, val ra: String) {
        init {
            println("类初始化")
        }

        constructor(a: Int) : this("123", "123") {

        }

    }


    companion object {

        var double: Double = 1.0
        var float: Float = 1.0f
        var long: Long = 1L //需要用L标记
        var int: Int = 1
        var short: Short = 1
        var byte: Byte = 1


        //十六进制 0f
        var hexadecimal: Int = 0x0f
        //二进制
        var binary: Int = 0b00001011

        fun base() {
            val derived = Derived("zhang", "jinchao")

            val classD = classDemo()
            classD.name = "123"
            var b = classD.name
        }

        /**
         * 1.基础类型
         */
        fun baseType() {
            System.out.println("type\tBitWidth\tMin\t\t\t\t\t\tMax")
            System.out.println("double\t64\t\t\t${Double.MIN_VALUE}\t\t\t\t${Double.MAX_VALUE}")
            System.out.println("float\t64\t\t\t${Float.MIN_VALUE}\t\t\t\t\t${Float.MAX_VALUE}")
            System.out.println("long\t64\t\t\t${Long.MIN_VALUE}\t${Long.MAX_VALUE}")
            System.out.println("Int\t\t64\t\t\t${Int.MIN_VALUE}\t\t\t\t${Int.MAX_VALUE}")
            System.out.println("Short\t64\t\t\t${Short.MIN_VALUE}\t\t\t\t\t${Short.MAX_VALUE}")
            System.out.println("byte\t64\t\t\t${Byte.MIN_VALUE}\t\t\t\t\t${Byte.MAX_VALUE}")
            //字面常量
            System.out.println("\n")
            System.out.println("--------------------------------------------------")
            System.out.println("十六进制：$hexadecimal")
            System.out.println("二进制：$binary")
            System.out.println("--------------------------------------------------")
        }

        /**
         * 基础类型转换
         */
        fun packing() {
            val b: Int = 1
            b.toString()
            b.toByte()
            b.toInt()
            b.toLong()
            ///......

        }


        /**
         * 1.if
         *  在 Kotlin 中，if是一个表达式，即它会返回一个值。因此就不需要三元运算符(条件 ? 然后 : 否则)，因为 普通的 if 就能胜任这个⻆色。
         * 2.when
         * 3.for
         * 4.while
         */
        fun ifWhenForWhile() {
            System.out.println("-------------if start-------------")
            //1.传统用法
            var x = 1
            var y = 2

            if (x * y == 2) {
                System.out.println("-------------x*y==2-------------")
            } else {
                System.out.println("-------------x*y!=2-------------")
            }

            var xx = if (x * y == 2) y else x
            //2.表达式用法
            System.out.println("-------------if end-------------")
            when (x) {
                1 -> print("x == 1")
            }
        }

        /**
         *
         */
        fun foo() {
            var list = listOf(1, 2, 3, 4, 5)
            for (item in list) {
                if (item == 3) {
                    continue
                }
            }

            //只能return
            list.forEach(fun(value: Int) {
                if (value == 3) return@forEach
                println(value)

            })


        }


    }

}

open class Base(val name: String) {
    init {
        println("Initialzizing Base")
    }

    open val size: Int = name.length.also { println("Initialzizing size in Base: $it") }
}

class Derived(name: String, val lastName: String) : Base(name.capitalize().also { println("Argument for Base: $it") }) {
    init {
        println("Initializing Derived")
    }

    override val size: Int = (super.size + lastName.length).also {
        println("Initializing size in Derived: $it")
    }

}

