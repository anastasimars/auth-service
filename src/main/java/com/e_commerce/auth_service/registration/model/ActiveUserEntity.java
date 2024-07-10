package com.e_commerce.auth_service.registration.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "active_users")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class ActiveUserEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public void setAddress(AddressEntity address) {
        if (this.address != null) {
            this.address.getActiveUsers().remove(this);
        }
        this.address = address;
        if (address != null && !address.getActiveUsers().contains(this)) {
            address.addActiveUser(this);
        }
    }
}
