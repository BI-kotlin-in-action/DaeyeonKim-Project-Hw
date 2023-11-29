package com.example.lottoweb.service

import com.example.lottoweb.domain.User
import com.example.lottoweb.domain.WinningLotto
import com.example.lottoweb.dto.GradingResponseDTO
import com.example.lottoweb.repository.LottoRepository
import com.example.lottoweb.repository.UserRepository
import com.example.lottoweb.repository.WinningLottoRepository
import com.example.lottoweb.service.enums.Rank
import org.springframework.stereotype.Service

@Service
class ScoringSystemService(
    private val lottoRepository: LottoRepository,
    private val userRepository: UserRepository,
    private val winningLottoRepository: WinningLottoRepository,
) {
    fun getResult(user: User): GradingResponseDTO {
        val winningLotto = winningLottoRepository.findFirstByOrderByIdDesc()
        val totalMoney = getTotalMoney(user, winningLotto)
        val rankCount = getTotalRank(user, winningLotto)
        return GradingResponseDTO(user.id, totalMoney, rankCount)
    }

    // 동시성 문제를 해결하기 위해 winningLotto를 파라미터로 받는다.
    @Synchronized
    fun getTotalMoney(user: User, winningLotto: WinningLotto): Int {
        val lottoList = lottoRepository.findAllByOwnerIdAndScored(user.id)
        val winningLottoNumbers = winningLotto.getWinningLottoNumbers()
        val totalMoney = lottoList.sumOf { calculateMoney(it.getLottoNumbers(), winningLottoNumbers) }
        val bankService = BankService(userRepository)
        bankService.depositMoney(user, totalMoney)
        lottoList.forEach {
            it.scored = true
        }
        lottoRepository.saveAll(lottoList)
        return totalMoney
    }

    // 동시성 문제를 해결하기 위해 winningLotto를 파라미터로 받는다.
    @Synchronized
    fun getTotalRank(user: User, winningLotto: WinningLotto): Map<Rank, Int> {
        val lottoList = lottoRepository.findAllByOwnerIdAndScored(user.id)
        val winningLottoNumbers = winningLotto.getWinningLottoNumbers()
        val rankCount = mutableMapOf<Rank, Int>()
        lottoList.forEach {
            val rank = calculateRank(it.getLottoNumbers(), winningLottoNumbers)
            rankCount[rank] = rankCount.getOrDefault(rank, 0) + 1
        }
        return rankCount
    }

    fun matchLottoNumbers(lottoNumbers: List<Int>, winningLottoNumbers: List<Int>): Int {
        return lottoNumbers.filter { winningLottoNumbers.contains(it) }.size
    }

    fun calculateMoney(lottoNumbers: List<Int>, winningLottoNumbers: List<Int>): Int {
        val matchCount = matchLottoNumbers(lottoNumbers, winningLottoNumbers)
        Rank.values().forEach {
            if (it.matchCount == matchCount) {
                return it.money
            }
        }
        return 0
    }

    fun calculateRank(lottoNumbers: List<Int>, winningLottoNumbers: List<Int>): Rank {
        val matchCount = matchLottoNumbers(lottoNumbers, winningLottoNumbers)
        Rank.values().forEach {
            if (it.matchCount == matchCount) {
                return it
            }
        }
        return Rank.LOSE
    }
}
