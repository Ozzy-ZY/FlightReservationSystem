package GUI;
import Utils.QrGenerator;
import com.google.zxing.WriterException;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Objects;
import javax.swing.Timer;
import Utils.Generator;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class FlightsPage extends JFrame {
    public static JFormattedTextField dateInput;
    String city1;
    String city2;
    String datepassed1;
    String datepassed2;
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
    JLabel username = new JLabel("Username: " + HomePage.currentUser.getUsername());
    JLabel email = new JLabel("Email: " + HomePage.currentUser.getEmail());
    JLabel ID = new JLabel("ID: " + Generator.GenerateID());
    JButton AvailableFlights;
    JButton AvailableFlights2;
    JLabel DateText = new JLabel("Enter the date of your flight: ");





    public FlightsPage(){

        MaskFormatter dateMask;
        try {
            dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('-');
        } catch (ParseException e) {
            throw new RuntimeException("Error initializing date input mask", e);
        }

        JFormattedTextField dateInput = new JFormattedTextField(dateMask);


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
        flightsPanel.add(dateInput);
        flightsPanel.add(DateText);



        flightsFrame.add(flightsPanel);



        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(e -> {
            new HomePage();
            flightsFrame.dispose();
        });

        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.white);

        flightsPanel.setBackground(Color.decode("#213D58"));

        flightHeader.setFont(new Font("Arial", Font.BOLD, 26));
        flightHeader.setForeground(Color.WHITE);
        flightHeader.setBounds(450, 50, 100, 30);

        SearchLabel.setBounds(50, 100, 250, 30);
        SearchLabel.setFont(new Font("Arial", Font.BOLD, 14));
        SearchLabel.setForeground(Color.WHITE);

        cityList.setBounds(50, 130, 300, 30);
        cityList.setBackground(Color.WHITE);
        cityList.setForeground(Color.BLACK);

        SearchLabel2.setBounds(400, 100, 250, 30);
        SearchLabel2.setFont(new Font("Arial", Font.BOLD, 14));
        SearchLabel2.setForeground(Color.WHITE);

        dateInput.setBounds(750, 130, 200, 30);
        dateInput.setBackground(Color.WHITE);
        dateInput.setForeground(Color.BLACK);

        DateText.setBounds(750, 100, 250, 30);
        DateText.setFont(new Font("Arial", Font.BOLD, 14));
        DateText.setForeground(Color.WHITE);

        cityList2.setBounds(400, 130, 300, 30);
        cityList2.setBackground(Color.WHITE);
        cityList2.setForeground(Color.BLACK);

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

            String date = dateInput.getText();

            if (!isDateValid(date)) {
                JOptionPane.showMessageDialog(flightsFrame, "The date is not in the correct format. Please enter a date in the format dd/MM/yyyy.");
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(date, formatter);

            LocalDate currentDate = LocalDate.now();

            if (inputDate.isBefore(currentDate)) {
                JOptionPane.showMessageDialog(flightsFrame, "The date cannot be in the past.");
                return;
            }

            datepassed1= Generator.randomDateGen(date);
            this.AvailableFlights = new JButton(Generator.flightGen(city1,city2)+datepassed1);

            AvailableFlights.setBounds(360, 550, 600, 40);
            AvailableFlights.setFont(new Font("Arial", Font.BOLD, 18));
            AvailableFlights.setForeground(Color.white);
            AvailableFlights.setBackground(Color.decode("#213D58"));
            datepassed2= Generator.randomDateGen(date);
            this.AvailableFlights2 = new JButton(Generator.flightGen(city1,city2)+datepassed2);
            AvailableFlights2.setBounds(360, 600, 600, 40);
            AvailableFlights2.setFont(new Font("Arial", Font.BOLD, 18));
            AvailableFlights2.setForeground(Color.white);
            AvailableFlights2.setBackground(Color.decode("#213D58"));

            AvailableFlights.addActionListener(e1 -> {
                new ReservePage(city1,city2, datepassed1);
                flightsFrame.dispose();
            });

            AvailableFlights2.addActionListener(e1 -> {
                new ReservePage(city1,city2,datepassed2);
                flightsFrame.dispose();
            });

            flightsPanel.revalidate(); // Revalidate the panel
            flightsPanel.repaint();
        });
        flightsPanel.add(confirmButton);
    }

    private boolean isDateValid(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    private void generateQRCode() {
        if(city1 != null && city2 != null && !city1.equals(city2)) {
            try {
                try {
                    QrGenerator.saveQRCodeImage(QrGenerator.
                            generateQRCode(HomePage.currentUser.getUsername() +
                                    " Going From " + city1 + " To " + city2), "src/Utils/qrcode.png");
                } catch (IOException z) {
                    throw new RuntimeException(z);
                }
            } catch (WriterException z) {
                throw new RuntimeException(z);
            }
        }
            flightsPanel.remove(qrcode); // Remove the old QR code from the panel

            // Create a timer that waits for 5 seconds before displaying the new QR code
            Timer timer = new Timer(100, e -> {
                qrCode.getImage().flush();
                ImageIcon newQrCode = new ImageIcon("src/Utils/qrcode.png"); // Create a new ImageIcon
                qrcode = new JLabel(newQrCode); // Assign the new ImageIcon to the JLabel
                qrcode.setBounds(50, 400, 300, 300);
                flightsPanel.add(qrcode); // Add the new QR code to the panel
                flightsPanel.revalidate();
                flightsPanel.repaint();
                flightsPanel.add(username);
                flightsPanel.add(email);
                flightsPanel.add(AvailableFlights);
                flightsPanel.add(AvailableFlights2);
            });
            timer.setRepeats(false); // Ensure the timer only runs once
            timer.start(); // Start the timer
    }

}


