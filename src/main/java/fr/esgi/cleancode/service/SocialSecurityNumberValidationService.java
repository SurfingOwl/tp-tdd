package fr.esgi.cleancode.service;

import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;

public class SocialSecurityNumberValidationService {

    public boolean isNull(String socialSecurityNumber) {
        return socialSecurityNumber == null || socialSecurityNumber.trim().equals("");
    }

    public boolean isNumberOnly(String socialSecurityNumber) {
        
        try {
            int socialSecurityNumberToInt = Integer.parseInt(socialSecurityNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        
        return true;
    }

    public boolean isFifteenCharacters(String socialSecurityNumber) {
        return socialSecurityNumber.length() == 15;
    }

    public boolean isValid(String socialSecurityNumber) {
        if(isNull(socialSecurityNumber) && isNumberOnly(socialSecurityNumber) && isFifteenCharacters(socialSecurityNumber))
            return true;
        throw new InvalidDriverSocialSecurityNumberException("Invalid Social Security Number: " + socialSecurityNumber);
    }

}
