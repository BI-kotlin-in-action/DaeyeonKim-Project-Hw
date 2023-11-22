package com.example.lottoweb.service

import com.example.lottoweb.domain.User
import com.example.lottoweb.repository.LottoRepository
import com.example.lottoweb.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class LottoBuyService(
    lottoRepository: LottoRepository,
    userRepository: UserRepository,
) {
    val lottoGenerationService = LottoGenerationService(lottoRepository)
    val bankService = BankService(userRepository)

    fun buyManualLotto(user: User, lottoCount: Int, lottoNumbersList: List<List<Int>>) {
        lottoNumbersList.forEach {
            lottoGenerationService.generateLotto(user, it)
        }
        bankService.spendMoney(user, lottoCount)
    }

    fun buyAutoLotto(user: User, lottoCount: Int) {
        repeat(lottoCount) {
            val lottoNumbers = LottoNumberService.randomLottoNumbers()
            lottoGenerationService.generateLotto(user, lottoNumbers)
        }
        bankService.spendMoney(user, lottoCount)
    }
}
