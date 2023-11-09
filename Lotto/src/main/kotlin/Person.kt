
class Person(val money: Int) {
    val lottos = Lottos()
    val lottoCount = money / Lotto.price

    fun lottoBuy(lottoNumber: Set<Int>) {
        val lotto = Lotto(lottoNumber)
        lottos.addLotto(lotto)
    }
}
