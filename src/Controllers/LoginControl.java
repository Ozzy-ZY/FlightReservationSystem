package Controllers;
import jdk.jshell.execution.Util;

import static Controllers.RegisterControl.ValidateEmail;
import static Controllers.RegisterControl.ValidateUsername;
import static Utils.FileManager.isFileEmpty;

public class LoginControl {
    public static final int EMAIL_VALID = 0;
    public static final int USERNAME_VALID = 1;
    public static final int NOT_VALID = -1;
    /**
     * Checks if the user's email and password are valid
     *
     * @param emailOrUsername user's Email
     * @param password user's Password
     * @return true if the user's email and password are valid
     */
    public static int ValidateUser(String emailOrUsername, String password){
        if (isFileEmpty("Users.txt")) return NOT_VALID;
        String ifEmail = ValidateEmail(emailOrUsername)? emailOrUsername:"";
        String ifUsername = ValidateUsername(emailOrUsername)? emailOrUsername: "";
        String data = Utils.FileManager.read("Users.txt");
        String[] users = data.split("\n");
        for (String user : users) {
            String[] userData = user.split(" ");
            if(userData[0].equals(ifUsername)&&userData[2].equals(password)){
                return USERNAME_VALID;
            }
            else if(userData[1].equals(ifEmail)&& userData[2].equals(password))
                return EMAIL_VALID;
        }
        return NOT_VALID;
    }

    public static String getUsername(String email){
        String data = Utils.FileManager.read("Users.txt");
        String[] users = data.split("\n");
        for (String user : users) {
            String[] userData = user.split(" ");
            if (userData[1].equals(email)) {
                return userData[0];
            }
        }
        return null;
    }
    public static String getEmail(String username){
        String data = Utils.FileManager.read("Users.txt");
        String[] users = data.split("\n");
        for(var user: users){
            String[] userData = user.split(" ");
            if (userData[0].equals(username)) {
                return userData[1];
            }
        }
        return null;
    }
}
