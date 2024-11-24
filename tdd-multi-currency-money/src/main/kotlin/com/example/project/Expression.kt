package money;

interface Expression {
    operator fun plus(addend: Expression): Expression
    fun times(multiplier: Int): Expression
    fun reduce(bank: Bank, to: String): Money
}