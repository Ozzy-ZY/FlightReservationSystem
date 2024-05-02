package GUI;
import Models.Flight;
import Utils.QrGenerator;
import com.google.zxing.WriterException;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Utils.Generator;

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


    String city1;
    String city2;
    JFrame flightsFrame = new JFrame("Flights");
    JPanel flightsPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<");
    JLabel flightHeader = new JLabel("Flights");
    JLabel SearchLabel = new JLabel("Where are you travelling from?");
    JLabel SearchLabel2 = new JLabel("Where are you travelling to?");
    JLabel errorLabel = new JLabel();
    ImageIcon qrCode = new ImageIcon("src/Utils/qrcode.png");
    JLabel qrcode = new JLabel(qrCode);
    JButton confirmButton = new JButton("Confirm");
    JLabel countdownLabel = new JLabel();

    JLabel username = new JLabel("Username: " + HomePage.currentUser.getUsername());
    JLabel email = new JLabel("Email: " + HomePage.currentUser.getEmail());
    JLabel ID = new JLabel("ID: " + Generator.GenerateID());
    JLabel AvailableFlights;
    JLabel AvailableFlights2;



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

        countdownLabel.setForeground(Color.WHITE);

        username.setBounds(360, 420, 400, 60);
        username.setFont(new Font("Arial", Font.BOLD, 18));
        username.setForeground(Color.WHITE);

        email.setBounds(360, 460, 400, 60);
        email.setFont(new Font("Arial", Font.BOLD, 18));
        email.setForeground(Color.WHITE);

        ID.setBounds(360, 500, 400, 60);
        ID.setFont(new Font("Arial", Font.BOLD, 18));
        ID.setForeground(Color.WHITE);





        errorLabel.setBounds(370, 170, 300, 30); // Set the position and size of the error label
        flightsPanel.add(errorLabel);

        flightsFrame.setVisible(true);

        confirmButton.setBounds(450, 200, 100, 30); // Set the position and size of the confirm button
        confirmButton.addActionListener(e -> {
            city1 = (String) cityList.getSelectedItem();
            city2 = (String) cityList2.getSelectedItem();
            if(city1.equals(city2)) {
                JOptionPane.showMessageDialog(flightsFrame, "You cannot select the same city for departure and arrival.");
                return;
            }
            JOptionPane.showMessageDialog(flightsFrame, "You selected: " + city1 + " and " + city2);
            cityList.setEnabled(false);
            cityList2.setEnabled(false);
            generateQRCode();
            countdownLabel.setText("Please wait for your data: 5s");
            countdownLabel.setBounds(50, 370, 200, 30); // Set the position and size of the countdown label
            flightsPanel.add(countdownLabel);
            this.AvailableFlights = new JLabel( "Available Flights: "+ Generator.flightGen(city1,city2));
            AvailableFlights.setBounds(360, 450, 600, 240);
            AvailableFlights.setFont(new Font("Arial", Font.BOLD, 18));
            AvailableFlights.setForeground(Color.WHITE);

            this.AvailableFlights2 = new JLabel( Generator.flightGen(city1,city2));
            AvailableFlights2.setBounds(518, 490, 600, 240);
            AvailableFlights2.setFont(new Font("Arial", Font.BOLD, 18));
            AvailableFlights2.setForeground(Color.WHITE);

            flightsPanel.revalidate(); // Revalidate the panel
            flightsPanel.repaint();
        });
        flightsPanel.add(confirmButton);






    }

    private void generateQRCode() {
        if(city1 != null && city2 != null && !city1.equals(city2)) {
            try {
                try {
                    QrGenerator.saveQRCodeImage(QrGenerator.generateQRCode(HomePage.currentUser.getUsername() + " Going From " + city1 + " To " + city2), "src/Utils/qrcode.png");
                } catch (IOException z) {
                    throw new RuntimeException(z);
                }
            } catch (WriterException z) {
                throw new RuntimeException(z);
            }
        }
            flightsPanel.remove(qrcode); // Remove the old QR code from the panel

            // Create a timer that waits for 5 seconds before displaying the new QR code
            Timer timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    qrCode.getImage().flush();
                    ImageIcon newQrCode = new ImageIcon("src/Utils/qrcode.png"); // Create a new ImageIcon
                    qrcode = new JLabel(newQrCode); // Assign the new ImageIcon to the JLabel
                    qrcode.setBounds(50, 400, 300, 300);
                    flightsPanel.add(qrcode); // Add the new QR code to the panel
                    flightsPanel.revalidate();
                    flightsPanel.repaint();
                    flightsPanel.remove(countdownLabel); // Remove the countdown label
                    flightsPanel.add(username);
                    flightsPanel.add(email);
                    flightsPanel.add(ID);
                    flightsPanel.add(AvailableFlights);
                    flightsPanel.add(AvailableFlights2);
                }
            });
            timer.setRepeats(false); // Ensure the timer only runs once
            timer.start(); // Start the timer
    }

}


