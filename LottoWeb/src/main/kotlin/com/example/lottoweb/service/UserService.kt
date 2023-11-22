package com.example.lottoweb.service

import com.example.lottoweb.domain.User
import com.example.lottoweb.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun findUserById(userId: Long): User = userRepository.findById(userId).orElseThrow()
    fun joinUser() = userRepository.save(User())
}
