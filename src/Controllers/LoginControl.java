package Controllers;
import java.util.regex.*;

public class LoginControl {
    public static boolean ValidatePassword(String Password){
<<<<<<< HEAD
        return true;
=======
        return Password.length() >= 8;
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1
    }
    public static String tostring(char[] arrOfChar){
        StringBuilder sb = new StringBuilder();
        for (char c : arrOfChar) {
                sb.append(c);
        }
        return sb.toString();
    }

    public  static boolean ValidateUsername(String Username){
<<<<<<< HEAD
        return true;
=======
        return 3 <= Username.length() && Username.length() <= 20;
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1
    }
    
    public static boolean ValidateEmail(String Email){
<<<<<<< HEAD
        return true;
=======
        String regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; // OWASP Validation Regex

        return patternMatches(Email, regexPattern);
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
          .matcher(emailAddress)
          .matches();
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1
    }
}
