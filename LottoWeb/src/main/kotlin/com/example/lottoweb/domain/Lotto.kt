package com.example.lottoweb.domain

import jakarta.persistence.*
import lombok.Getter

@Entity
@Getter
class Lotto(
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
    // Builder 작성
    @Builder
    constructor(
        number1: Int,
        number2: Int,
        number3: Int,
        number4: Int,
        number5: Int,
        number6: Int,
    ) : this(
        number1 = number1,
        number2 = number2,
        number3 = number3,
        number4 = number4,
        number5 = number5,
        number6 = number6,
    )
}
