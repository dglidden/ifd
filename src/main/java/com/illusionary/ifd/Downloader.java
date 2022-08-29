package com.illusionary.ifd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Downloader {

    // @Value("${com.illusionary.ifd.authorizer}")
    private String authorizer;

    private final ClientRegistrationRepository clientRegistrationRepository;

    public Downloader(ClientRegistrationRepository clientRegistrationRepository) {
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    @GetMapping("/")
    ModelAndView showIndexPage(OAuth2AuthenticationToken authn) {
        OAuth2User user = authn.getPrincipal();

        System.out.println(user.getAttributes());

        ModelAndView model = new ModelAndView();
        model.addObject("user", user.getAttribute("user"));
        model.setViewName("index");
        return model;

    }
}
