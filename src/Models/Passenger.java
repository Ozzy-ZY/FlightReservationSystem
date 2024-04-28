package Models;

public class Passenger extends User {
    private String firstname;
    private String lastname;
    private String passportid;
    private String phonenumber;
    private String birthdate;

    public Passenger(String email, String fname,String lname, String password,String username) {
        super(email, username ,password);
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setPassportid(String passportid) {
        this.passportid = passportid;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getPassportid() {
        return passportid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getBirthdate() {
        return birthdate;
    }
}
