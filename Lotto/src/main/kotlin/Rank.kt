enum class Rank(val money: Int, val matchCount: Int) {
    FIRST(100000, 6),
    SECOND(5000, 5),
    THIRD(100, 4),
    FOURTH(5, 3),
    LOSE(0, 0),
    ;

    companion object {
        @JvmStatic
        fun getRank(count: Int): Rank {
            return values().find { it.matchCount == count } ?: LOSE
        }
    }
}
