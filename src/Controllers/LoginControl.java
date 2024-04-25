package Controllers;

public class LoginControl {
    public static boolean ValidatePassword(String Password){
        if(8 > Password.length())
            return false;
        return true;
    }

    public  static boolean ValidateUsername(String Username){
        if(3 > Username.length() || Username.length() > 20){
            return false;
        }
        return true;
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
