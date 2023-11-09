
class Lotto(private val lottoNumber: Set<Int> = sortedSetOf(6)) {
    companion object {
        @JvmStatic
        val price = 1000
    }
    fun getLottoNumber(): Set<Int> {
        return lottoNumber
    }

    fun countSameNumber(winLotto: Lotto): Int {
        return lottoNumber.intersect(winLotto.lottoNumber).count()
    }
}
