package com.example.lottoweb.Controller

import com.example.lottoweb.service.BankService
import com.example.lottoweb.service.UserService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// @Tag(name = "Bank", description = "뱅킹 관련 API")
@RestController
@RequestMapping("/api/bank")
class BankController(
    private val bankService: BankService,
    private val userService: UserService,
) {
    @PostMapping("{userId}/deposit/{money}")
    fun depositMoney(@PathVariable userId: Long, @PathVariable money: Int) = bankService.depositMoney(userService.findUserById(userId), money)

    @PostMapping("{userId}/withdraw/{money}")
    fun withdrawMoney(@PathVariable userId: Long, @PathVariable money: Int) = bankService.withdrawMoney(userService.findUserById(userId), money)
}
