package Tests.UtilsTest;
import Controllers.LoginControl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class LoginControlTest {
    //insert the values of the users in the file Users.txt before running the tests
    @Test
    void validateUserWithValidEmailAndPassword() {
        int result = LoginControl.ValidateUser("validEmail@example.com", "validPassword");
        assertEquals(LoginControl.EMAIL_VALID, result);
    }
    @Test
    void validateUserWithValidUsernameAndPassword() {
        int result = LoginControl.ValidateUser("zeyad", "validPassword");
        assertEquals(LoginControl.USERNAME_VALID, result);
    }
    @Test
    void validateUserWithInvalidEmail() {
        int result = LoginControl.ValidateUser("bero@gmail.ccccc", "Password");
        assertEquals(LoginControl.NOT_VALID, result);
    }
    @Test
    void validateUserWithInvalidUsername() {
        int result = LoginControl.ValidateUser("the fernom", "validPassword");
        assertEquals(LoginControl.NOT_VALID, result);
    }
    @Test
    void getUsernameWithValidEmail() {
        String result = LoginControl.getUsername("validEmail@example.com");
        assertEquals("zeyad", result);
    }
    @Test
    void getUsernameWithInvalidEmail() {
        String result = LoginControl.getUsername("invalidEmail@example.com");
        assertNull(result);
    }
    @Test
    void getEmailWithValidUsername() {
        String result = LoginControl.getEmail("zeyad");
        assertEquals("validEmail@example.com", result);
    }
    @Test
    void getEmailWithInvalidUsername() {
        String result = LoginControl.getEmail("invalidUsername");
        assertNull(result);
    }
}