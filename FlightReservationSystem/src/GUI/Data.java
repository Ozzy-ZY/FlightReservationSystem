package GUI;

import Models.Flight;
import Models.Plane;

public class Data {
    private Plane plane = new Plane("Boeing 737", 150);
    public Flight[] fLights = new Flight[5];{
        fLights[0] = new Flight("1","Cairo","NewYork",plane,"14.9.2024");
        fLights[1] = new Flight("2","Alexandria","Chicago",plane,"19.11.2024");
        fLights[2] = new Flight("3","Mecca","Cairo",plane,"8.12.2024");
        fLights[3] = new Flight("4","London","Berlin",plane,"2.10.2024");
        fLights[4] = new Flight("5","Los Angelos","Cairo",plane,"15.9.2024");
    };
}
