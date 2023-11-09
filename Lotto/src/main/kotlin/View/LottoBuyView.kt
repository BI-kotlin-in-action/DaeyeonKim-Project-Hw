package View

fun inputMoney(): Int {
    print("로또를 구매할 금액을 입력해 주세요 : ")
    val money = readln().toInt()
    return money
}

fun selectBuyOption(): Int {
    print("직접 번호를 고를 로또의 개수를 입력 하세요 : ")
    val manualBuy = readln().toInt()
    return manualBuy
}

fun manualBuyLotto(): Set<Int> {
    print(" 로또 번호를 입력하세요 : ")
    var lottoNumber = readln().split(" ").map { it.toInt() }.toSortedSet()
    while (lottoNumber.size < 6) {
        print("번호에 중복이 있습니다. 로또 번호를 다시 입력하세요 : ")
        lottoNumber = readln().split(" ").map { it.toInt() }.toSortedSet()
    }
    return lottoNumber
}
