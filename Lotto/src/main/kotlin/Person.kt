
class Person(val money: Int) {
    val lottos = Lottos()
    val lottoCount = money / Lotto.price
    var winnigs = 0
    val totalRank = mutableMapOf(
        Rank.FIRST to 0,
        Rank.SECOND to 0,
        Rank.THIRD to 0,
        Rank.FOURTH to 0,
        Rank.LOSE to 0,
    )

    fun lottoBuy(lottoNumber: Set<Int>) {
        val lotto = Lotto(lottoNumber)
        lottos.addLotto(lotto)
    }
}
