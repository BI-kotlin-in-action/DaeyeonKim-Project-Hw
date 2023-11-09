
fun inputMoney(): Int {
    print("로또를 구매할 금액을 입력해 주세요 : ")
    val money = readln().toInt()
    return money
}

fun printLotto(lottos: Lottos) {
    println("사용자가 구매 한 로또 번호는 다음과 같습니다.")
    lottos.getList().forEachIndexed { index, lotto ->
        println("${index + 1} : " + lotto.getLottoNumber().joinToString(" "))
    }
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
