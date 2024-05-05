package Controllers;

import Models.User;

import java.io.File;

import static Utils.FileManager.*;
public class SessionControl {
    public static void generateToken(User user){
        try{
        write("token.txt", user.getUsername() +"\n"+ user.getEmail() + "\n" + user.getPassword());
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    public static User returnTokenData() {
        var currentUser = new User("","","");
        try{
            var tokenData = read("token.txt");
            var tokenDataArray = tokenData.split("\n");
            currentUser.setUsername(tokenDataArray[0]);
            currentUser.setEmail(tokenDataArray[1]);
            currentUser.setPassword(tokenDataArray[2]);
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        return currentUser;
    }
    public static boolean tokenExists(){
        File file = new File("token.txt");
        return file.exists();
    }
    public static boolean removeToken(){
        File file = new File("token.txt");
        if(file.exists()){
            try{
                return file.delete();
            }
            catch (Exception ex){
                System.err.println(ex.getMessage());
            }
        }
        else{
            System.err.println("File does not exist");
            return false;
        }
        return false;
    }
}
