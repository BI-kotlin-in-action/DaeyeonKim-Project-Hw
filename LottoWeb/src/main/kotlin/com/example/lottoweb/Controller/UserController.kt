package com.example.lottoweb.Controller

import com.example.lottoweb.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/join")
    fun joinUser() = userService.joinUser()
}
