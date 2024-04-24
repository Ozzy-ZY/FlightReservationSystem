package GUI;

import Models.Flight;

import javax.swing.*;
import java.awt.*;
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
    Data data = new Data();
    JFrame flightsFrame = new JFrame("Flights");
    JPanel flightsPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<<--");
    JLabel flightHeader = new JLabel("Flights");
    JLabel SearchLabel = new JLabel("Search By City:");
    JTextField SearchField = new JTextField(30);
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

        flightsFrame.setVisible(true);
        flightsFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
