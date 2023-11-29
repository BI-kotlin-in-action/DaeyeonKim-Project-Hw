package com.example.lottoweb.Controller

import com.example.lottoweb.dto.WinningLottoResponseDTO
import com.example.lottoweb.service.WinningLottoService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "WinningLotto", description = "당첨 번호 관련 API")
@RestController
@RequestMapping("/api/winning-lotto")
class WinningLottoController(
    private val winningLottoService: WinningLottoService,
) {
    // 불필요하지만 테스트를 위해 추가
    @PostMapping("/raffle")
    fun raffleWinningLotto() = winningLottoService.generateWinningLotto()

    @GetMapping("/history/{id}")
    fun findWinningLottoNumbers(@PathVariable id: Long): ResponseEntity<WinningLottoResponseDTO> {
        val result = winningLottoService.findWinningLotto(id)
        return ResponseEntity.ok(result)
    }
}
