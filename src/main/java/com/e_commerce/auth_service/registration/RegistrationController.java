package com.e_commerce.auth_service.registration;

import com.e_commerce.auth_service.registration.logic.RegistrationApi;
import com.e_commerce.auth_service.registration.model.RegistrationDataRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
 class RegistrationController {

    private final RegistrationApi registrationApi;

    @PostMapping("/register")
    ResponseEntity<Void> registration(@Valid @RequestBody RegistrationDataRequest request) {
        registrationApi.processRegistration(request);
        return ResponseEntity.ok().build();
    }
}
