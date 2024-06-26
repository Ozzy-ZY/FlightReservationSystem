package Models;

public class Passenger extends User {
    private String firstname;
    private String lastname;
    private String passportId;
    private String phoneNumber;
    private String birthdate;
    private int numOfTickets = 0;

    public Passenger(String email, String fName,String lName, String password,String username) {
        super(email, username ,password);
    }

    public Passenger() {
        super();
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phoneNumber = phonenumber;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirstName() {
        return firstname;
    }
    public String getLastName() {
        return lastname;
    }
    public String getPassportId() {
        return passportId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }
}
