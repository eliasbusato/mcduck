package com.ebusato.mcduck.client

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

class GreetingsWebClient {

    private val client = WebClient.create("http://localhost:8080")

    private val result = client.get().uri("/hello").accept(MediaType.TEXT_PLAIN).exchange()

    fun getResult() : String? = result.flatMap { it.bodyToMono(String::class.java) }.block()
}