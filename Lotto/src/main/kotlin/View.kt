class View {
    fun startMessage() {
        print("로또를 구매할 금액을 입력해 주세요 : ")
    }
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
