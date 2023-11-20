package com.example.lottoweb.service

class LottoGenerationService {
    fun randomLottoNumbers(): List<Int> {
        return (1..45).shuffled().take(6).sorted()
    }
}
