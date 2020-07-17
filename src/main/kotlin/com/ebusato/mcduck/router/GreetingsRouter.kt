package com.ebusato.mcduck.router

import com.ebusato.mcduck.handler.GreetingsHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class GreetingsRouter(private val handler: GreetingsHandler) {

    @Bean
    fun router() = router { (accept(MediaType.TEXT_PLAIN) and "/hello").invoke(handler::hello) }

}