class Lottos(private val list: MutableList<Lotto> = mutableListOf()) {
    fun getList(): List<Lotto> {
        return list
    }

    fun addLotto(lotto: Lotto) {
        list.add(lotto)
    }
}
