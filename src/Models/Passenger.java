package Models;

public class Passenger {
    private String passportid;
    private String phonenumber;
    private String birthdate;

    public void setPassportid(String passportid) {
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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
