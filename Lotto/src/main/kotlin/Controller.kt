class Controller {
    fun process() {
        View().startMessage()
        val host = Host()
        val money = readln().toInt()
        val person = Person(money)
        buyLottos(person) // Person이 Lottos를 구매하도록 명령
        View().printLotto(person.lottos) // Person이 Lottos를 출력하도록 명령
        processLotto(host, person.lottos) // Host가 Lottos를 체크하도록 명령
        printResult(host) // Host가 결과를 출력하도록 명령
    }
    fun buyLottos(person: Person) {
        person.buyLotto()
    }
    fun processLotto(host: Host, lottos: Lottos) {
        lottos.list.forEach { lotto: Lotto -> host.countRank(host.checkLotto(lotto)) }
    }
    fun printResult(host: Host) {
        View().printResult(host)
    }
}
