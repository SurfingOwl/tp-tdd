package fr.esgi.cleancode.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import fr.esgi.cleancode.model.DrivingLicence;

public class DrivingLicencePointRemovalServiceTest {

    @Mock
    DrivingLicenceFinderService drivingLicenceFinderService = mock(DrivingLicenceFinderService.class);
    @Mock
    UUID uuid = mock(UUID.class);
    @Mock
    DrivingLicence drivingLicence = mock(DrivingLicence.class);

    DrivingLicencePointRemovalService drivingLicencePointRemovalService = new DrivingLicencePointRemovalService();

    @Test
    void shouldRemovePointFromDrivingLicence(UUID drivingLicenceId, int amountOfPointToRemove) {
        when(drivingLicenceFinderService.findById(drivingLicenceId)).thenReturn(Optional.of(drivingLicence));
        
        DrivingLicence substractedDrivingLicence = drivingLicencePointRemovalService.removePoint(amountOfPointToRemove);

        assertEquals(drivingLicence.getAvailablePoints() - amountOfPointToRemove, substractedDrivingLicence.getAvailablePoints());
    }
    
    @Test
    void shouldHaveNewPointValueInDatabase(UUID drivingLicenceId) {
        when(drivingLicenceFinderService.findById(drivingLicenceId)).thenReturn(Optional.of(drivingLicence));

        assertNotEquals(drivingLicenceFinderService.findById(drivingLicenceId), drivingLicencePointRemovalService.removePoint(2));
    }
}
