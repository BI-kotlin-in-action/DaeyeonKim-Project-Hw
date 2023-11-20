package com.example.lottoweb.service

import com.example.lottoweb.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    @Transactional
    fun findUserById(userId: Long) = userRepository.findById(userId).orElseThrow()
}
