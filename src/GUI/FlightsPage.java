package GUI;
import Controllers.ThemeManager;
import Models.Flight;
import Utils.QrGenerator;
import Utils.RoundedBorder;
import com.google.zxing.WriterException;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Timer;
import Utils.Generator;

import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;


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

    ImageIcon logoIcon = new ImageIcon("Assets/image-removebg-preview.png");

    ImageIcon scaledLogo = new ImageIcon(logoIcon.getImage().
            getScaledInstance(190, 80, Image.SCALE_SMOOTH));

    ImageIcon bg = new ImageIcon("Assets/loginBG.png");
    ImageIcon scaledBg = new ImageIcon(bg.getImage().
            getScaledInstance(500, 750, Image.SCALE_SMOOTH));
    JLabel bgIcon = new JLabel (scaledBg);

    ImageIcon bgD = new ImageIcon("Assets/loginBGD.png");
    ImageIcon scaledBgD = new ImageIcon(bgD.getImage().
            getScaledInstance(500, 750, Image.SCALE_SMOOTH));

    JLabel logoLabel = new JLabel(scaledLogo);

    JSplitPane headerSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

    JLabel flightHello = new JLabel("HELLO, " + HomePage.currentUser.getUsername().toUpperCase ());

    JLabel flightHeader = new JLabel("<html> SELECT YOUR <br>TRIP");


    JPanel footerPanel = new JPanel ();


    JLabel footerTxt = new JLabel("Find Your Flights");

    JLabel fromLabel = new JLabel("From");
    JSplitPane citySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

    JLabel toLabel = new JLabel("To");
    JLabel errorLabel = new JLabel();

    JLabel dateLabel = new JLabel ("Date");
    ImageIcon qrCode = new ImageIcon("src/Utils/qrcode.png");
    JLabel qrcode = new JLabel(qrCode);
    JButton confirmButton = new JButton("GO!");

    JButton AvailableFlights ;
    JButton AvailableFlights2 ;

    JTextField originCityTextField = new JTextField();
    JComboBox<String> originCityComboBox = new JComboBox<>();
    DefaultComboBoxModel<String> originComboBoxModel = new DefaultComboBoxModel<>();
    java.util.List<String> originCityOptions = new ArrayList<> ( Arrays.asList(Data.cities));
    JList<String> originSuggestionList = new JList<>();
    DefaultListModel<String> originListModel = new DefaultListModel<>();
    JPanel originSuggestionPanel = new JPanel();


    JTextField destinationCityTextField = new JTextField();
    JComboBox<String> destinationCityComboBox = new JComboBox<>();
    DefaultComboBoxModel<String> destinationComboBoxModel = new DefaultComboBoxModel<>();
    java.util.List<String> destinationCityOptions = new ArrayList<> ( Arrays.asList(Data.cities));
    JList<String> destinationSuggestionList = new JList<>();
    DefaultListModel<String> destinationListModel = new DefaultListModel<>();
    JPanel destinationSuggestionPanel = new JPanel();



    // Available flights popup
    JFrame Available_flights = new JFrame ("AvailableFlights");
    JPanel AvailablePanel = new JPanel (null);
    JLabel AvailableHello = new JLabel ("THIS IS");
    JLabel AvailableHeader = new JLabel ("<html>YOUR AVAILABLE <br> FLIGHTS");


    public FlightsPage(){

        MaskFormatter dateMask;
        try {
            dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('X');
        } catch (ParseException e) {
            throw new RuntimeException("Error initializing date input mask", e);
        }

         dateInput = new JFormattedTextField(dateMask);



        flightsFrame.setSize(500, 750);
        flightsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flightsFrame.setIconImage(icon.getImage());
        flightsFrame.setResizable(false);
        flightsFrame.setLocationRelativeTo(null);

        flightsPanel.setLayout(null);
        flightsPanel.add(originCityTextField);
        flightsPanel.add(originCityComboBox);
        flightsPanel.add(originSuggestionPanel);
        flightsPanel.add(destinationCityTextField);
        flightsPanel.add(destinationCityComboBox);
        flightsPanel.add(destinationSuggestionPanel);
        flightsPanel.add(backButton);
        flightsPanel.add(logoLabel);
        flightsPanel.add(headerSplit);
        flightsPanel.add(flightHello);
        flightsPanel.add(flightHeader);
        flightsPanel.add(fromLabel);
        flightsPanel.add(toLabel);
        flightsPanel.add(citySplit);
        flightsPanel.add(errorLabel);
        flightsPanel.add(dateLabel);
        flightsPanel.add(dateInput);
        flightsPanel.add(footerPanel);
        footerPanel.add(confirmButton);
        footerPanel.add(footerTxt);
        flightsPanel.add(bgIcon);

        originSuggestionPanel.setLayout(new BorderLayout());
        originSuggestionPanel.setVisible(false);
        originSuggestionPanel.add(new JScrollPane(originSuggestionList));

        destinationSuggestionPanel.setLayout(new BorderLayout());
        destinationSuggestionPanel.setVisible(false);
        destinationSuggestionPanel.add(new JScrollPane(destinationSuggestionList));

        flightsFrame.add(flightsPanel);

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(e -> {
            new HomePage();
            flightsFrame.dispose();
        });

        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.white);

        bgIcon.setBounds ( 150,-10,500,750 );

        logoLabel.setBounds ( 140,10,190,80 );

        headerSplit.setBounds ( 20,90,445,1 );
        headerSplit.setBackground ( Color.decode ( "#0B3E91" ) );

        flightHello.setFont(new Font("Arial", Font.BOLD, 16));
        flightHello.setForeground(Color.decode ( "#FD9426" ));
        flightHello.setBounds(20, 95, 400, 30);

        flightHeader.setFont(new Font("Arial", Font.BOLD, 40));
        flightHeader.setForeground(Color.decode ( "#0B3E91" ));
        flightHeader.setBounds(20, 130, 500, 80);

        fromLabel.setBounds(40, 250, 250, 50);
        fromLabel.setFont(new Font("Arial", Font.BOLD, 14));

        originCityTextField.setBounds(40, 290, 400, 50);
        originCityTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        originCityTextField.setBorder ( new RoundedBorder () );

        originSuggestionPanel.setBounds(40, 350, 400, 100);

        citySplit.setBounds ( 40,360,400,1 );

        toLabel.setBounds(40, 370, 250, 30);
        toLabel.setFont(new Font("Arial", Font.BOLD, 14));

        destinationCityTextField.setBounds(40, 400, 400, 50);
        destinationCityTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        destinationCityTextField.setBorder ( new RoundedBorder () );

        destinationSuggestionPanel.setBounds(40, 460, 400, 100);

        errorLabel.setBounds(20, 20, 300, 30);

        dateLabel.setBounds(40, 490, 40, 30);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));

        dateInput.setBounds(40, 520, 400, 40);
        dateInput.setFont(new Font("Arial", Font.BOLD, 30));
        dateInput.setBorder ( BorderFactory.createEmptyBorder () );
        dateInput.setOpaque ( false );

        footerPanel.setLayout ( null );
        footerPanel.setBounds ( 0,650,500,100 );
        footerPanel.setBackground ( Color.decode ( "#0B3E91" ) );

        footerTxt.setBounds ( 10,5,300,55 );
        footerTxt.setFont(new Font("Arial", Font.BOLD, 25));
        footerTxt.setForeground(Color.decode ( "#ffffff" ));

        confirmButton.setBounds ( 320,10,150,40 );
        confirmButton.setBackground ( Color.decode ( "#ffffff" ) );
        confirmButton.setForeground ( Color.decode ( "#0B3E91" ) );
        confirmButton.setFont(new Font("Arial", Font.BOLD, 18));
        confirmButton.setBorder ( BorderFactory.createEmptyBorder () );


        flightsFrame.setVisible(true);

        // Confirm button action

        confirmButton.addActionListener(e -> {

            city1 =  originCityTextField.getText ();
            city2 =  destinationCityTextField.getText ();

            if(city1.equals(city2)) {
                JOptionPane.showMessageDialog(flightsFrame, "You cannot select the same city for departure and arrival.");
                return;
            }

            if(!Arrays.asList(Data.cities).contains(city1) ) {
                JOptionPane.showMessageDialog(flightsFrame, "Your origin city can not be found !");
                return;
            }

            if(!Arrays.asList(Data.cities).contains(city2) ) {
                JOptionPane.showMessageDialog(flightsFrame, "Your destination city can not be found !");
                return;
            }

            JOptionPane.showMessageDialog(flightsFrame, "You selected: " + city1 + " and " + city2);
            originCityTextField.setEditable (false);
            destinationCityTextField.setEditable(false);

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
            datepassed2= Generator.randomDateGen(date);
            Flight flight1 = Generator.flightGen(city1, city2, datepassed1);
            Flight flight2 = Generator.flightGen(city1, city2, datepassed2);
            this.AvailableFlights = new JButton(flight1.toString());
            this.AvailableFlights2 = new JButton(flight2.toString());

            Available_flights.setResizable ( false );
            Available_flights.setSize(600, 300);
            Available_flights.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Available_flights.setIconImage(icon.getImage());
            Available_flights.setLocationRelativeTo(null);
            Available_flights.add(AvailablePanel);
            AvailablePanel.add(AvailableHello);
            AvailablePanel.add(AvailableHeader);
            AvailablePanel.add(AvailableFlights);
            AvailablePanel.add(AvailableFlights2);

            AvailableHello.setBounds ( 20,20,400,30 );
            AvailableHello.setFont ( new Font ( "Arial",Font.BOLD,15 ) );
            AvailableHello.setForeground ( Color.decode ( "#FD9426" ) );
            AvailableHeader.setBounds ( 20,50,400,60 );
            AvailableHeader.setFont ( new Font ( "Arial",Font.BOLD,25 ) );
            AvailableHeader.setForeground ( Color.decode ( "#0B3E91" ) );

            AvailableFlights.setBounds(20, 130, 550, 40);
            AvailableFlights.setFont(new Font("Arial", Font.BOLD, 18));
            AvailableFlights.setForeground(Color.white);
            AvailableFlights.setBackground(Color.decode("#0B3E91"));

            AvailableFlights2.setBounds(20, 190, 550, 40);
            AvailableFlights2.setFont(new Font("Arial", Font.BOLD, 18));
            AvailableFlights2.setForeground(Color.white);
            AvailableFlights2.setBackground(Color.decode("#0B3E91"));


            if(ThemeManager.isDarkMode ()){
                AvailableHello.setForeground ( Color.decode ( "#FD9426" ) );
                AvailableHeader.setForeground ( Color.decode ( "#ffffff" ) );

                AvailableFlights.setForeground(Color.white);
                AvailableFlights.setBackground(Color.decode("#0F1522"));
                AvailableFlights.setBorder ( BorderFactory.createEmptyBorder () );

                AvailableFlights2.setForeground(Color.white);
                AvailableFlights2.setBackground(Color.decode("#0F1522"));
                AvailableFlights2.setBorder ( BorderFactory.createEmptyBorder () );
            }else{

                AvailableHello.setForeground ( Color.decode ( "#FD9426" ) );
                AvailableHeader.setForeground ( Color.decode ( "#0B3E91" ) );

                AvailableFlights.setForeground(Color.white);
                AvailableFlights.setBackground(Color.decode("#0B3E91"));

                AvailableFlights2.setForeground(Color.white);
                AvailableFlights2.setBackground(Color.decode("#0B3E91"));
            }

            AvailableFlights.addActionListener(e1 -> {
                new ReservePage(city1,city2, datepassed1);
                flightsFrame.dispose();
                Available_flights.dispose ();
            });

            AvailableFlights2.addActionListener(e1 -> {
                new ReservePage(city1,city2,datepassed2);
                flightsFrame.dispose();
                Available_flights.dispose ();
            });

            Available_flights.addWindowListener(new WindowAdapter () {
                @Override
                public void windowClosing(WindowEvent e) {
                    flightsFrame.setEnabled ( true );
                    Available_flights.dispose ();
                    new FlightsPage ();
                }
            });
            flightsFrame.setEnabled ( false );
            Available_flights.setVisible ( true );
        });

        // Available popup

        originCityTextField.addActionListener(e -> originUpdateSuggestions());
        originCityTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                originUpdateSuggestions();
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });


        originCityComboBox.setVisible(false);
        originCityComboBox.setModel(originComboBoxModel);
        originCityComboBox.addActionListener(e -> {
            String selectedCity = (String) originCityComboBox.getSelectedItem();
            if (selectedCity != null) {
                originCityTextField.setText(selectedCity);
                originUpdateSuggestions();
            }
        });

        originSuggestionList.setModel(originListModel);
        originSuggestionList.setVisibleRowCount(5);
        originSuggestionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        originSuggestionList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedSuggestion = originSuggestionList.getSelectedValue();
                if (selectedSuggestion != null) {
                    originCityTextField.setText(selectedSuggestion);
                }
            }
        });

        flightsPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!originSuggestionPanel.isVisible()) {
                    return;
                }
                originSuggestionPanel.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        originSuggestionList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!originSuggestionPanel.isVisible()) {
                    return;
                }
                originSuggestionPanel.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        destinationCityTextField.addActionListener(e -> destinationUpdateSuggestions());

        destinationCityTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                destinationUpdateSuggestions();
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        destinationCityComboBox.setVisible(false);
        destinationCityComboBox.setModel(destinationComboBoxModel);
        destinationCityComboBox.addActionListener(e -> {
            String selectedCity = (String) destinationCityComboBox.getSelectedItem();
            if (selectedCity != null) {
                destinationCityTextField.setText(selectedCity);
                destinationUpdateSuggestions();
            }
        });

        destinationSuggestionList.setModel(destinationListModel);
        destinationSuggestionList.setVisibleRowCount(5);
        destinationSuggestionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        destinationSuggestionList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedSuggestion = destinationSuggestionList.getSelectedValue();
                if (selectedSuggestion != null) {
                    destinationCityTextField.setText(selectedSuggestion);
                }
            }
        });


        flightsPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!destinationSuggestionPanel.isVisible()) {
                    return;
                }
                destinationSuggestionPanel.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        destinationSuggestionList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!destinationSuggestionPanel.isVisible()) {
                    return;
                }
                destinationSuggestionPanel.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        if ( ThemeManager.isDarkMode ()) {
            setDarkMode();
        } else {
            setLightMode();
        }
    }


    private void setLightMode() {
        flightsPanel.setBackground(Color.decode("#EEF5FF"));

        bgIcon.setBounds ( 150,-10,500,750 );

        headerSplit.setBackground ( Color.decode ( "#0B3E91" ) );

        flightHello.setForeground(Color.decode ( "#FD9426" ));

        flightHeader.setForeground(Color.decode ( "#0B3E91" ));

        fromLabel.setForeground(Color.decode ( "#000000" ));

        originCityTextField.setBackground(Color.decode ( "#EEF5FF" ));
        originCityTextField.setForeground(Color.black);

        citySplit.setBackground ( Color.black );

        toLabel.setForeground(Color.black);

        destinationCityTextField.setBackground(Color.decode ( "#EEF5FF" ));
        destinationCityTextField.setForeground(Color.black);


        dateLabel.setForeground(Color.decode ( "#000000" ));

        dateInput.setBackground(Color.decode ( "#EEF5FF" ));
        dateInput.setForeground(Color.black);

        footerPanel.setBackground ( Color.decode ( "#0B3E91" ) );

        footerTxt.setForeground(Color.decode ( "#ffffff" ));

        confirmButton.setBackground ( Color.decode ( "#ffffff" ) );
        confirmButton.setForeground ( Color.decode ( "#0B3E91" ) );
        bgIcon.setIcon ( scaledBg );
        AvailablePanel.setBackground ( Color.decode ( "#ffffff" ) );

        ThemeManager.setDarkMode ( false );

    }

    private void setDarkMode() {
        flightsPanel.setBackground(Color.decode("#111827"));

        bgIcon.setBounds ( -300,-50,500,750 );

        headerSplit.setBackground ( Color.decode ( "#ffffff" ) );

        flightHello.setForeground(Color.decode ( "#FD9426" ));

        flightHeader.setForeground(Color.decode ( "#ffffff" ));


        fromLabel.setForeground(Color.decode ( "#ffffff" ));

        originCityTextField.setBackground(Color.decode ( "#0F1522" ));
        originCityTextField.setForeground(Color.white);

        originSuggestionList.setBackground ( Color.decode ( "#0c121c" ) );
        originSuggestionList.setForeground ( Color.decode ( "#ffffff" ) );

        destinationSuggestionList.setBackground ( Color.decode ( "#0c121c" ) );
        destinationSuggestionList.setForeground ( Color.decode ( "#ffffff" ) );


        citySplit.setBackground ( Color.white );

        toLabel.setForeground(Color.white);

        destinationCityTextField.setBackground(Color.decode ( "#0F1522" ));
        destinationCityTextField.setForeground(Color.white);


        dateLabel.setForeground(Color.decode ( "#ffffff" ));

        dateInput.setBackground(Color.decode ( "#0F1522" ));
        dateInput.setForeground(Color.white);

        footerPanel.setBackground ( Color.decode ( "#0F1522" ) );

        footerTxt.setForeground(Color.decode ( "#ffffff" ));

        confirmButton.setBackground ( Color.decode ( "#111827" ) );
        confirmButton.setForeground ( Color.decode ( "#ffffff" ) );

        bgIcon.setIcon ( scaledBgD );
        AvailablePanel.setBackground ( Color.decode ( "#111827" ) );


        ThemeManager.setDarkMode ( true );
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

    private void originUpdateSuggestions() {
        String text = originCityTextField.getText().toLowerCase();
        java.util.List<String> filteredList = originCityOptions.stream()
                .filter(city -> city.toLowerCase().startsWith(text))
                .collect( Collectors.toList());

        originListModel.removeAllElements();
        originListModel.addAll(filteredList);

        if (filteredList.isEmpty() || originCityTextField.getText().isEmpty()) {
            originSuggestionPanel.setVisible(false);
        } else {
            originSuggestionPanel.setVisible(true);
        }
    }

    private void destinationUpdateSuggestions() {
        String text = destinationCityTextField.getText().toLowerCase();
        java.util.List<String> filteredList = destinationCityOptions.stream()
                .filter(city -> city.toLowerCase().startsWith(text))
                .collect( Collectors.toList());

        destinationListModel.removeAllElements();
        destinationListModel.addAll(filteredList);

        if (filteredList.isEmpty() || destinationCityTextField.getText().isEmpty()) {
            destinationSuggestionPanel.setVisible(false);
        } else {
            destinationSuggestionPanel.setVisible(true);
        }
    }


}

