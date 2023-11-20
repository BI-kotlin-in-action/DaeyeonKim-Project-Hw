package com.example.lottoweb.service

import com.example.lottoweb.domain.User
import com.example.lottoweb.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class BankService(
    private val userRepository: UserRepository,
) {
    @Transactional
    fun spendMoney(user: User, lottoCount: Int) {
        user.money -= lottoCount * 1000
        userRepository.save(user)
    }

    @Transactional
    fun withdrawMoney(user: User, money: Int) {
        user.money -= money
        userRepository.save(user)
    }

    @Transactional
    fun depositMoney(user: User, money: Int) {
        user.money += money
        userRepository.save(user)
    }
}
