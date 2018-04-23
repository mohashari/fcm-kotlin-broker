package com.nostratech.fcmservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FcmServiceApplication

fun main(args: Array<String>) {
    runApplication<FcmServiceApplication>(*args)
}
