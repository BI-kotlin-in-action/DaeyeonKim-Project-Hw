package View

import Lottos
import Person

fun printLotto(lottos: Lottos) {
    println("사용자가 구매 한 로또 번호는 다음과 같습니다.")
    lottos.getList().forEachIndexed { index, lotto ->
        println("${index + 1} : " + lotto.getLottoNumber().joinToString(" "))
    }
}

fun printResult(person: Person) {
    println("--------------------")
    println("당첨 결과")
    person.totalRank.forEach { (rank, count) ->
        println("$rank : ${rank.money}KW -> ${count}개")
    }
    println("--------------------")
    println("총 당첨금 : ${person.winnigs}KW")
}
