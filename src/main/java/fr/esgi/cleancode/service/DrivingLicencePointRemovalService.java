package fr.esgi.cleancode.service;

import java.util.UUID;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;

public class DrivingLicencePointRemovalService {

    private final InMemoryDatabase inMemoryDatabase = InMemoryDatabase.getInstance();
    private final DrivingLicenceFinderService drivingLicenceFinderService = new DrivingLicenceFinderService(inMemoryDatabase);

    public boolean hasEnoughPoint(UUID driverId, int amountOfPointToRemove) {
        DrivingLicence drivingLicence = drivingLicenceFinderService.findById(driverId).get();
        return drivingLicence.getAvailablePoints() - amountOfPointToRemove >= 0;
    }

    public DrivingLicence removePoint(UUID driverId, int amountOfPointToRemove) {
        DrivingLicence drivingLicence = drivingLicenceFinderService.findById(driverId).get();

        if(hasEnoughPoint(driverId, amountOfPointToRemove))
            drivingLicence = drivingLicence.withAvailablePoints(drivingLicence.getAvailablePoints() - amountOfPointToRemove);
            
        return inMemoryDatabase.save(driverId, drivingLicence);
    }

}
