package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.ResourceNotFoundException;
import fr.esgi.cleancode.model.DrivingLicence;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DrivingLicenceFinderServiceTest {
    
    @Mock
    DrivingLicence drivingLicence = mock(DrivingLicence.class);
    @Mock 
    UUID uuid = mock(UUID.class);

    DrivingLicenceFinderService drivingLicenceFinderService = new DrivingLicenceFinderService(mock(InMemoryDatabase.class));

    @Test
    void should_find() {        
        assertNotNull(drivingLicenceFinderService.findById(uuid));
        assertEquals(Optional.of(drivingLicence), drivingLicenceFinderService.findById(uuid));
    }

    @Test
    void should_not_find() {
        assertNotNull(drivingLicenceFinderService.findById(uuid));
        // assertEquals(Optional.empty(), drivingLicenceFinderService.findById(uuid));
        assertThrows(ResourceNotFoundException.class, () -> drivingLicenceFinderService.findById(uuid));
    }
}