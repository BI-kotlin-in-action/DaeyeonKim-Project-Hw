package com.example.lottoweb.domain

import jakarta.persistence.*
import lombok.Getter

@Entity
@Getter
data class Lotto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val number1: Int,

    @Column(nullable = false)
    val number2: Int,

    @Column(nullable = false)
    val number3: Int,

    @Column(nullable = false)
    val number4: Int,

    @Column(nullable = false)
    val number5: Int,

    @Column(nullable = false)
    val number6: Int,

    @Column(nullable = false)
    var scored: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val owner: User,
) {
    companion object {
        @JvmStatic
        val LOTTO_PRICE = 1000
    }
    fun getLottoNumbers(): List<Int> {
        return listOf(number1, number2, number3, number4, number5, number6)
    }
}
