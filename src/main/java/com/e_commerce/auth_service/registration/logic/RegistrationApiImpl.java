package com.e_commerce.auth_service.registration.logic;

import com.e_commerce.auth_service.registration.model.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class RegistrationApiImpl implements RegistrationApi {

    private RegistrationRepository registrationRepository;

    @Override
    @Transactional
    public void processRegistration(RegistrationDataRequest request) {
        RegistrationDataEntity registrationDataEntity = mapDataToEntity(request);
        registrationRepository.save(registrationDataEntity);
    }

    private RegistrationDataEntity mapDataToEntity(RegistrationDataRequest request) {
        AddressEntity addressEntity = mapAllressToEntity(request.getAddress());
        RegistrationDataEntity registrationDataEntity = new RegistrationDataEntity(null,
                request.getFirstName(),
                request.getLastName(),
                addressEntity,
                request.getEmail(),
                request.getPassword());

        addressEntity.setRegistrationDataEntity(registrationDataEntity);

        return registrationDataEntity;
    }

    private AddressEntity mapAllressToEntity(Address address) {
        return AddressEntity.builder()
                .city(address.getCity())
                .apartmentNumber(address.getApartmentNumber())
                .postalCode(address.getPostalCode())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .build();
    }

}
