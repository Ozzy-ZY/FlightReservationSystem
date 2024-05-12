package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import Controllers.PassengerControl;
import Controllers.ThemeManager;
import Models.Passenger;
import Models.Ticket;
import Utils.Generator;
import Utils.RoundedBorder;
import static Utils.FileManager.*;
import static Controllers.PassengerControl.*;

public class ReservePage extends JFrame {
    static Passenger PassengerData = new Passenger();
    public Ticket ticket;
    JPanel panel;
    JLabel reserveHeader = new JLabel("Reservation with");
    JLabel reservrihla = new JLabel("Rihla");
    JLabel firstNameLabel = new JLabel("First Name");
    JLabel lastNamelabel = new JLabel("Last Name");
    JButton backButton = new JButton("<-");
    JLabel PassportLabel = new JLabel("Passport Number");
    JLabel phoneNumLabel = new JLabel("Phone Number");
    JLabel BirthDateLabel = new JLabel("Birth Date");
    JLabel Thankslabel = new JLabel("Thank you for booking with us!");
    JTextField firstnameField = new JTextField();
    JTextField lastnameField = new JTextField();
    JTextField PassportField = new JTextField();
    JTextField PhoneNumField = new JTextField() {
        @Override
        public void processFocusEvent(FocusEvent e) {
            super.processFocusEvent(e);
            if (e.getID() == FocusEvent.FOCUS_LOST) {
                String phoneNumber = getText();
                if (phoneNumber.length() == 10) {
                    // Format the phone number as XXX-XXX-XXXX
                    phoneNumber = String.format("%s-%s-%s", phoneNumber.substring(0, 3), phoneNumber.substring(3, 6), phoneNumber.substring(6, 10));
                    setText(phoneNumber);
                }
            }
        }
    };
    JComboBox<String> monthComboBox = new JComboBox<>();
    JComboBox<String> dayComboBox = new JComboBox<>();
    JComboBox<Integer> yearComboBox = new JComboBox<>();

    ImageIcon reservation = new ImageIcon("Assets/output-onlinepngtools4.png");
    ImageIcon scaledreserv = new ImageIcon(reservation.getImage().getScaledInstance(845, 845, Image.SCALE_SMOOTH));
    ImageIcon reservationd = new ImageIcon("Assets/output-onlinepngtools7.png");
    ImageIcon scaledreservd = new ImageIcon(reservationd.getImage().getScaledInstance(845, 845, Image.SCALE_SMOOTH));

    JLabel reservimg = new JLabel(scaledreserv);
    JLabel reservimgserd = new JLabel(scaledreservd);
    JLabel day=new JLabel("DD");
    JLabel month=new JLabel("MM");
    JLabel year=new JLabel("YY");

    JButton confirmButton = new JButton("Confirm");

    public ReservePage(String origin, String destination, String date) {
        setTitle("Reservation Page");
        setSize(845, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panel = new JPanel(); // Initialize panel
        panel.setLayout(null);

        reserveHeader.setLayout(null);
        reserveHeader.setBounds(20, 10, 280, 40);
        reserveHeader.setFont(new Font("Helvetica", Font.BOLD, 35));

        panel.add(reserveHeader);

        firstNameLabel.setBounds(20, 80, 130, 35);
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 25));

        panel.add(firstNameLabel);
        panel.add(backButton);
        backButton.setBounds(0, 0, 50, 20);
        backButton.setBackground(Color.white);
        backButton.addActionListener(e -> {
            dispose();
            new FlightsPage();
        });

        firstnameField.setBounds(20, 120, 300, 30);
        firstnameField.setFont(new Font("Arial", Font.BOLD, 20));
        firstnameField.setBorder(new RoundedBorder());

        panel.add(firstnameField);

        lastNamelabel.setBounds(460, 80, 150, 30);
        lastNamelabel.setFont(new Font("Arial", Font.BOLD, 25));

        panel.add(lastNamelabel);

        lastnameField.setBounds(460, 120, 300, 30);
        lastnameField.setFont(new Font("Arial", Font.BOLD, 20));
        lastnameField.setBorder(new RoundedBorder());

        panel.add(lastnameField);

        PassportLabel.setBounds(20, 180, 220, 35);
        PassportLabel.setFont(new Font("Arial", Font.BOLD, 25));

        panel.add(PassportLabel);

        PassportField.setBounds(20, 220, 480, 30);
        PassportField.setFont(new Font("Arial", Font.BOLD, 20));
        PassportField.setBorder(new RoundedBorder());

        panel.add(PassportField);

        phoneNumLabel.setBounds(20, 280, 180, 30);
        phoneNumLabel.setFont(new Font("Arial", Font.BOLD, 25));

        panel.add(phoneNumLabel);

        PhoneNumField.setBounds(20, 320, 480, 30);
        PhoneNumField.setFont(new Font("Arial", Font.BOLD, 20));
        PhoneNumField.setBorder(new RoundedBorder());

        panel.add(PhoneNumField);


        day.setBounds(530,245,50,30);
        day.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(day);

        month.setBounds(620,245,50,30);
        month.setFont(new Font("Arial", Font.BOLD, 20));
        month.setForeground(Color.decode("#1A3492"));
        panel.add(month);

        year.setBounds(745,245,50,30);
        year.setFont(new Font("Arial", Font.BOLD, 20));
        year.setForeground(Color.decode("#1A3492"));
        panel.add(year);


        BirthDateLabel.setBounds(600, 200, 180, 30);
        BirthDateLabel.setFont(new Font("Arial", Font.BOLD, 25));


        panel.add(BirthDateLabel);

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (String month : months) {
            monthComboBox.addItem(month);
        }
        monthComboBox.setBounds(585, 280, 130, 40);
        monthComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        monthComboBox.setBorder(new RoundedBorder());

        panel.add(monthComboBox);

        dayComboBox.setBounds(520, 280, 60, 40);

        dayComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        dayComboBox.setBorder(new RoundedBorder());

        panel.add(dayComboBox);

        updateDayList();

        for (int year = 1900; year <= 2024; year++) {
            yearComboBox.addItem(year);
        }
        yearComboBox.setBounds(720, 280, 100, 40);

        yearComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        yearComboBox.setBorder(new RoundedBorder());

        panel.add(yearComboBox);

        confirmButton.setBounds(590, 390, 180, 55);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 15));

        confirmButton.setForeground(Color.white);
        confirmButton.setBorder(new RoundedBorder());

        Thankslabel.setBounds(10, 390, 450, 40);
        Thankslabel.setFont(new Font("Segoe Script", Font.BOLD, 25));

        reservrihla.setBounds(320, 14, 250, 40);
        reservrihla.setFont(new Font("Segoe Script", Font.BOLD, 35));
        panel.add(reservrihla);
        panel.add(Thankslabel);
        panel.add(confirmButton);
        panel.add(reservimg);
        panel.add(reservimgserd);
        add(panel);
        firstnameField.addActionListener(e -> {
            if(nameValidation(firstnameField.getText())){
                PassengerData.setFirstname(firstnameField.getText());
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid First Name");
            }
        });
        lastnameField.addActionListener(e -> {
            if(nameValidation(lastnameField.getText())){
                PassengerData.setLastname(lastnameField.getText());
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Last Name");
            }
        });
        PassportField.addActionListener(e -> {
            if(passportIdValidation(PassportField.getText())){
                PassengerData.setPassportId(PassportField.getText());
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Passport Number");
            }
        });
        PhoneNumField.addActionListener(e -> {
            if(phoneNumberValidation(PhoneNumField.getText())){
                PassengerData.setPhoneNumber(PhoneNumField.getText());
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Phone Number");
            }
        });
        confirmButton.addActionListener(e -> {
            if(passengerValidation(firstnameField.getText(),lastnameField.getText(),
                    PassportField.getText(),PhoneNumField.getText(),dayComboBox.getSelectedItem().
                            toString()+"/"+monthComboBox.getSelectedItem().toString()+
                            "/"+yearComboBox.getSelectedItem().toString()) &&
                    GetEveryTicketIDGivenUsername(HomePage.currentUser.getUsername()).length < 3){
                PassengerData.setUsername(HomePage.currentUser.getUsername());
                PassengerData.setEmail(HomePage.currentUser.getEmail());
                PassengerData.setPassword(HomePage.currentUser.getPassword());
                PassengerData.setFirstname(firstnameField.getText());
                PassengerData.setLastname(lastnameField.getText());
                PassengerData.setPassportId(PassportField.getText());
                PassengerData.setPhoneNumber(PhoneNumField.getText());
                PassengerData.setBirthdate(dayComboBox.getSelectedItem().toString()+"/"+monthComboBox.getSelectedItem().toString()+"/"+yearComboBox.getSelectedItem().toString());
                savePassengerData(PassengerData);
                Ticket ticket  = Generator.ticketGen(PassengerData,Generator.flightGen(origin,destination,date),41);
                Utils.FileManager.append("tickets/"+HomePage.currentUser.getUsername()+"Tickets.txt",
                        ticket.getTicketID()+
                            "-"+ticket.getFlight().getOrigin()+
                            "-"+ticket.getFlight().getDestination()+
                            "-"+ticket.getFlight().getDate()+
                            "-"+ticket.getPassenger().getFirstName ()+
                            "-"+ticket.getPassenger().getLastName()+
                            "-"+ticket.getSeatNumber()+"\n");
                JOptionPane.showMessageDialog(null, "Reservation Successful");
                dispose();
                new TicketGUI (ticket);
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Data");
            }
        });

        setVisible(true);

        if (ThemeManager.isDarkMode()) {
            setDarkMode();
        } else {
            setLightMode();
        }

        // Auto Complete Fields If User Details Exits
        if( PassengerControl.isEmailStored ( HomePage.currentUser.getEmail () ) ){
            firstnameField.setText ( getFirstname ( HomePage.currentUser.getEmail () ) );
            lastnameField.setText ( getLastname ( HomePage.currentUser.getEmail () ) );
            PassportField.setText ( getPassportID ( HomePage.currentUser.getEmail () ) );
            PhoneNumField.setText ( getPhoneNumber ( HomePage.currentUser.getEmail () ) );

        }
    }

    private void updateDayList() {
        int month = monthComboBox.getSelectedIndex();
        dayComboBox.removeAllItems();
        int maxDays = 31;
        if (month == 1) {
            maxDays = 28; // February
        } else if (month == 3 || month == 5 || month == 8 || month == 10) {
            maxDays = 30; // April, June, September, November
        }
        for (int i = 1; i <= maxDays; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }
    }

    private void setLightMode() {
        panel.setBackground(Color.decode("#ffffff"));
        reserveHeader.setForeground(Color.decode("#1A3492"));
        firstNameLabel.setForeground(Color.decode("#1A3492"));
        firstnameField.setBackground(Color.decode("#ffffff"));
        firstnameField.setForeground(Color.decode("#fc7303"));
        lastNamelabel.setForeground(Color.decode("#1A3492"));
        lastnameField.setBackground(Color.decode("#ffffff"));
        lastnameField.setForeground(Color.decode("#fc7303"));
        PassportLabel.setForeground(Color.decode("#1A3492"));
        PassportField.setBackground(Color.decode("#ffffff"));
        PassportField.setForeground(Color.decode("#fc7303"));
        phoneNumLabel.setForeground(Color.decode("#1A3492"));
        PhoneNumField.setBackground(Color.decode("#ffffff"));
        PhoneNumField.setForeground(Color.decode("#fc7303"));
        confirmButton.setBackground(Color.decode("#1A3492"));
        confirmButton.setForeground(Color.decode("#fc7303"));
        Thankslabel.setForeground(Color.decode("#fc7303"));
        reservrihla.setForeground(Color.decode("#fc7303"));
        BirthDateLabel.setForeground(Color.decode("#1A3492"));
        dayComboBox.setBackground(Color.decode("#ffffff"));
        dayComboBox.setForeground(Color.decode("#fc7303"));
        yearComboBox.setBackground(Color.decode("#ffffff"));
        yearComboBox.setForeground(Color.decode("#fc7303"));
        monthComboBox.setBackground(Color.decode("#ffffff"));
        monthComboBox.setForeground(Color.decode("#fc7303"));
        day.setForeground(Color.decode("#1A3492"));
        month.setForeground(Color.decode("#1A3492"));
        year.setForeground(Color.decode("#1A3492"));
        reservimg.setIcon(scaledreserv);
        reservimg.setBounds(0, 0, 845, 500);

        ThemeManager.setDarkMode(false);
    }

    private void setDarkMode() {
        panel.setBackground(Color.decode("#000000"));
        reserveHeader.setForeground(Color.decode("#ffffff"));
        firstNameLabel.setForeground(Color.decode("#ffffff"));
        firstnameField.setForeground(Color.decode("#fc7303"));
        firstnameField.setBackground(Color.decode("#000000"));
        lastNamelabel.setForeground(Color.decode("#ffffff"));
        lastnameField.setBackground(Color.decode("#000000"));
        lastnameField.setForeground(Color.decode("#fc7303"));
        PassportLabel.setForeground(Color.decode("#ffffff"));
        PassportField.setBackground(Color.decode("#000000"));
        PassportField.setForeground(Color.decode("#fc7303"));
        phoneNumLabel.setForeground(Color.decode("#ffffff"));
        PhoneNumField.setBackground(Color.decode("#000000"));
        PhoneNumField.setForeground(Color.decode("#fc7303"));
        confirmButton.setBackground(Color.decode("#ffffff"));
        confirmButton.setForeground(Color.decode("#fc7303"));
        //confirmButton.setForeground(Color.black);
        Thankslabel.setForeground(Color.decode("#fc7303"));
        reservrihla.setForeground(Color.decode("#fc7303"));
        BirthDateLabel.setForeground(Color.decode("#ffffff"));
        dayComboBox.setBackground(Color.decode("#000000"));
        dayComboBox.setForeground(Color.decode("#fc7303"));
        yearComboBox.setBackground(Color.decode("#000000"));
        yearComboBox.setForeground(Color.decode("#fc7303"));
        monthComboBox.setBackground(Color.decode("#000000"));
        monthComboBox.setForeground(Color.decode("#fc7303"));
        day.setForeground(Color.decode("#fc7303"));
        month.setForeground(Color.decode("#fc7303"));
        year.setForeground(Color.decode("#fc7303"));
        reservimgserd.setIcon(scaledreservd);
        reservimg.setBounds(0, 0, 845, 500);

        ThemeManager.setDarkMode(true);
    }


}