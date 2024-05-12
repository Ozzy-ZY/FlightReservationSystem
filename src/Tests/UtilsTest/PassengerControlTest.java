package Tests.UtilsTest;
import static org.junit.jupiter.api.Assertions.*;

import Controllers.PassengerControl;


import org.junit.jupiter.api.Test;


public class PassengerControlTest {

    @Test
    public void nameValidationReturnsTrueForValidName() {
        assertTrue(PassengerControl.nameValidation("Zeyad hani mohamed"));
    }

    @Test
    public void nameValidationReturnsFalseForInvalidName() {
        //Name cannot contain numbers
        assertFalse(PassengerControl.nameValidation("zeyad455"));
    }

    @Test
    public void passportIdValidationReturnsTrueForValidId() {
        assertTrue(PassengerControl.passportIdValidation("A12345678"));
    }

    @Test
    public void passportIdValidationReturnsFalseForInvalidId() {
        //Passport ID must start with a letter and be followed by 8 numbers
        assertFalse(PassengerControl.passportIdValidation("12345678A"));
    }

    @Test
    public void phoneNumberValidationReturnsTrueForValidNumber() {
        assertTrue(PassengerControl.phoneNumberValidation("12345678901"));
    }

    @Test
    public void phoneNumberValidationReturnsFalseForInvalidNumber() {
        //Phone number must be 11 numbers
        assertFalse(PassengerControl.phoneNumberValidation("1234567890A"));
    }

    @Test
    public void passengerValidationReturnsTrueForValidPassenger() {
        assertTrue(PassengerControl.passengerValidation("zeyad", "hani", "A12345678", "12345678910", "01/01/2000"));
    }

    @Test
    public void passengerValidationReturnsFalseForInvalidPassenger() {

        assertFalse(PassengerControl.passengerValidation("ze5555", "m777", "12345678", "12345678901", "01/01/2000"));
    }

    @Test
    public void isEmailStoredReturnsFalseForNonStoredEmail() {
        assertFalse(PassengerControl.isEmailStored("email@examplenonstored.com"));
    }
}
