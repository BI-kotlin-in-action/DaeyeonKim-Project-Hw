package com.example.lottoweb.service

import com.example.lottoweb.domain.Lotto
import com.example.lottoweb.domain.User
import com.example.lottoweb.repository.LottoRepository

class LottoGenerationService(
    private val lottoRepository: LottoRepository,
) {
    fun randomLottoNumbers(): List<Int> {
        return (1..45).shuffled().take(6).sorted()
    }

    fun generateLotto(user: User, lottoNumbers: List<Int>): Lotto {
        val lotto = Lotto(
            number1 = lottoNumbers[0],
            number2 = lottoNumbers[1],
            number3 = lottoNumbers[2],
            number4 = lottoNumbers[3],
            number5 = lottoNumbers[4],
            number6 = lottoNumbers[5],
            owner = user,
        )
        lottoRepository.save(lotto)
        return lotto
    }
}
