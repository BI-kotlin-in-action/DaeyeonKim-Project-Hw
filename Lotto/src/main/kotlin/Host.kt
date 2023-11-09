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
        return Lotto(selectLottoNumber())
    }

    fun checkLotto(lotto: Lotto): Int {
        return winLotto.getLottoNumber().intersect(lotto.getLottoNumber()).count()
    }

    fun countRank(count: Int) {
        val rank = getRank(count)
        totalRank[rank] = totalRank.getValue(rank) + 1
    }

    fun calculateWinnigs() {
        totalRank.forEach { (rank, count) ->
            winnigs += rank.money * count
        }
    }
}
