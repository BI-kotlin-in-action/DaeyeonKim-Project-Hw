class Host() {
    val winLotto = setWinLotto()
    var winnigs = 0
    val totalRank = mutableMapOf(
        Rank.FIRST to 0,
        Rank.SECOND to 0,
        Rank.THIRD to 0,
        Rank.FOURTH to 0,
        Rank.LOSE to 0,
    )

    fun setWinLotto(): Lotto {
        return Lotto(selectNumber())
    }

    fun checkLotto(lotto: Lotto): Int {
        return winLotto.lottoNumber.intersect(lotto.lottoNumber).count()
    }

    fun countRank(count: Int) {
        when (count) {
            6 -> totalRank[Rank.FIRST] =
                totalRank[Rank.FIRST]?.plus(1) ?: 0 // totalRank[Rank.FIRST] = totalRank[Rank.FIRST] + 1
            5 -> totalRank[Rank.SECOND] = totalRank[Rank.SECOND]?.plus(1) ?: 0
            4 -> totalRank[Rank.THIRD] = totalRank[Rank.THIRD]?.plus(1) ?: 0
            3 -> totalRank[Rank.FOURTH] = totalRank[Rank.FOURTH]?.plus(1) ?: 0
            else -> totalRank[Rank.LOSE] = totalRank[Rank.LOSE]?.plus(1) ?: 0
        }
    }

    fun calculateWinnigs() {
        totalRank.forEach { (rank, count) ->
            winnigs += rank.money * count
        }
    }
}
