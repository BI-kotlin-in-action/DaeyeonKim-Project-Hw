
class Lotto(private val lottoNumber: Set<Int> = sortedSetOf(6)) {
    companion object {
        @JvmStatic
        val price = 1000

        @JvmStatic
        val selectNumber = (1..45).toMutableList()

        @JvmStatic
        fun selectLottoNumber(): Set<Int> {
            return selectNumber.shuffled().subList(0, 6).toSortedSet()
        }
    }
    fun getLottoNumber(): Set<Int> {
        return lottoNumber
    }
}
