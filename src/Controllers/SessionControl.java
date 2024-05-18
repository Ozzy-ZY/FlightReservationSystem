package Controllers;

import Models.User;
import Utils.FileManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionControl {
    private static final Logger logger = Logger.getLogger(SessionControl.class.getName());
    private static final String TOKEN_FILE_PATH = "token.txt";

    public static void generateToken(User user) {
        String tokenData = user.getUsername() + "\n" + user.getEmail() + "\n" + user.getPassword();
        FileManager.write(TOKEN_FILE_PATH, tokenData);
    }

    public static User returnTokenData() {
        User currentUser = new User("", "", "");
        String tokenData = FileManager.read(TOKEN_FILE_PATH);
        String[] tokenDataArray = tokenData.split("\n");
        if (tokenDataArray.length >= 3) {
            currentUser.setUsername(tokenDataArray[0]);
            currentUser.setEmail(tokenDataArray[1]);
            currentUser.setPassword(tokenDataArray[2]);
        } else {
            logger.log(Level.WARNING, "Token data is incomplete");
        }
        return currentUser;
    }

    public static boolean tokenExists() {
        return Files.exists(Paths.get(TOKEN_FILE_PATH));
    }

    public static boolean removeToken() {
        try {
            return Files.deleteIfExists(Paths.get(TOKEN_FILE_PATH));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Failed to delete token file", ex);
        }
        return false;
    }
}
