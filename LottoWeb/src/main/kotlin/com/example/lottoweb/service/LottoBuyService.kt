package com.example.lottoweb.service

import com.example.lottoweb.domain.User
import com.example.lottoweb.repository.LottoRepository
import com.example.lottoweb.repository.UserRepository
import com.example.lottoweb.repository.WinningLottoRepository
import org.springframework.stereotype.Service

@Service
class LottoBuyService(
    private val lottoRepository: LottoRepository,
    private val userRepository: UserRepository,
    private val winningLottoRepository: WinningLottoRepository,
) {
    val lottoGenerationService = LottoGenerationService(lottoRepository, winningLottoRepository)
    val bankService = BankService(userRepository)

    fun buyManualLotto(user: User, lottoCount: Int, lottoNumbersList: List<List<Int>>) {
        lottoNumbersList.forEach {
            lottoGenerationService.generateLotto(user, it)
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
