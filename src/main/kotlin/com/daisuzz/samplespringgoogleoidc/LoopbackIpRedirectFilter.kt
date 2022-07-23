package com.daisuzz.samplespringgoogleoidc

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.server.ServletServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.UriComponentsBuilder
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class LoopbackIpRedirectFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain
    ) {
        if (request.serverName == "localhost" && request.getHeader("host") != null) {
            val uri = UriComponentsBuilder.fromHttpRequest(ServletServerHttpRequest(request)).host("127.0.0.1").build()
            response.sendRedirect(uri.toUriString())
            return
        }
        filterChain.doFilter(request, response)
    }
}
