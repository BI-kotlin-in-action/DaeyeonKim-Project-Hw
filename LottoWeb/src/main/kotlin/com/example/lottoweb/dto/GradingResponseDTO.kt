package com.example.lottoweb.dto

import com.example.lottoweb.service.enums.Rank

class GradingResponseDTO(
    val userId: Long,
    val money: Int,
    val rankCount: Map<Rank, Int>,
)
