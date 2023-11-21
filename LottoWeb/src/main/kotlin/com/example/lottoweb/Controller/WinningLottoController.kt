package com.example.lottoweb.Controller

import com.example.lottoweb.service.WinningLottoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/WinningLotto")
class WinningLottoController(
    private val winningLottoService: WinningLottoService,
) {
    @PostMapping("/raffle")
    fun raffleWinningLotto() = winningLottoService.generateWinningLotto()

    @GetMapping("/results/{id}")
    fun findWinningLottoNumbers(@PathVariable id: Long) = winningLottoService.findWinningLotto(id)
}
