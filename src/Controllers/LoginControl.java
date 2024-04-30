package Controllers;

import static Utils.FileManager.isFileEmpty;

public class LoginControl {
    /**
     * Checks if the user's email and password are valid
     *
     * @param email user's Email
     * @param password user's Password
     * @return true if the user's email and password are valid
     */
    public static boolean ValidateUser(String email, String password){
        if (isFileEmpty("Users.txt")) return false;

        String data = Utils.FileManager.read("Users.txt");
        String[] users = data.split("\n");
        for (String user : users) {
            String[] userData = user.split(" ");
            if (userData[1].equals(email) && userData[2].equals(password)) {
                return true;
            }
        }
        return false;
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

}
