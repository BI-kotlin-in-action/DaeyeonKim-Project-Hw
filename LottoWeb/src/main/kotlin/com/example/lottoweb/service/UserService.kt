package com.example.lottoweb.service

import com.example.lottoweb.domain.User
import com.example.lottoweb.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    @Transactional
    fun findUserById(userId: Long): User = userRepository.findById(userId).orElseThrow()

    @Transactional
    fun joinUser() = userRepository.save(User())
}
