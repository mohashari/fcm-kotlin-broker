package com.nostratech.fcmservice.model

class FirebaseRequest {

    var to: String = ""
    lateinit var data: FirebaseData
    lateinit var notification: FirebaseNotification
    var priority: String = "high"


}