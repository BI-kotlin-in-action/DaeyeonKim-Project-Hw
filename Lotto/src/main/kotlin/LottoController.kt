class LottoController {
    fun process() {
        val money = inputMoney() // View에게 금액을 입력받도록 명령
        val host = Host()
        val person = Person(money)
        buyLottos(person) // Person이 Lottos를 구매하도록 명령
        printLotto(person.lottos) // Person이 Lottos를 출력하도록 명령
        processLotto(host, person.lottos) // Host가 Lottos를 체크하도록 명령
        host.calculateWinnigs() // Host가 총 당첨금을 계산하도록 명령
        result(host) // 결과를 출력
    }
    fun buyLottos(person: Person) {
        person.buyLotto()
    }
    fun processLotto(host: Host, lottos: Lottos) {
        lottos.list.forEach { lotto: Lotto -> host.countRank(host.checkLotto(lotto)) }
    }
    fun result(host: Host) {
        printResult(host)
    }
}
