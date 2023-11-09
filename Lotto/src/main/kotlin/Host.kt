class Host() {
    val winLotto = setWinLotto()

    fun setWinLotto(): Lotto {
        return Lotto(Lotto.selectLottoNumber())
    }

    fun checkLotto(lotto: Lotto): Int {
        return winLotto.getLottoNumber().intersect(lotto.getLottoNumber()).count()
    }

    fun countRank(count: Int, person: Person) {
        val rank = Rank.getRank(count)
        person.totalRank[rank] = person.totalRank.getValue(rank) + 1
    }

    fun calculateWinnigs(person: Person) {
        person.totalRank.forEach { (rank, count) ->
            person.winnigs += rank.money * count
        }
    }
}
