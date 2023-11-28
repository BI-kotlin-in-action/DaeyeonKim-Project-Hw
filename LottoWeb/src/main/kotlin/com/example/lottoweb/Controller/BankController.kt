package com.example.lottoweb.Controller

import com.example.lottoweb.dto.UserMoneyDTO
import com.example.lottoweb.service.BankService
import com.example.lottoweb.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// @Tag(name = "Bank", description = "뱅킹 관련 API")
@RestController
@RequestMapping("/api/bank")
class BankController(
    private val bankService: BankService,
    private val userService: UserService,
) {
    @PatchMapping("/deposit")
    fun depositMoney(@RequestBody userMoneyDTO: UserMoneyDTO): ResponseEntity<String> {
        bankService.depositMoney(userService.findUserById(userMoneyDTO.userId), userMoneyDTO.money)
        return ResponseEntity.ok("입금 완료")
    }

    @PatchMapping("/withdraw")
    fun withdrawMoney(@RequestBody userMoneyDTO: UserMoneyDTO): ResponseEntity<String> {
        bankService.withdrawMoney(userService.findUserById(userMoneyDTO.userId), userMoneyDTO.money)
        return ResponseEntity.ok("출금 완료")
    }

    @GetMapping("/balance")
    fun getBalance(@RequestParam id: Long): ResponseEntity<Int> {
        val balance = bankService.getBalance(userService.findUserById(id))
        return ResponseEntity.ok(balance)
    }
}
