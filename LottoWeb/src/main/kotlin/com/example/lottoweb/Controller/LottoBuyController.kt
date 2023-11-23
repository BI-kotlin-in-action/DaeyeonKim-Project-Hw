package com.example.lottoweb.Controller

import com.example.lottoweb.service.LottoBuyService
import com.example.lottoweb.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/lotto")
class LottoBuyController(
    private val lottoBuyService: LottoBuyService,
    private val userService: UserService,
) {
    @PostMapping("/buy-lottos/auto")
    fun buyAutoLotto(@RequestBody lottoBuyRequest: LottoAutoBuyRequest) {
        val user = userService.findUserById(lottoBuyRequest.userId)
        lottoBuyService.buyAutoLotto(user, lottoBuyRequest.autoLottoCount)
    }

    @PostMapping("/buy-lottos/manual")
    fun buyManualLotto(@RequestBody lottoBuyRequest: LottoManualBuyRequest) {
        val user = userService.findUserById(lottoBuyRequest.userId)
        lottoBuyService.buyManualLotto(user, lottoBuyRequest.manualLottoCount, lottoBuyRequest.manualLottoNumbers)
    }

    data class LottoAutoBuyRequest(
        val userId: Long,
        val autoLottoCount: Int,
    )

    data class LottoManualBuyRequest(
        val userId: Long,
        val manualLottoCount: Int,
        val manualLottoNumbers: List<List<Int>>,
    )
}
