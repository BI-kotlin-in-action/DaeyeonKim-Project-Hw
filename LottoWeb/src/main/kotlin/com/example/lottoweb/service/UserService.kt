package com.example.lottoweb.service

import com.example.lottoweb.domain.User
import com.example.lottoweb.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    @Transactional(readOnly = true)
    fun findUserById(userId: Long): User = userRepository.findById(userId).orElseThrow()

    @Transactional
    fun joinUser() = userRepository.save(User())
}
