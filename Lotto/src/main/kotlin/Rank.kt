enum class Rank(val money: Int) {
    FIRST(100000),
    SECOND(5000),
    THIRD(100),
    FOURTH(5),
    LOSE(0),
}

// 전역 함수화 시킴. Rank의 companion object에 넣어야 하기 때문.
fun getRank(count: Int): Rank {
    return when (count) {
        6 -> Rank.FIRST
        5 -> Rank.SECOND
        4 -> Rank.THIRD
        3 -> Rank.FOURTH
        else -> Rank.LOSE
    }
}
