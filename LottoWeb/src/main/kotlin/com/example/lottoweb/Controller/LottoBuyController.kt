package com.example.lottoweb.Controller

import com.example.lottoweb.dto.AutoRequestDTO
import com.example.lottoweb.dto.ManualRequestDTO
import com.example.lottoweb.service.LottoBuyService
import com.example.lottoweb.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// @Tag(name = "LottoBuy", description = "로또 구매 관련 API")
@RestController
@RequestMapping("/api/lotto")
class LottoBuyController(
    private val lottoBuyService: LottoBuyService,
    private val userService: UserService,
) {
    @PostMapping("/options?option=auto")
    fun buyAutoLotto(@RequestBody autoRequest: AutoRequestDTO) {
        val user = userService.findUserById(autoRequest.userId)
        lottoBuyService.buyAutoLotto(user, autoRequest.count)
    }

    @PostMapping("/options?option=manual")
    fun buyManualLotto(@RequestBody manualRequestDTO: ManualRequestDTO) {
        val user = userService.findUserById(manualRequestDTO.userId)
        lottoBuyService.buyManualLotto(user, manualRequestDTO.count, manualRequestDTO.numbers)
    }
}
