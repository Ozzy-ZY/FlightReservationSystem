package GUI;

import Models.Flight;

import javax.swing.*;
import java.awt.*;

public class FlightsPage extends JFrame {
    Data data = new Data();
    JFrame flightsFrame = new JFrame("Flights");
    JPanel flightsPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<<--");
    JLabel flightHeader = new JLabel("Flights");
    JLabel SearchLabel = new JLabel("Search By City:");
    JTextField SearchField = new JTextField(30);
    JLabel FlightContainer = new JLabel();
    public FlightsPage(){
        flightsFrame.setSize(500, 600);
        flightsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flightsFrame.setIconImage(icon.getImage());
        flightsFrame.setResizable(false);
        flightsFrame.setLocationRelativeTo(null);
        flightsFrame.add(flightsPanel);

        flightsPanel.setLayout(null);
        flightsPanel.add(SearchLabel);
        flightsPanel.add(SearchField);
        flightsPanel.add(backButton);
        flightsPanel.add(flightHeader);
        flightsPanel.add(FlightContainer);

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(e -> {
            HomePage homePage = new HomePage();
            flightsFrame.dispose();
        });

        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.CYAN);
        flightsPanel.setBackground(new java.awt.Color(70, 109, 176));
        flightHeader.setFont(new Font("Arial", Font.BOLD, 18));
        flightHeader.setBounds(200, 50, 100, 30);
        SearchLabel.setBounds(30, 100, 150, 30);
        SearchLabel.setFont(new Font("Arial", Font.BOLD, 14));
        SearchField.setBounds(150, 100, 200, 30);
        FlightContainer.setBounds(20, 150, 460, 50);
        FlightContainer.setText(data.fLights[0].toString());
        flightsFrame.setVisible(true);
        flightsFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }


}
