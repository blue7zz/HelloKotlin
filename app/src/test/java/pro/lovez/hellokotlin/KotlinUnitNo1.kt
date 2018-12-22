package pro.lovez.hellokotlin //包声明

//as 避免引用多个同样名称的类，重命名
import pro.lovez.hellokotlin.R as bR


/**
 * 基础 <br/>
 *
 * 1.基础类型
 *
 */
class KotlinUnitNo1{


    companion object {
        var double:Double = 1.0
        var float:Float = 1.0f
        var long:Long = 1L //需要用L标记
        var int:Int = 1
        var short:Short = 1
        var byte:Byte = 1


        //十六进制 0f
        var hexadecimal:Int = 0x0f
        //二进制
        var binary:Int = 0b00001011

        /**
         * 1.基础类型
         */
        fun baseType(){
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
        fun packing(){
            val b:Int = 1
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
        fun ifWhenForWhile(){
            System.out.println("-------------if start-------------")
            //1.传统用法
            //2.with else
            //3.表达式用法
            

            System.out.println("-------------if end-------------")
        }



    }

}