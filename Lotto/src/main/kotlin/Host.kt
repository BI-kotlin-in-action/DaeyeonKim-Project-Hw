
class Host {
    enum class WinningsCal(val money: Int, var count: Int) {
        FIRST(100000, 0),
        SECOND(5000, 0),
        THIRD(100, 0),
        FOURTH(5, 0),
        LOSE(0, 0),
    }

    val winNumber = sortedSetOf<Int>()
    var winnigs = 0

    fun setWinNumber() {
        val selectNumber = (1..45).toMutableList() //
        selectNumber.shuffle()
        winNumber.addAll(selectNumber.subList(0, 6))
    }

    fun checkLotto(lotto: Lotto): Int {
        return winNumber.intersect(lotto.lottoNumber).count()
    }

    fun countRank(count: Int) {
        when (count) {
            6 -> WinningsCal.FIRST.count++
            5 -> WinningsCal.SECOND.count++
            4 -> WinningsCal.THIRD.count++
            3 -> WinningsCal.FOURTH.count++
            else -> WinningsCal.LOSE.count++ // 낙첨
        }
    }

    fun calculateWinnigs() {
        for (i in 1..4) {
            winnigs += WinningsCal.values()[i - 1].money * WinningsCal.values()[i - 1].count // 당첨 금액 X 당첨 횟수
        }
    }

    fun printResult() {
        println("--------------------")
        println("당첨 결과")
        for (i in 1..4) {
            println("${i}등 : ${WinningsCal.values()[i - 1].money}KW -> ${WinningsCal.values()[i - 1].count}개")
        }
        println("낙첨 : 0KW -> ${WinningsCal.LOSE.count}개")
        println("--------------------")
        println("총 당첨금 : ${winnigs}KW")
    }

    fun processLotto(lottos: MutableList<Lotto>) {
        lottos.forEach { lotto: Lotto -> countRank(checkLotto(lotto)) }
        calculateWinnigs()
        printResult()
    }
}
