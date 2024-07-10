package com.e_commerce.auth_service.registration.logic;

import com.e_commerce.auth_service.registration.model.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class RegistrationApiImpl implements RegistrationApi {

    private RegistrationRepository registrationRepository;

    @Override
    @Transactional
    public void processRegistration(RegistrationRequest request) {
        ActiveUserEntity activeUser = mapDataToEntity(request);
        registrationRepository.save(activeUser);
    }

    private ActiveUserEntity mapDataToEntity(RegistrationRequest request) {
        AddressEntity addressEntity = mapAddressToEntity(request.getAddress());
        ActiveUserEntity activeUser = new ActiveUserEntity(null,
                request.getFirstName(),
                request.getLastName(),
                addressEntity,
                request.getEmail(),
                request.getPassword());

        addressEntity.addActiveUser(activeUser);

        return activeUser;
    }

    private AddressEntity mapAddressToEntity(Address address) {
        return AddressEntity.builder()
                .city(address.getCity())
                .apartmentNumber(address.getApartmentNumber())
                .postalCode(address.getPostalCode())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .build();
    }

}
