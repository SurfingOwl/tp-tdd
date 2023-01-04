package fr.esgi.cleancode.service;

import java.util.UUID;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import fr.esgi.cleancode.model.DrivingLicence;

public class DrivingLicenceGenerationService {

    private final InMemoryDatabase inMemoryDatabase = InMemoryDatabase.getInstance();

    private final DrivingLicenceIdGenerationService drivingLicenceIdGenerationService = new DrivingLicenceIdGenerationService();
    private final SocialSecurityNumberValidationService socialSecurityNumberValidationService = new SocialSecurityNumberValidationService();

    public DrivingLicence generateNewDrivingLicenceFromSocialSecurityNumber(String socialSecurityNumber){        
        if (socialSecurityNumberValidationService.isValid(socialSecurityNumber)){

            UUID driverUuid = drivingLicenceIdGenerationService.generateNewDrivingLicenceId();
            var drivingLicence = DrivingLicence.builder().id(driverUuid).driverSocialSecurityNumber(socialSecurityNumber).build();

            return inMemoryDatabase.save(driverUuid, drivingLicence);

        } else {
            throw new InvalidDriverSocialSecurityNumberException("Invalid Social Security Number: " + socialSecurityNumber);
        }
    }
}
