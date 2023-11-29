package com.example.lottoweb.Controller

import com.example.lottoweb.service.UserService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "User", description = "유저 관련 API")
@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/join")
    fun joinUser(): ResponseEntity<String> {
        userService.joinUser()
        return ResponseEntity.ok("유저 생성 완료")
    }
}
