package fr.esgi.cleancode.service;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import fr.esgi.cleancode.model.DrivingLicence;

public class SocialSecurityNumberValidationServiceTest {

    @Mock
    DrivingLicence drivingLicence = mock(DrivingLicence.class);

    SocialSecurityNumberValidationService socialSecurityNumberValidationService = new SocialSecurityNumberValidationService();

    @Test
    void shouldBeNull() {
        when(drivingLicence.getDriverSocialSecurityNumber()).thenReturn(null);
        assertTrue(socialSecurityNumberValidationService.isNull(drivingLicence.getDriverSocialSecurityNumber()));
    }

    @Test
    void shouldBeNumberOnly() {
        when(drivingLicence.getDriverSocialSecurityNumber()).thenReturn("1234");
        assertTrue(socialSecurityNumberValidationService.isNumberOnly(drivingLicence.getDriverSocialSecurityNumber()));
    }

    @Test
    void shouldBeFifteenCharacters() {
        when(drivingLicence.getDriverSocialSecurityNumber()).thenReturn("123456789012345");        
        assertTrue(socialSecurityNumberValidationService.isFifteenCharacters(drivingLicence.getDriverSocialSecurityNumber()));
    }

    @Test
    void shouldBeThrowingInvalidDriverSocialSecurityNumberException() {
        DrivingLicenceGenerationService drivingLicenceGenerationService = mock(DrivingLicenceGenerationService.class);
        when(socialSecurityNumberValidationService.isValid(null)).thenReturn(false);
        assertThrowsExactly(InvalidDriverSocialSecurityNumberException.class, () -> drivingLicenceGenerationService.generateNewDrivingLicenceFromSocialSecurityNumber(""));
    }
}
