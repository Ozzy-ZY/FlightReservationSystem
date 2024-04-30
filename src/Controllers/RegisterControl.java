package Controllers;
import java.io.File;
import java.util.regex.*;

import static Utils.FileManager.isFileEmpty;

public class RegisterControl {
    public static final int VALID_DATA = 0;
    public static final int INVALID_DATA = 1;
    public static final int ALREADY_EXISTS = 2;

    public static boolean ValidatePassword(String Password){
        return Password.length() >= 8;
    }
    public static String tostring(char[] arrOfChar){
        StringBuilder sb = new StringBuilder();
        for (char c : arrOfChar) {
                sb.append(c);
        }
        return sb.toString();
    }

    public  static int ValidateUsername(String Username){
        if(isExistingUsername(Username)){
            return ALREADY_EXISTS;
        }
        if(Username.length() >= 3){
            return VALID_DATA;
        }
        return INVALID_DATA;
    }
    
    public static int ValidateEmail(String Email){
        String regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; // OWASP Validation Regex
        if(isExistingEmail(Email)){
            return ALREADY_EXISTS;
        }
        if(patternMatches(Email, regexPattern)){
            return 0;
        }
        return INVALID_DATA;
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
          .matcher(emailAddress)
          .matches();
    }

    /**
     * Saves the user data to dataFile seperated by a space
     * @param email user's Email
     * @param username user's Username
     * @param password user's Password
     */
    public static void saveData(String email, String username, String password){
        String data = username + " " + email + " " + password + "\n";
        Utils.FileManager.append("Users.txt", data);
    }
    public static boolean isExistingEmail(String email){
        if(isFileEmpty("Users.txt")){
            return false;
        }
        String data = Utils.FileManager.read("Users.txt");
        String[] users = data.split("\n");
        for (String user : users) {
            String[] userData = user.split(" ");
            if(userData[1].equals(email)){
                return true;
            }
        }
        return false;
    }
    public static boolean isExistingUsername(String username){
        if(isFileEmpty("Users.txt")){
            return false;
        }
        String data = Utils.FileManager.read("Users.txt");
        String[] users = data.split("\n");
        for (String user : users) {
            String[] userData = user.split(" ");
            if(userData[0].equals(username)){
                return true;
            }
        }
        return false;
    }
}
