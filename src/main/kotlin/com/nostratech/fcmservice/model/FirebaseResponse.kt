package com.nostratech.fcmservice.model

import com.fasterxml.jackson.annotation.JsonProperty

class FirebaseResponse {

    @JsonProperty(value = "multicast_id")
    var multicastId: String = ""
    var success: String = ""
    var failure: String = ""
}