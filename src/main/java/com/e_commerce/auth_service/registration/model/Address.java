package com.e_commerce.auth_service.registration.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Address {
    @NotBlank(message = "City is mandatory")
    @Size(max = 50, message = "City name must be less than 50 characters")
    private String city;

    @NotBlank(message = "Street is mandatory")
    @Size(max = 100, message = "Street name must be less than 100 characters")
    private String street;

    @Pattern(
            regexp = "^\\d{2}-\\d{3}$",
            message = "Postal code must be in the format XX-YYY"
    )
    private String postalCode;

    @NotBlank(message = "House number is mandatory")
    @Size(min = 1, max = 10, message = "House number must be less than 10 characters")
    private String houseNumber;

    @Size(max = 10, message = "Apartment number must be less than 10 characters")
    private String apartmentNumber;
}
