package com.nostratech.fcmservice.service

import com.nostratech.fcmservice.model.FirebaseRequest
import com.nostratech.fcmservice.model.FirebaseResponse
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.*
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class FirebaseService {

    @Value("\${firebase.url}")
    var url: String = ""

    @Value("\${firebase.server.key}")
    var serverKey: String = ""


    fun pushnotifToFirebase(firebaseRequest: FirebaseRequest): FirebaseResponse? {

         val log = LoggerFactory.getLogger(FirebaseService::class.java)

        val headers = HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)
        headers.set("Authorization", "key=" + serverKey)
        // set payload
        val requestEntity = HttpEntity(firebaseRequest, headers)
        log.info("Payload: " + firebaseRequest.toString())
        // set RestTemplate
        val restTemplate = RestTemplate()
        restTemplate.getMessageConverters().add(MappingJackson2HttpMessageConverter())
        try {
            // Call Service
            val result = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
                    FirebaseResponse::class.java)
            if (result.getStatusCode() === HttpStatus.OK) {
                log.info("Result: " + result.getBody())
                return result.getBody()
            }
        } catch (e: Exception) {
            log.error("ERROR: ", e)
        }
        return null
    }

}