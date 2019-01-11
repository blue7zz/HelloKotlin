package pro.lovez.hellokotlin

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

//        KotlinUnitNo1.baseType()
//        KotlinUnitNo1.foo()
//        KotlinUnitNo1.base()

        val ab: A = object : A(1), B {
            override fun sun(): Int {
                print("hahha")
                return 1111
            }

            override var x: Int = 2
        }


        if (ab is B) {
            println("是B")
        }

        if(ab is A){
            println("是A")
        }

        KotlinUnitNo1.DataProviderManage.hahahahah()

    }


    open class A(x: Int) {
        open val y: Int = x
    }

    interface B {
        var x: Int
        fun sun(): Int
    }

}
