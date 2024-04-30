package Models;

import java.util.Date;

public class Flight {
    private String id; // a 16-char alphanumeric string containing
    private String destination;
    private String origin;
    private Plane plane;
    private String date;
    public Flight(String id,String destination,String origin,Plane plane,String date){
        this.id = id;
        this.destination = destination;
        this.origin = origin;
        this.plane = plane;
        this.date = date;
    }
    public String getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return origin+"-->"+destination+"____Date: "+date+"____Plane: "+plane.getType();
    }

}
