package com.example.lottoweb.service

import com.example.lottoweb.domain.WinningLotto
import com.example.lottoweb.repository.WinningLottoRepository
import org.springframework.stereotype.Service

@Service
class WinningLottoService(
    private val winningLottoRepository: WinningLottoRepository,
) {
    fun generateWinningLotto() {
        val lottoNumbers = LottoNumberService.randomLottoNumbers()
        val winningLotto = WinningLotto(
            number1 = lottoNumbers[0],
            number2 = lottoNumbers[1],
            number3 = lottoNumbers[2],
            number4 = lottoNumbers[3],
            number5 = lottoNumbers[4],
            number6 = lottoNumbers[5],
        )
        winningLottoRepository.save(winningLotto)
    }
    fun findWinningLotto(id: Long): IntArray {
        val winningLotto = winningLottoRepository.findById(id).orElseThrow()
        return intArrayOf(
            winningLotto.number1,
            winningLotto.number2,
            winningLotto.number3,
            winningLotto.number4,
            winningLotto.number5,
            winningLotto.number6,
        )
    }
}
