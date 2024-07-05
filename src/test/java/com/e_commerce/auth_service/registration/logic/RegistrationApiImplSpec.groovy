package com.e_commerce.auth_service.registration.logic

import com.e_commerce.auth_service.registration.model.Address
import com.e_commerce.auth_service.registration.model.RegistrationDataEntity
import com.e_commerce.auth_service.registration.model.RegistrationDataRequest
import spock.lang.Specification

class RegistrationApiImplSpec extends Specification {
    private final RegistrationRepository registrationRepository = Mock()
    private final RegistrationApiImpl registrationApi = new RegistrationApiImpl(registrationRepository)
    def "happy-path: should correct process registration"() {
        given:
        final Address address = new Address("test-city", "test-street", "50-320", "3", "2")
        final RegistrationDataRequest request = new RegistrationDataRequest("spec", "", address, "","" )

        when:
        final entity = registrationApi.mapDataToEntity(request)

        then:
        entity.address.registrationDataEntity.firstName == "spec"
    }
}
