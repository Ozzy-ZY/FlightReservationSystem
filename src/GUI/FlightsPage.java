package GUI;

import Models.Flight;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

class FlightContainer extends JLabel{
    JButton bookButton = new JButton("Book");
    JFrame bookingFrame = new JFrame("Booking");
    JPanel bookingPanel = new JPanel();
    public FlightContainer(Flight flight){
        JDialog bookingDialog = new JDialog(bookingFrame, "Booking", true);
        bookingPanel.setLayout(new BoxLayout(bookingPanel, BoxLayout.Y_AXIS));
        bookingPanel.add(bookingPanel);

        bookingFrame.setIconImage(new ImageIcon("Assets/Right_Flight.png").getImage());
        bookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookingFrame.setSize(300, 300);
        bookingFrame.setLocationRelativeTo(FlightContainer.this);
        bookingFrame.setVisible(true);

        bookButton.setBackground(Color.GREEN);
        bookButton.addActionListener(e -> {
        });
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
public class FlightsPage extends JFrame {
    JFrame flightsFrame = new JFrame("Flights");
    JPanel flightsPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<");
    JLabel flightHeader = new JLabel("Flights");
    JLabel SearchLabel = new JLabel("Where are you travelling from?");
    JLabel SearchLabel2 = new JLabel("Where are you travelling to?");
    JLabel errorLabel = new JLabel();



    public FlightsPage(){

        JComboBox<String> cityList = new JComboBox<>(Data.cities);
        JComboBox<String> cityList2 = new JComboBox<>(Data.cities);


        cityList.addActionListener(e -> {
            if (Objects.equals(cityList.getSelectedItem(), cityList2.getSelectedItem())) {
                errorLabel.setText("No flights available from the city to itself");
                errorLabel.setForeground(Color.RED);
            } else {
                errorLabel.setText("");
            }
        });

        cityList2.addActionListener(e -> {
            if (Objects.equals(cityList.getSelectedItem(), cityList2.getSelectedItem())) {
                errorLabel.setText("No flights available from the city to itself");
                errorLabel.setForeground(Color.RED);
            } else {
                errorLabel.setText("");
            }
        });

        flightsFrame.setSize(1000, 800);
        flightsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flightsFrame.setIconImage(icon.getImage());
        flightsFrame.setResizable(false);
        flightsFrame.setLocationRelativeTo(null);

        flightsPanel.setLayout(null);
        flightsPanel.add(SearchLabel);
        flightsPanel.add(backButton);
        flightsPanel.add(flightHeader);
        flightsPanel.add(cityList);
        flightsPanel.add(SearchLabel2);
        flightsPanel.add(cityList2);
        flightsFrame.add(flightsPanel);


        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(e -> {
            HomePage homePage = new HomePage();
            flightsFrame.dispose();
        });

        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.white);

        flightsPanel.setBackground(Color.decode("#213D58"));

        flightHeader.setFont(new Font("Arial", Font.BOLD, 26));
        flightHeader.setForeground(Color.WHITE);
        flightHeader.setBounds(450, 50, 100, 30);

        SearchLabel.setBounds(100, 100, 250, 30);
        SearchLabel.setFont(new Font("Arial", Font.BOLD, 14));
        SearchLabel.setForeground(Color.WHITE);

        cityList.setBounds(100, 130, 300, 30);
        cityList.setBackground(Color.WHITE);
        cityList.setForeground(Color.BLACK);

        SearchLabel2.setBounds(600, 100, 250, 30);
        SearchLabel2.setFont(new Font("Arial", Font.BOLD, 14));
        SearchLabel2.setForeground(Color.WHITE);

        cityList2.setBounds(600, 130, 300, 30);
        cityList2.setBackground(Color.WHITE);
        cityList2.setForeground(Color.BLACK);
        
        errorLabel.setBounds(370, 170, 300, 30); // Set the position and size of the error label
        flightsPanel.add(errorLabel);

        flightsFrame.setVisible(true);
    }

}


