package Controllers;

public class SignUpControl {
    public static boolean ValidatePassword(String Password){
        return 8 <= Password.length();
    }
    public  static boolean ValidateUsername(String Username){
        return 3 <= Username.length() && Username.length() <= 20;
    }
    public static boolean ValidateEmail(String email){
        if (email == null || email.isEmpty()) {
            return false; // Handle empty or null email strings
        }

        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        // Basic checks for @ and . presence and position
        return (atIndex > 0 && dotIndex > atIndex && dotIndex != email.length() - 1 && dotIndex-atIndex != 1 );
    }
}