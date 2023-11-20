package com.example.lottoweb.repository

import com.example.lottoweb.domain.Lotto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LottoRepository : JpaRepository<Lotto, Long> {
    fun findByUserId(userId: Long): List<Lotto>
}
