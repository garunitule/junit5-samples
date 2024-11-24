package money;

import java.util.Map
import java.util.HashMap


class Bank {
    private var rates: HashMap<Pair, Int> = HashMap<Pair, Int>()

    fun reduce(source: Expression, to: String): Money {
        return source.reduce(this, to)
    }

    fun addRate(from: String, to: String, rate: Int) {
        rates.put(Pair(from, to), rate)
    }

    fun rate(from: String, to: String): Int {
        if (from.equals(to)) {
            return 1
        }

        val rate = rates.get(Pair(from, to))
        if (rate == null) {
            throw IllegalArgumentException("Invalid currency conversion rate")
        }
        return rate
    }
}