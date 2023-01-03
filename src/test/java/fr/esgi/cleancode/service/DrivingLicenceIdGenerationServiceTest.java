package fr.esgi.cleancode.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class DrivingLicenceIdGenerationServiceTest {
    
    private final DrivingLicenceIdGenerationService drivingLicenceIdGenerationService = new DrivingLicenceIdGenerationService();
    @Mock
    UUID uuid = mock(UUID.class);

    @Test
    void should_generate_valid_UUID() {
        assertNotNull(drivingLicenceIdGenerationService.generateNewDrivingLicenceId());
        assertEquals(uuid, drivingLicenceIdGenerationService.generateNewDrivingLicenceId());
    }
}