package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.ResourceNotFoundException;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicenceFinderService {

    private final InMemoryDatabase database;

    public Optional<DrivingLicence> findById(UUID drivingLicenceId) {
        var drivingLicence = database.findById(drivingLicenceId);
        if (!drivingLicence.isPresent())
            throw new ResourceNotFoundException("Resource Not Found In Database");
        return drivingLicence;
    }
}
