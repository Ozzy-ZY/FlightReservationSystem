package Models;

public class User {
    private String email;
    private String username;
    private String password;
    public User(String email,String username, String password){
        this.email= email;
        this.username = username;
        this.password = password;
    }
    public String getEmail(){
        return email;
    }
    public String getUsername(){

        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setEmail(String Email){
        email = Email;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String Password){
        password = Password;
    }
    @Override
    public String toString(){
        return username + " " + email + " " + password;
    }
}
