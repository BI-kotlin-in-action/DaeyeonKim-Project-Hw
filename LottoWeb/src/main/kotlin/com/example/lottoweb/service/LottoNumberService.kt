package com.example.lottoweb.service

import org.springframework.stereotype.Service

@Service
class LottoNumberService {
    companion object {
        @JvmStatic
        fun randomLottoNumbers(): List<Int> {
            return (1..45).shuffled().take(6).sorted()
        }
    }
}
