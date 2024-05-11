package Models;

public class Passenger extends User {
    private String firstname;
    private String lastname;
    private String passportId;
    private String phoneNumber;
    private String birthdate;
    private int numOfTickets = 0;
    public Passenger(String email, String fName,String lName, String password,String username, String phoneNumber, String passportId, String birthdate) {
        super(email, username ,password);
        this.firstname = fName;
        this.lastname = lName;
        this.phoneNumber = phoneNumber;
        this.passportId = passportId;
        this.birthdate = birthdate;
    }
    public Passenger() {

        super();
    }
    public Passenger(String email, String username,String password, String fName,String lName, String phoneNumber, String passportId) {
        super(email, username ,password);
        this.firstname = fName;
        this.lastname = lName;
        this.phoneNumber = phoneNumber;
        this.passportId = passportId;
    }

    public Passenger(String email, String password,String username) {
        super(email, username ,password);
        this.firstname = " ";
        this.lastname = " ";
        this.phoneNumber = " ";
        this.passportId = " ";
        this.birthdate = " ";
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
    public int getNumOfTickets() {

        return numOfTickets;

    }
    public void setNumOfTickets(int numOfTickets) {

        this.numOfTickets = numOfTickets;

    }

    public String getBirthdate() {
        return birthdate;
    }
}
