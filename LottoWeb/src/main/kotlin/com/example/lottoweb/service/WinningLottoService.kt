package com.example.lottoweb.service

import com.example.lottoweb.domain.WinningLotto
import com.example.lottoweb.dto.WinningLottoResponseDTO
import com.example.lottoweb.repository.WinningLottoRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class WinningLottoService(
    private val winningLottoRepository: WinningLottoRepository,
) {
    @Transactional
    @Scheduled(fixedRate = 600000) // 5초마다 실행
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
        println("당첨 번호: $lottoNumbers")
    }

    @Transactional(readOnly = true)
    fun findWinningLotto(id: Long): WinningLottoResponseDTO {
        val winningLotto = winningLottoRepository.findById(id).orElseThrow()
        val maxId = winningLottoRepository.findFirstByOrderByIdDesc().id
        if (id == maxId) {
            throw RuntimeException("아직 공개되지 않은 당첨번호입니다.")
        }
        return WinningLottoResponseDTO(
            numbers = winningLotto.getWinningLottoNumbers(),
        )
    }
}
