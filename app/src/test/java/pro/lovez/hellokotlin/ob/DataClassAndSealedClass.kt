package pro.lovez.hellokotlin.ob

import org.junit.Test


/**
 **     数据类和密封类
 **/


class DataClass {

    @Test
    fun main() {
        val xiaoming = User("小明", 15)
        val xiaodai = User("小呆", 16)
        val copyXiaoMing = User("小明", 15)
        val copyxiaodai = xiaodai.copy()

        //编译器从主构造函数中声明的所有属性导出以下成员

        //按声明顺序对应于所有属性
        xiaoming.component1()
        xiaoming.component2()


        if (xiaoming.equals(copyXiaoMing)) {
            println("同等")
        } else {
            println("不一样")
        }

        if (xiaoming.equals(xiaodai)) {
            println("小呆同等")
        } else {
            println("小呆和小明不一样")
        }

        println(xiaoming.toString())
        println(xiaodai.toString())
        println(copyxiaodai.toString())
        var user = UserDefault()

        //复制
        val jack = User(name = "jack", age = 1)
        val olderJack = jack.copy(age = 2)

        //解构
        val jane = User("Jane", 35)
        val (name, age) = jane
        val (name1, age1) = jane  //按照顺序进行解构
        println("$name    $age")
        println("$name1    $age1")

    }

}

data class User(val name: String, val age: Int) {

}

data class UserDefault(val name: String = "默认", val age: Int = 0) {
    var age1: Int = 0
}


/**
 *  sealed
 * 密封类
 *  受限的类继承结构：当一个值为有限集中的类型，而不能有任何其他类型时。
 *  在某种意义上，他们是枚举类的扩展：枚举类型的值集合也是受限的
 *  但每个枚举常量只能存在一个实例，而密封类的一个子类可以有可包含状态的多个实例
 * **/


/**
 * 密封类 自身 抽象的，不能直接实例化
 *
 * 不允许有非 private构造函数（构造函数默认为private）
 *
 *
 * 好处： 使用when表达式的时候，如果
 */
sealed class Expr

data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NOtANumber : Expr()


/**
 * 密封类有一个好处，可以把所有的条件都限制的死死的，
 *
 * 没有有限类以外的其他类，所以导致，你不会出错
 */
class SealedClass {

    @Test
    fun main() {
        val const1 = Const(1.00)
        val const2 = Const(1.222)
        println(eval(Sum(const1, const2)))

    }


    fun eval(expr: Expr): Double = when (expr) {
        is Const -> expr.number
        is Sum -> eval(expr.e1) + eval(expr.e2)
        NOtANumber -> Double.NaN
    }
}