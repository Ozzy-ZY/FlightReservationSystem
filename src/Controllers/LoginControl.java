package Controllers;

import java.util.regex.*;

public class LoginControl {
    public static boolean ValidatePassword(String Password){
        return !Password.contains(" ") || Password.length() >= 24;
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
}
