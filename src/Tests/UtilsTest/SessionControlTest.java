package Tests.UtilsTest;
import Controllers.SessionControl;
import Models.User;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class SessionControlTest {
    @Test
    void generateTokenForValidUser() {
        User user = new User("zeya22d", "Email@kop.com", "Password");
        SessionControl.generateToken(user);
        assertTrue(new File("token.txt").exists());
    }
    @Test
    void returnTokenDataForExistingToken() {
        User user = new User("hani", "Email@lo.com", "Password");
        SessionControl.generateToken(user);
        User returnedUser = SessionControl.returnTokenData();
        assertEquals(user.getUsername(), returnedUser.getUsername());
        assertEquals(user.getEmail(), returnedUser.getEmail());
        assertEquals(user.getPassword(), returnedUser.getPassword());
    }
    @Test
    void tokenExistsForExistingToken() {
        User user = new User("validUsername", "validEmail@example.com", "validPassword");
        SessionControl.generateToken(user);
        assertTrue(SessionControl.tokenExists());
    }
    @Test
    void returnTokenDataForNonExistingToken() {
        // Remove token if exists
        boolean tokenRemoved = SessionControl.removeToken();
        User returnedUser1 = SessionControl.returnTokenData();
        assertEquals("", returnedUser1.getUsername());
        assertEquals("", returnedUser1.getEmail());
        assertEquals("", returnedUser1.getPassword());
    }
    @Test
    void tokenExistsForNonExistingToken() {
        assertFalse(SessionControl.tokenExists());
    }
    @Test
    void removeTokenForExistingToken() {
        User user = new User("validUsername", "validEmail@example.com", "validPassword");
        SessionControl.generateToken(user);
        assertTrue(SessionControl.removeToken());
        assertFalse(new File("token.txt").exists());
    }
    @Test
    void removeTokenForNonExistingToken() {
        assertFalse(SessionControl.removeToken());
    }
}
