package Models;

public class Plane {
    private String type;
    private int numOfPassengers;
    public Plane(String Type, int NumOfPassengers){
        type = Type;
        numOfPassengers = NumOfPassengers;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public String getType() {
        return type;
    }
}
