package com.example.lottoweb.Controller

import com.example.lottoweb.dto.UserMoneyDTO
import com.example.lottoweb.service.BankService
import com.example.lottoweb.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// @Tag(name = "Bank", description = "뱅킹 관련 API")
@RestController
@RequestMapping("/api/bank")
class BankController(
    private val bankService: BankService,
    private val userService: UserService,
) {
    @PatchMapping("/deposit")
    fun depositMoney(@RequestBody userMoneyDTO: UserMoneyDTO) = bankService.depositMoney(userService.findUserById(userMoneyDTO.userId), userMoneyDTO.money)

    @PatchMapping("/withdraw")
    fun withdrawMoney(@RequestBody userMoneyDTO: UserMoneyDTO) = bankService.withdrawMoney(userService.findUserById(userMoneyDTO.userId), userMoneyDTO.money)

    @GetMapping("/balance?userId={userId}")
    fun getBalance(@PathVariable userId: Long) = bankService.getBalance(userService.findUserById(userId))
}
