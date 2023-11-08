class View {
    fun printResult(host: Host) {
        println("--------------------")
        println("당첨 결과")
        for (i in 1..4) {
            println("${i}등 : ${WinningsCal.values()[i - 1].money}KW -> ${WinningsCal.values()[i - 1].count}개")
        }
        println("낙첨 : 0KW -> ${WinningsCal.LOSE.count}개")
        println("--------------------")
        println("총 당첨금 : ${host.winnigs}KW")
    }
}
