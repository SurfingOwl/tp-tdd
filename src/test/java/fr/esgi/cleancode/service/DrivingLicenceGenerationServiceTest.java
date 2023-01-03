package fr.esgi.cleancode.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;

public class DrivingLicenceGenerationServiceTest {

    @Mock
    InMemoryDatabase inMemoryDataBase = mock(InMemoryDatabase.class);
    
    DrivingLicenceGenerationService drivingLicenceGenerationService = new DrivingLicenceGenerationService();
    
    @Test
    void drivingLicenceIDShouldBeGeneratedByDedicatedService() {
        // ???
        verify(mock(DrivingLicenceIdGenerationService.class).generateNewDrivingLicenceId());
    }

    @Test
    void shouldHaveTwelvePoints() {
        DrivingLicence dLicence = drivingLicenceGenerationService.generateNewDrivingLicenceFromSocialSecurityNumber("123456789012345");
        assertEquals(12, dLicence.getAvailablePoints());
    }

    @Test
    void socialSecurityNumberShouldBeGivenAtLicenceCreation() {
        // ???
        verify(mock(DrivingLicenceGenerationService.class)).generateNewDrivingLicenceFromSocialSecurityNumber("123456789012345");
    }

    @Test
    void drivingLicenceShouldBeSaved() {
        //TODO ???
    }

    @Test
    void shouldReturnNewDrivingLicence() {
        assertNotNull(drivingLicenceGenerationService.generateNewDrivingLicenceFromSocialSecurityNumber("123456789012345"));
        assertInstanceOf(DrivingLicence.class, drivingLicenceGenerationService.generateNewDrivingLicenceFromSocialSecurityNumber("123456789012345"));
    }
}
