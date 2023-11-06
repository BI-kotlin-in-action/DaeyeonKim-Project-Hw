
class Person(val money: Int) {
    var lottoList = mutableListOf<Lotto>()
    fun buyLotto() {
        val count = money / Lotto.price
        print("직접 번호를 고를 로또의 개수를 입력 하세요 : ")
        val directlyBuy = readln().toInt()
        val autoBuy = count - directlyBuy
        repeat(directlyBuy) {
            print(" 로또 번호를 입력하세요 : ")
            var lottoNumber = readln().split(" ").map { it.toInt() }.toSortedSet()
            while (lottoNumber.size < 6) {
                print("번호에 중복이 있습니다. 로또 번호를 다시 입력하세요 : ")
                lottoNumber = readln().split(" ").map { it.toInt() }.toSortedSet()
            }

            val lotto = Lotto(lottoNumber)
            lottoList.add(lotto)
        }

        repeat(autoBuy) {
            val numArray = sortedSetOf<Int>()
            while (numArray.size < 6) {
                val num = (Math.random() * 45 + 1).toInt()
                if (numArray.contains(num)) continue
                numArray.add(num)
            }
            val lotto = Lotto(numArray)
            lottoList.add(lotto)
        }
    }

    fun printLotto() {
        println("사용자가 구매한 로또 번호는 다음과 같습니다.")
        for (i in 0 until lottoList.size) {
            println("${i + 1} : " + lottoList[i].lottoNumber.joinToString(" "))
        }
    }
}
