package com.example.lottoweb.Controller

import com.example.lottoweb.service.ScoringSystemService
import com.example.lottoweb.service.UserService
import com.example.lottoweb.service.enums.Rank
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/scoring-system")
class ScoringSystemController(
    private val scoringSystemService: ScoringSystemService,
    private val userService: UserService,
) {
    @GetMapping("/{userId}/results-score")
    fun getScore(@PathVariable userId: Long): Map<Rank, Int> {
        val user = userService.findUserById(userId)
        return scoringSystemService.getTotalRank(user)
    }

    @PostMapping("/{userId}/results-money")
    fun getMoney(@PathVariable userId: Long): Int {
        val user = userService.findUserById(userId)
        return scoringSystemService.getTotalMoney(user)
    }
}
