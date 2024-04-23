package Models;

public class User {
    private String email;
    private String name;
    private String password;
    public User(String email,String name,String password){
        this.email= email;
        this.name = name;
        this.password = password;
    }
    public String getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public void setEmail(String Email){
        email = Email;
    }
    public void setName(String Name){
        name = Name;
    }
    public void setPassword(String Password){
        password = Password;
    }

}
