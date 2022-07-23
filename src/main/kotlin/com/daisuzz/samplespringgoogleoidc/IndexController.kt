package com.daisuzz.samplespringgoogleoidc

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @GetMapping("/")
    fun index(
        @AuthenticationPrincipal principal: OidcUser?, model: Model
    ): String {
        if (principal != null) {
            model.addAttribute("userName", principal.attributes["name"])
            model.addAttribute("picture", principal.attributes["picture"])
            model.addAttribute("email", principal.attributes["email"])
        }
        return "index"
    }
}
