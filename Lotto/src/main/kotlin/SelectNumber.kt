fun selectNumber(): Set<Int> {
    val selectNumber = (1..45).toMutableList()
    return selectNumber.shuffled().subList(0, 6).toSortedSet()
}
