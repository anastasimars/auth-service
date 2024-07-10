package com.e_commerce.auth_service.registration.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "addresses")
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
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ActiveUserEntity> activeUsers;

    public void addActiveUser(ActiveUserEntity user) {
        if (!activeUsers.contains(user)) {
            activeUsers.add(user);
            user.setAddress(this);
        }
    }
}
