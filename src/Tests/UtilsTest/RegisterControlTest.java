package Tests.UtilsTest;

import Controllers.RegisterControl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterControlTest {

    @Test
    public void validatePasswordReturnsTrueForValidPassword() {
        assertTrue(RegisterControl.ValidatePassword("ValidPassword123"));
    }

    @Test
    public void validatePasswordReturnsFalseForShortPassword() {
        assertFalse(RegisterControl.ValidatePassword("Short1"));
    }

    @Test
    public void validateUsernameReturnsTrueForValidUsername() {
        assertTrue(RegisterControl.ValidateUsername("takioo8"));
    }

    @Test
    public void validateUsernameReturnsFalseForInvalidUsername() {
        assertFalse(RegisterControl.ValidateUsername("1InvalidUsername"));
    }

    @Test
    public void validateEmailReturnsTrueForValidEmail() {
        assertTrue(RegisterControl.ValidateEmail("valid.email@example.com"));
    }

    @Test
    public void validateEmailReturnsFalseForInvalidEmail() {
        assertFalse(RegisterControl.ValidateEmail("invalid.email@com"));
    }

    @Test
    public void isEmailStoredReturnsTrueForStoredEmail() {
        //make sure to have the email in the Users.txt file
        assertTrue(RegisterControl.isEmailStored("crusher@gmail.com"));
    }

    @Test
    public void isEmailStoredReturnsFalseForNonStoredEmail() {
        assertFalse(RegisterControl.isEmailStored("email@example.com"));
    }

    @Test
    public void isUsernameStoredReturnsTrueForStoredUsername() {
        //make sure to have the username in the Users.txt file
        assertTrue(RegisterControl.isUsernameStored("zeyad"));
    }

    @Test
    public void isUsernameStoredReturnsFalseForNonStoredUsername() {
        assertFalse(RegisterControl.isUsernameStored("NonStoredUsername"));
    }
}