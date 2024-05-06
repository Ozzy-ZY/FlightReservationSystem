package Controllers;
import java.util.regex.*;

import static Utils.FileManager.isFileEmpty;

public class RegisterControl {
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

    public  static boolean ValidateUsername(String Username){
        if(Username.contains(" ")){
            return false;
        }
        else{
            return Username.length() >= 3;
        }

    }

    public static boolean ValidateEmail(String Email){
        String regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; // OWASP Validation Regex

        return patternMatches(Email, regexPattern);
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static boolean isEmailStored(String email){
        if(isFileEmpty("Users.txt"))
            return false;
        String data = Utils.FileManager.read("Users.txt");
        String[] emails = data.split("\n");
        for (String emailLine : emails) {
            String[] userData = emailLine.split(" ");
            if (userData[1].equals(email)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isUsernameStored(String username){
        if(isFileEmpty("Users.txt"))
            return false;
        String data = Utils.FileManager.read("Users.txt");
        String[] users = data.split("\n");
        for (String user : users) {
            String[] userData = user.split(" ");
            if (userData[0].equals(username)) {
                return true;
            }
        }
        return false;
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

}
