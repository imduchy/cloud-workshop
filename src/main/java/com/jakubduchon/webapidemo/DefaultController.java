package com.jakubduchon.webapidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    String health() {
        return "The application was deployed by GitHub Actions! <3";
    }
}
