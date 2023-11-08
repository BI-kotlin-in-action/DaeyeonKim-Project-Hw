
class Person(val money: Int) {
    val lottos = Lottos()

    fun buyLotto() {
        val count = money / Lotto.price
        print("직접 번호를 고를 로또의 개수를 입력 하세요 : ")
        val manualBuy = readln().toInt()
        val autoBuy = count - manualBuy
        repeat(manualBuy) {
            print(" 로또 번호를 입력하세요 : ")
            var lottoNumber = readln().split(" ").map { it.toInt() }.toSortedSet()
            while (lottoNumber.size < 6) {
                print("번호에 중복이 있습니다. 로또 번호를 다시 입력하세요 : ")
                lottoNumber = readln().split(" ").map { it.toInt() }.toSortedSet()
            }

            val lotto = Lotto(lottoNumber)
            lottos.list.add(lotto)
        }

        repeat(autoBuy) {
            val lotto = Lotto(selectNumber())
            lottos.list.add(lotto)
        }
    }

    fun printLotto() {
        println("사용자가 구매한 로또 번호는 다음과 같습니다.")
        lottos.list.forEachIndexed { index, lotto ->
            println("${index + 1} : " + lotto.lottoNumber.joinToString(" "))
        }
    }
}
