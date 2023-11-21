package com.example.lottoweb.repository

import com.example.lottoweb.domain.WinningLotto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WinningLottoRepository : JpaRepository<WinningLotto, Long>
