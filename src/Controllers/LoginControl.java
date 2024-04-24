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
        if(Email.contains("@") && Email.contains(".com")){
            return true;
        }
        return false;
    }
}
