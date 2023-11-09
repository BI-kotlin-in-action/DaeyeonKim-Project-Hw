import View.*

class LottoController {
    fun process() {
        val money = inputMoney() // View에게 금액을 입력받도록 명령
        val host = Host()
        val person = Person(money)
        buyLottos(person) // Person이 Lottos를 구매하도록 명령
        printLotto(person.lottos) // Person이 Lottos를 출력하도록 명령
        processLotto(host, person) // Host가 Lottos를 체크하도록 명령
        host.calculateWinnigs(person) // Host가 총 당첨금을 계산하도록 명령
        result(person) // 결과를 출력
    }
    fun buyLottos(person: Person) {
        val manualBuy = selectBuyOption()
        val autoBuy = person.lottoCount - manualBuy
        repeat(manualBuy) {
            val lottoNumber = manualBuyLotto()
            person.lottoBuy(lottoNumber)
        }
        repeat(autoBuy) {
            val lottoNumber = Lotto.selectLottoNumber()
            person.lottoBuy(lottoNumber)
        }
    }
    fun processLotto(host: Host, person: Person) {
        person.lottos.getList().forEach { lotto: Lotto -> host.countRank(host.checkLotto(lotto), person) }
    }
    fun result(person: Person) {
        printResult(person)
    }
}
