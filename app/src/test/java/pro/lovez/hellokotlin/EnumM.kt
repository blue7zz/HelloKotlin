package pro.lovez.hellokotlin

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class EnumM {
    A,B,C,D
}

enum class EnumH(val rgb: Int){
    RED(0xFF00000),
    GREEN(0xFF00FF),
    BLUE(0x0000FFF)
}

enum class ProtocolState{
    WAITING{
      override  fun signal() = TALKING
    },TALKING{
        override fun signal() = WAITING
    };

    abstract fun signal():ProtocolState

}

enum class IntArithemetics:BinaryOperator<Int>,IntBinaryOperator{
    PLUS {
        override fun apply(p0: Int, p1: Int) = p0 + p1
    },TIMES{
        override fun apply(p0: Int, p1: Int) = p0 * p1
    };

    override fun applyAsInt(p0: Int, p1: Int) = apply(p0, p1)
}