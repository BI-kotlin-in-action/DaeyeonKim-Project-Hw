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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    val owner: User,
) {
    companion object {
        @JvmStatic
        val LOTTO_PRICE = 1000
    }
}
