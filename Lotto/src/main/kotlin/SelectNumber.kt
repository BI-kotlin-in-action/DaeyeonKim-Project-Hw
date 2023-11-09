val selectNumber = (1..45).toMutableList()

fun selectLottoNumber(): Set<Int> {
    return selectNumber.shuffled().subList(0, 6).toSortedSet()
}
