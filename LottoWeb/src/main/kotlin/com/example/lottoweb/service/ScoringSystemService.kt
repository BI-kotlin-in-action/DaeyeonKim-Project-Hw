package com.example.lottoweb.service

import com.example.lottoweb.domain.User
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

    fun getTotalMoney(user: User): Int {
        val lottoList = lottoRepository.findAllByOwnerIdAndScored(user.id)
        val winningLotto = winningLottoRepository.findFirstByOrderByIdDesc()
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

    fun getTotalRank(user: User): Map<Rank, Int> {
        val lottoList = lottoRepository.findAllByOwnerIdAndScored(user.id)
        val winningLotto = winningLottoRepository.findFirstByOrderByIdDesc()
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
