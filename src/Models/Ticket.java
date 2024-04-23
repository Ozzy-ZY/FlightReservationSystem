package Models;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private int seatnumber;
    public Ticket(Passenger passenger,Flight flight,int seatnumber){
        this.passenger = passenger;
        this.flight = flight;
        this.seatnumber = seatnumber;
    }


}
