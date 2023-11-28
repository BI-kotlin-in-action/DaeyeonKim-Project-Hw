package com.example.lottoweb.Controller

import com.example.lottoweb.service.ScoringSystemService
import com.example.lottoweb.service.UserService
import org.springframework.web.bind.annotation.*

// @Tag(name = "ScoringSystem", description = "점수 계산 관련 API")
@RestController
@RequestMapping("/api/scoring-system")
class ScoringSystemController(
    private val scoringSystemService: ScoringSystemService,
    private val userService: UserService,
) {
    @PatchMapping("/grading?userId={userId}")
    fun grading(@PathVariable userId: Long): Pair<Int, IntArray> {
        val user = userService.findUserById(userId)
        return scoringSystemService.getTotalMoneyAndRank(user)
    }
}
