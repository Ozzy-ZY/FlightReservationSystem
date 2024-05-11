package Controllers;

import GUI.HomePage;
import Models.Passenger;

import static Utils.FileManager.isFileEmpty;

public class Account_FlightControls {
    public  static boolean Validatename(String name){
        return name.length() == 1 ||!name.matches("^[a-zA-Z]+$");
    }
    public  static boolean ValidatePassportId(String PassID) {
        return (!PassID.matches("^[A-Z0-9]{7,9}+$"));
    }
        public  static boolean Validatephonenumber(String phoneNumber){
            return (!phoneNumber.matches("[0-9]{10,13}+$"));
        }
    public static boolean passengerValidation (String fname,String lname, String PassID, String phoneNumber,String Date){
        return Validatename(fname) ||Validatename(lname)|| ValidatePassportId(PassID) || Validatephonenumber(phoneNumber);
    }
    public static boolean isEmailStored(String email){
        if(isFileEmpty("Passenger.txt"))
            return false;
        String data = Utils.FileManager.read("Passenger.txt");
        String[] emails = data.split("\n");
        for (String emailLine : emails) {
            String[] Passengerdata = emailLine.split(",");
            if (Passengerdata[0].equals(email)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isFirstnameStored(String firstname, String Email) {
        if (isFileEmpty("Passenger.txt"))
            return false;
        if (isEmailStored(Email)) {
            String data = Utils.FileManager.read("Passenger.txt");
            String[] firstnames = data.split("\n");
            for (String fname : firstnames) {
                String[] Passengerdata = fname.split(",");
                if (Passengerdata.length > 1 && Passengerdata[1].equals(firstname)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    public static boolean isLastnameStored(String lastname, String Email) {
        if (isFileEmpty("Passenger.txt"))
            return false;
        if (isEmailStored(Email)) {
            String data = Utils.FileManager.read("Passenger.txt");
            String[] lastnames = data.split("\n");
            for (String lname : lastnames) {
                String[] Passengerdata = lname.split(",");
                if (Passengerdata.length > 2 && Passengerdata[2].equals(lastname)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    public static boolean isPhoneNumberStored(String Phonenumber, String Email) {
        if (isFileEmpty("Passenger.txt"))
            return false;
        if (isEmailStored(Email)) {
            String data = Utils.FileManager.read("Passenger.txt");
            String[] Phonenumbers = data.split("\n");
            for (String PhoneNumber : Phonenumbers) {
                String[] Passengerdata = PhoneNumber.split(",");
                if (Passengerdata.length > 4 && Passengerdata[4].equals(Phonenumber)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    public static boolean isPassIdStored(String PassID, String Email) {
        if (isFileEmpty("Passenger.txt"))
            return false;
        if (isEmailStored(Email)) {
            String data = Utils.FileManager.read("Passenger.txt");
            String[] PassIDs = data.split("\n");
            for (String PassId : PassIDs) {
                String[] Passengerdata = PassId.split(",");
                if (Passengerdata.length > 3 && Passengerdata[3].equals(PassID)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    public static String getFirstname(String email){
        String data = Utils.FileManager.read("Passenger.txt");
        String[] firstnames = data.split("\n");
        for (String fname : firstnames) {
            String[] Passengerdata = fname.split(",");
            if (Passengerdata[0].equals(email)) {
                if(Passengerdata.length > 1)
                    return Passengerdata[1];
                else
                    return "";
            }
        }
        return null;
    }
    public static String getLastname(String email){
        String data = Utils.FileManager.read("Passenger.txt");
        String[] lastnames = data.split("\n");
        for (String lname : lastnames) {
            String[] Passengerdata = lname.split(",");
            if (Passengerdata[0].equals(email)) {
                if(Passengerdata.length > 2)
                    return Passengerdata[2];
                else
                    return "";
            }
        }
        return null;
    }
    public static String getPhoneNumber(String email){
        String data = Utils.FileManager.read("Passenger.txt");
        String[] PhoneNumbers = data.split("\n");
        for (String PhoneNumber : PhoneNumbers) {
            String[] Passengerdata = PhoneNumber.split(",");
            if (Passengerdata[0].equals(email)) {
                if(Passengerdata.length > 4)
                    return Passengerdata[4];
                else
                    return "";
            }
        }
        return null;
    }
    public static String getPassportId(String email){
        String data = Utils.FileManager.read("Passenger.txt");
        String[] PassIds = data.split("\n");
        for (String PassId : PassIds) {
            String[] Passengerdata = PassId.split(",");
            if (Passengerdata[0].equals(email)) {
                if(Passengerdata.length > 3)
                    return Passengerdata[3];
                else
                    return "";
            }
        }
        return null;
    }

    public static void savePassenger(String email, String firstName , String lastName, String phoneNumber, String passportNo ){
        String data = email + "," + firstName + "," + lastName  + "," +phoneNumber + "," + passportNo + "\n";
        Utils.FileManager.append("Passenger.txt", data);
    }
    public static void savePassengerData(Passenger passenger){
        String data = HomePage.currentUser.getEmail() + "," + passenger.getFirstName() + "," + passenger.getLastName() + "," + passenger.getPassportId() + "," + passenger.getPhoneNumber() + "," + passenger.getBirthdate()+ "\n";
        Utils.FileManager.append("Passenger.txt", data);
    }
}
