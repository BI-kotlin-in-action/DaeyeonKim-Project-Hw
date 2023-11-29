package com.example.lottoweb.Controller

import com.example.lottoweb.dto.GradingResponseDTO
import com.example.lottoweb.service.ScoringSystemService
import com.example.lottoweb.service.UserService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "ScoringSystem", description = "점수 계산 관련 API")
@RestController
@RequestMapping("/api/scoring-system")
class ScoringSystemController(
    private val scoringSystemService: ScoringSystemService,
    private val userService: UserService,
) {
    @PatchMapping("/grading")
    fun grading(@RequestParam userId: Long): ResponseEntity<GradingResponseDTO> {
        val user = userService.findUserById(userId)
        val result = scoringSystemService.getResult(user)
        return ResponseEntity.ok(result)
    }
}
