package com.example.lottoweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class LottoWebApplication

fun main(args: Array<String>) {
    runApplication<LottoWebApplication>(*args)
}
