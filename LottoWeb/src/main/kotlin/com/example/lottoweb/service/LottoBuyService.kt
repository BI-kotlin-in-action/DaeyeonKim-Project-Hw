package com.example.lottoweb.service

import com.example.lottoweb.domain.User
import com.example.lottoweb.repository.LottoRepository
import org.springframework.stereotype.Service

@Service
class LottoBuyService(
    private val lottoRepository: LottoRepository,
) {
    val lottoGenerationService = LottoGenerationService(lottoRepository)
    val bankService = BankService()
    fun buyManualLotto(user: User, lottoCount: Int, lottoNumbersList: List<List<Int>>) {
        lottoNumbersList.forEach {
            val lotto = lottoGenerationService.generateLotto(user, it)
        }
        bankService.spendMoney(user, lottoCount)
    }
    fun buyAutoLotto(user: User, lottoCount: Int) {
        repeat(lottoCount) {
            val lottoNumbers = lottoGenerationService.randomLottoNumbers()
            lottoGenerationService.generateLotto(user, lottoNumbers)
        }
        bankService.spendMoney(user, lottoCount)
    }
}
