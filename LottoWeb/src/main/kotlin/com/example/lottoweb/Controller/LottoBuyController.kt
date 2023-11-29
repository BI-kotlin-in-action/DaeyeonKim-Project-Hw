package com.example.lottoweb.Controller

import com.example.lottoweb.dto.AutoRequestDTO
import com.example.lottoweb.dto.LottoBuyResponseDTO
import com.example.lottoweb.dto.ManualRequestDTO
import com.example.lottoweb.service.LottoBuyService
import com.example.lottoweb.service.UserService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "LottoBuy", description = "로또 구매 관련 API")
@RestController
@RequestMapping("/api/lotto")
class LottoBuyController(
    private val lottoBuyService: LottoBuyService,
    private val userService: UserService,
) {
    @PostMapping("/options/auto")
    fun buyAutoLotto(@RequestBody autoRequest: AutoRequestDTO): ResponseEntity<LottoBuyResponseDTO> {
        val user = userService.findUserById(autoRequest.userId)
        val lottoBuyResponseDTO = lottoBuyService.buyAutoLotto(user, autoRequest.count)
        return ResponseEntity.ok(lottoBuyResponseDTO)
    }

    @PostMapping("/options/manual")
    fun buyManualLotto(@RequestBody manualRequestDTO: ManualRequestDTO): ResponseEntity<LottoBuyResponseDTO> {
        val user = userService.findUserById(manualRequestDTO.userId)
        val lottoBuyResponseDTO = lottoBuyService.buyManualLotto(user, manualRequestDTO.count, manualRequestDTO.numbers)
        return ResponseEntity.ok(lottoBuyResponseDTO)
    }
}
