package com.nostratech.fcmservice.controller

import com.nostratech.fcmservice.model.FirebaseRequest
import com.nostratech.fcmservice.model.FirebaseResponse
import com.nostratech.fcmservice.service.FirebaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "/api/v1/fcm")
class FirebaseController {

    @Autowired
    lateinit var firebaseService: FirebaseService

    @PostMapping(value = "/push")
    fun pushData(@RequestBody firebaseRequest: FirebaseRequest): FirebaseResponse? {
        return firebaseService.pushnotifToFirebase(firebaseRequest)
    }
}