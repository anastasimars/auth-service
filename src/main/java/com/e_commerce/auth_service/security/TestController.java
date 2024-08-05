package com.e_commerce.auth_service.security;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
@PreAuthorize("hasRole('CLIENT')")
class TestController {
   @GetMapping("/hello")
    public String helloNewClient() {
       return "Hello, a new client";
    }
}
