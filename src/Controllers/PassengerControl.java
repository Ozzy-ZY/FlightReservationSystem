package Controllers;

import Models.Passenger;

import static Utils.FileManager.isFileEmpty;
import static Utils.FileManager.write;

public class PassengerControl {
    public static boolean nameValidation(String name){
        return name.matches("^[a-zA-Z]*$");
    }
    public static boolean passportIdValidation(String passportId){
        return passportId.matches("^[A-Z]{1}[0-9]{8}$");
    }
    public static boolean phoneNumberValidation(String phoneNumber){
        return phoneNumber.matches("^[0-9]{11}$$");
    }
    public static boolean passengerValidation(String firstname, String lastname,
                                              String passportId, String phoneNumber, String birthdate){
        return nameValidation(firstname) && nameValidation(lastname) &&
                passportIdValidation(passportId) && phoneNumberValidation(phoneNumber);
    }
    public static void savePassengerData(Passenger passenger){ // 0: username, 1: email,
        // 2: password, 3: firstname, 4: lastname, 5: passportId, 6: phoneNumber, 7: birthdate 8: NumOfTickets
        try{
            Utils.FileManager.append ("Passengers.txt", passenger.getUsername() + " " + passenger.getEmail() + " " +
                    passenger.getPassword() + " " + passenger.getFirstName() + " " + passenger.getLastName() + " " +
                    passenger.getPassportId() + " " + passenger.getPhoneNumber() + " " + passenger.getBirthdate() +" "+ passenger.getNumOfTickets()+ "\n");
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    public static String getPassenger(String email){
        if(isFileEmpty("Passengers.txt"))
            return null;
        String data = Utils.FileManager.read("Passengers.txt");
        String[] passengers = data.split("\n");
        for (String passenger : passengers) {
            String[] passengerData = passenger.split(" ");
            if (passengerData[1].equals(email)) {
                return passenger;
            }
        }
        return null;
    }

    public static void saveAccountData(String path, String data){ // 0: username, 1: email,
        // 2: password, 3: firstname, 4: lastname, 5: passportId, 6: phoneNumber,
        try{
            Utils.FileManager.append ("Passengers.txt", data);
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    public static void updateAccountData(String path,String oldLine, String newLine){ // 0: username, 1: email,
        // 2: password, 3: firstname, 4: lastname, 5: passportId, 6: phoneNumber,

        try{
            Utils.FileManager.replaceLines ("Passengers.txt", oldLine, newLine);
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    public static String getFirstname(String email){
        if(!Utils.FileManager.isFileEmpty ( "Passengers.txt" )) {
            String data = Utils.FileManager.read ( "Passengers.txt" );
            String[] users = data.split ( "\n" );
            for (String user : users) {
                String[] userData = user.split ( " " );
                if ( userData[ 1 ].equals ( email ) ) {
                    return userData[ 3 ];
                }
            }
            return "";
        }
        return "";
    }

    public static String getLastname(String email){
        if(!Utils.FileManager.isFileEmpty ( "Passengers.txt" )) {
            String data = Utils.FileManager.read ( "Passengers.txt" );
            String[] users = data.split ( "\n" );
            for (String user : users) {
                String[] userData = user.split ( " " );
                if ( userData[ 1 ].equals ( email ) ) {
                    return userData[ 4 ];
                }
            }
            return "";
        }
        return "";
    }
    public static String getPassportID(String email){
        if(!Utils.FileManager.isFileEmpty ( "Passengers.txt" )) {

            String data = Utils.FileManager.read ( "Passengers.txt" );
            String[] users = data.split ( "\n" );
            for (String user : users) {
                String[] userData = user.split ( " " );
                if ( userData[ 1 ].equals ( email ) ) {
                    return userData[ 5 ];
                }
            }
            return "";
        }
        return "";

    }
    public static String getPhoneNumber(String email){
        if(!Utils.FileManager.isFileEmpty ( "Passengers.txt" )) {

            String data = Utils.FileManager.read ( "Passengers.txt" );
            String[] users = data.split ( "\n" );
            for (String user : users) {
                String[] userData = user.split ( " " );
                if ( userData[ 1 ].equals ( email ) ) {
                    return userData[ 6 ];
                }
            }
            return "";
        }
        return "";

    }
    public static boolean isEmailStored(String email){
        if(isFileEmpty("Passengers.txt"))
            return false;
        String data = Utils.FileManager.read("Passengers.txt");
        String[] emails = data.split("\n");
        for (String emailLine : emails) {
            String[] userData = emailLine.split(" ");
            if (userData[1].equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static int getNumOfTickets(String username){
        if(isFileEmpty("Passengers.txt"))
            return 0;
        String data = Utils.FileManager.read("Passengers.txt");
        String[] passengers = data.split("\n");
        for (String passenger : passengers) {
            String[] passengerData = passenger.split(" ");
            if (passengerData[0].equals(username)) {
                if(passengerData.length != 9)
                    return Integer.parseInt(passengerData[8]);
            }
        }
        return 0;
    }
}