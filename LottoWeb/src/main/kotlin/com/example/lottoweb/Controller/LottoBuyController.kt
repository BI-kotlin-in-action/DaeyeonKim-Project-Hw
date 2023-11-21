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
    val lottoBuyService: LottoBuyService,
    private val userService: UserService,
) {
    @PostMapping("/buy")
    fun buyLotto(@RequestBody lottoBuyRequest: LottoBuyRequest) {
        val user = userService.findUserById(lottoBuyRequest.userId)
        lottoBuyService.buyAutoLotto(user, lottoBuyRequest.autoLottoCount)
        lottoBuyService.buyManualLotto(user, lottoBuyRequest.manualLottoCount, lottoBuyRequest.manualLottoNumbers)
    }

    data class LottoBuyRequest(
        val userId: Long,
        val autoLottoCount: Int,
        val manualLottoCount: Int,
        val manualLottoNumbers: List<List<Int>>,
    )
}
