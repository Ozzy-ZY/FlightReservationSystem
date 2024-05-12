package Models;

import jdk.jshell.execution.Util;

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

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public void generateTicketID(){
        this.ticketID = flight.getId() + "_" + seatNumber;
    }

    public String getTicketID() {
        return ticketID;
    }
    public Ticket(String ticketID,String origin, String destination,String date, String lastName, int sNumber){
        flight = new Flight();
        passenger = new Passenger();
        this.ticketID = ticketID;
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setDate(date);
        passenger.setLastname(lastName);
        seatNumber = sNumber;

    }
    public Ticket(String username, String ticketID){
        flight = new Flight();
        passenger = new Passenger();
        try{
            var data = Utils.FileManager.read("tickets/"+username+".txt");
            var dataArray = data.split("\n");
            for(var ticket: dataArray){
                var ticketData = ticket.split("-");
                if(ticketData[0].equals(ticketID)){
                    this.ticketID = ticketData[0];
                    this.flight.setOrigin(ticketData[1]);
                    this.flight.setDestination(ticketData[2]);
                    this.flight.setDate(ticketData[3]);
                    this.passenger.setLastname(ticketData[4]);
                    this.seatNumber = Integer.parseInt(ticketData[5]);
                }
            }
        }
        catch (Exception e){
            System.out.println("Error reading ticket file: "+e.getMessage());
        }
    }
}
