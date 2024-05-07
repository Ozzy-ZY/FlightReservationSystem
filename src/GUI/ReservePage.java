package GUI;
import javax.swing.*;
import java.awt.*;
import Models.Flight;
import Models.Plane;
import javax.swing.JPanel;
import GUI.FlightsPage;

public class ReservePage {
    public   String origin;
    public String destination;
    public String date;

    public ReservePage(String origin, String destination, String date) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;

        // Create a new JFrame
        JFrame frame = new JFrame("Reserve Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a JPanel
        JPanel panel = new JPanel();
        frame.add(panel);

        // Create JLabels for origin, destination, and date
        JLabel originLabel = new JLabel("Origin: " + origin);
        JLabel destinationLabel = new JLabel("Destination: " + destination);
        JLabel dateLabel = new JLabel("Date: " + date);

        // Add the labels to the panel
        panel.add(originLabel);
        panel.add(destinationLabel);
        panel.add(dateLabel);

        // Set the frame to be visible
        frame.setVisible(true);
    }

}