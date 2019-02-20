package pro.lovez.hellokotlin.ob


/**
 *  1. var 可变  val只读
 *  2. Getters 与 Setters
 *  3. 幕后字段 field
 *  4. 幕后属性  不是很懂
 *  5. 编译期常量 const
 *  6. 延迟初始化属性与变量 lateinit 修饰符标记该属性
 **/

class ProjectDemo02 {

    /**
     * 延迟初始化只声明
     */
    lateinit var name: String   // 延迟
    var v: String = "v"
    val l: String = "l"


    var stringRepresentation: String = ""
        get() = this.toString()
        set(value) {
            field = value + "1"
        }


    /**
     * 目前已知 只能在companion object
     *  只能 val
     *  3. 只能String+ 原生类型
     */
    companion object {
        const val SB: String = "你是一个大SB"
    }
}