package Models;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private int seatNumber;
    private String ticketID;
    public Ticket(Passenger passenger,Flight flight,int seatNumber){
        this.passenger = passenger;
        this.flight = flight;
        this.seatNumber = seatNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    public void generateTicketID(){
        this.ticketID = flight.getId() + "-" + seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public String getTicketID() {
        return ticketID;
    }
}
