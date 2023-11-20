package com.example.lottoweb.domain

import jakarta.persistence.*
import lombok.Builder
import lombok.Getter

@Entity
@Getter
data class Lotto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val number1: Int,

    @Column(nullable = false, unique = true)
    val number2: Int,

    @Column(nullable = false, unique = true)
    val number3: Int,

    @Column(nullable = false, unique = true)
    val number4: Int,

    @Column(nullable = false, unique = true)
    val number5: Int,

    @Column(nullable = false, unique = true)
    val number6: Int,

) {
    @Builder
}
