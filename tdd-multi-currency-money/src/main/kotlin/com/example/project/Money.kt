package money;

open class Money(
    open val amount: Int,
    open val currency: String
): Expression {
    fun currency(): String {
        return currency
    }

    override fun times(multiplier: Int): Expression {
        return Money(amount * multiplier, currency)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Money) {
            return false
        }
        val money = other as Money
        return amount == money.amount 
            && currency == money.currency
    }

    override fun reduce(bank: Bank, to: String): Money {
        val rate = bank.rate(currency, to)
        return Money(amount / rate, to)
    }

    companion object {
        fun dollar(amount: Int): Money {
            return Money(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Money(amount, "CHF")
        }
    }

    override operator fun plus(addend: Expression): Expression {
        return Sum(this, addend)
    }
}