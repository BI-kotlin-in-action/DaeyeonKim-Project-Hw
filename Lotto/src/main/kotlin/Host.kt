enum class WinnigsRule(val money: Int) {
    FIRST(100000),
    SECOND(5000),
    THIRD(100),
    FOURTH(5),
    LOSE(0),
}

class Host {

    val winNumber = sortedSetOf<Int>()
    val rank = IntArray(6) // 1~4등, 꽝

    // val winnigsRule = mapOf(1 to 100000, 2 to 5000, 3 to 100, 4 to 5)
    var winnigs = 0

    fun setWinNumber() {
        val selectNumber = (1..45).toMutableList() //
        selectNumber.shuffle()
        winNumber.addAll(selectNumber.subList(0, 6))
    }

    fun checkLotto(lotto: Lotto): Int {
        var count = 0
        for (i in 0 until 6) {
            if (winNumber.contains(lotto.lottoNumber.elementAt(i))) {
                count++
            }
        }
        return count
    }

    fun countRank(count: Int) {
        when (count) {
            6 -> rank[1]++
            5 -> rank[2]++
            4 -> rank[3]++
            3 -> rank[4]++
            else -> rank[5]++ // 낙첨
        }
    }

    fun calculateWinnigs() {
        for (i in 1..4) {
            winnigs += rank[i] * WinnigsRule.values()[i - 1].money
            // winnigs += rank[i] * (winnigsRule[i] ?: 0)
        }
    }

    fun printResult() {
        println("--------------------")
        println("당첨 결과")
        for (i in 1..4) {
            println("${i}등 : ${WinnigsRule.values()[i - 1].money}KW -> ${rank[i]}개")
        }
        println("낙첨 : 0KW -> ${rank[5]}개")
        println("--------------------")
        println("총 당첨금 : ${winnigs}KW")
    }

    fun processLotto(lottos: MutableList<Lotto>) {
        lottos.forEach { lotto: Lotto -> countRank(checkLotto(lotto)) }
        calculateWinnigs()
        printResult()
    }
}
