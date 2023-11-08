class View {
    fun printResult(host: Host) {
        println("--------------------")
        println("당첨 결과")
        host.totalRank.forEach { (rank, count) ->
            println("$rank : ${rank.money}KW -> ${count}개")
        }
        println("--------------------")
        println("총 당첨금 : ${host.winnigs}KW")
    }
}
