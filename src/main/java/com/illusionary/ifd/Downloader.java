package com.illusionary.ifd;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Downloader {

    private final OAuth2AuthorizedClientService oauth2CliSrv;

    public Downloader(OAuth2AuthorizedClientService oauth2CliSrv) {
        this.oauth2CliSrv = oauth2CliSrv;
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
