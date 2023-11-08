
fun main(args: Array<String>) {
    print("로또를 구매할 금액을 입력해 주세요 : ")
    val money = readln().toInt()
    val person = Person(money)
    val host = Host()
    // print(host.winNumber.joinToString(" ")) //결과 확인용 당첨번호 출력
    person.buyLotto()
    person.printLotto()

    host.processLotto(person.lottos)
    View().printResult(host)
}
