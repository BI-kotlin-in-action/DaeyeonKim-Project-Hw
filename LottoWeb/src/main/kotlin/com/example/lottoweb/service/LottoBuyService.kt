package com.example.lottoweb.service

import com.example.lottoweb.domain.User
import com.example.lottoweb.repository.LottoRepository
import org.springframework.stereotype.Service

@Service
class LottoBuyService(
    private val lottoRepository: LottoRepository,
) {
    val lottoGenerationService = LottoGenerationService(lottoRepository)

    fun buyManualLotto(user: User, count: Int, lottoNumbersList: List<List<Int>>) {
        lottoNumbersList.forEach {
            val lotto = lottoGenerationService.generateLotto(user, it)
        }
    }
    fun buyAutoLotto(user: User, count: Int) {
        repeat(count) {
            val lottoNumbers = lottoGenerationService.randomLottoNumbers()
            lottoGenerationService.generateLotto(user, lottoNumbers)
        }
    }
}
