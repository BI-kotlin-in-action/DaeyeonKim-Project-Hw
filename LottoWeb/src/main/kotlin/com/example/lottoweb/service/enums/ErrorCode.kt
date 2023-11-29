package com.example.lottoweb.service.enums

enum class ErrorCode(val code: Int, val message: String) {
    INSUFFICIENT_BALANCE(400, "잔액이 부족해"),
}
