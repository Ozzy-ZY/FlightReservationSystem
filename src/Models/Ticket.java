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

    public int getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(int seatnumber) {
        this.seatnumber = seatnumber;
    }
}
