package com.example.lottoweb.service

import com.example.lottoweb.service.enums.ErrorCode

class MyException(errorCode: ErrorCode) : RuntimeException(errorCode.message) {
    val code = errorCode.code
}
