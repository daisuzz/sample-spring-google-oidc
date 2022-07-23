package com.daisuzz.samplespringgoogleoidc

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.oauth2Login()
        http.logout {
            it.logoutUrl("/logout")
            it.logoutSuccessUrl("/")
        }
        return http.build()
    }
}
