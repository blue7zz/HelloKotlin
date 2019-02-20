package pro.lovez.hellokotlin.ob


/**
 * 接口
 * 1. 实现接口
 * 2. 接口中的属性
 * 3. 接口继承
 * 4. 解决覆盖冲突
 *
 */
class ProjectDemo03 {

    interface A {
        fun foo() {
            print("A foo")
        }
    }

    interface A1 {
        fun foo() {
            print("A1 foo")
        }
    }

    interface B : A, A1 {
        override fun foo() {
        }
    }

}