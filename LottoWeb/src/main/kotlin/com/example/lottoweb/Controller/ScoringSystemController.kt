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
//    @GetMapping("/{userId}/results-score")
//    fun getScore(@PathVariable userId: Long): Map<Rank, Int> {
//        val user = userService.findUserById(userId)
//        return scoringSystemService.getTotalRank(user)
//    }
//
//    @PostMapping("/{userId}/results-money")
//    fun getMoney(@PathVariable userId: Long): Int {
//        val user = userService.findUserById(userId)
//        return scoringSystemService.getTotalMoney(user)
//    }
    @PutMapping("/{userId}/check-results")
    fun getScoreAndMoney(@PathVariable userId: Long): Pair<Int, IntArray> {
        val user = userService.findUserById(userId)
        return scoringSystemService.getTotalMoneyAndRank(user)
    }
}
