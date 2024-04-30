package Controllers;
import java.io.File;
import java.util.regex.*;
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
        return 3 <= Username.length() && Username.length() <= 20;
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
    public static void existingEmail(String email){

    }

}
