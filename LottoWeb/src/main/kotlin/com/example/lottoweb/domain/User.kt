package com.example.lottoweb.domain
import jakarta.persistence.*
import lombok.Getter

@Entity
@Getter
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var money: Int = 0,
)
