package com.example.lottoweb.dto

class ManualRequestDTO(
    val userId: Long,
    val count: Int,
    val numbers: List<List<Int>>,
)
