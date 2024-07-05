package com.e_commerce.auth_service.registration.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address_entity")
@Builder
@Getter
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "apartment_number")
    private String apartmentNumber;
    @Column(name = "registration_data")
    @ManyToOne
    @Setter
    private RegistrationDataEntity registrationDataEntity;

}
