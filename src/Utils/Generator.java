package Utils;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import GUI.FlightsPage;
import GUI.TicketGUI;
import Models.Flight;
import Models.Passenger;
import Models.Plane;
import Models.Ticket;
import com.google.zxing.WriterException;

public class Generator {
    public static Ticket ticketGen(Passenger passenger, Flight flight, int seatNumber){
        Ticket ticket = new Ticket(passenger,flight,seatNumber);
        ticket.generateTicketID();
        try {
            QrGenerator.saveQRCodeImage(QrGenerator.generateQRCode(ticket.getTicketID()),
                    ticket.getTicketID() + ".png");
        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }
        return ticket;
    }
    public static String flightGen(String origin, String destination){

        return "Flight From " + origin + " to " + destination + " at ";
    }
    public static Flight flightGen(String origin, String destination, String date){
        return new Flight(GenerateID(),destination,origin,new Plane("747",150),date);
    }
    public static String GenerateID(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String randomDateGen(String startDate){
        Random random = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Convert the input string to a LocalDate
        LocalDate start = LocalDate.parse(startDate, formatter);

        // Generate a random number between 2 and 14
        int daysToAdd = random.nextInt(13) + 2;

        // Add the random number of days to the start date
        LocalDate newDate = start.plusDays(daysToAdd);

        // Convert the new date back to a string
        return newDate.format(formatter);
    }

    public static int daysInMonth(int month,int year){
        return switch (month) {
            case 0, 2, 4, 6, 7, 9, 11 -> 31;
            case 1 -> isLeapYear(year) ? 29 : 28;
            default -> 30;
        };
    }

    public static boolean isLeapYear(int year){
        return  year % 4 == 0 && (year % 100!= 0 || year % 400 == 0);
    }
}