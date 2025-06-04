
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class containing all the code for user interface along with their
 * functionality for a Gym Management System.
 * This class handles the creation of the GUI components
 * and implements all the functionality for managing gym members.
 * 
 * @author Shulav Shakya
 * @version 1.0
 */
public class GymGUI {
    /**
     * Main frames for the application
     */
    private JFrame frame, revertFrame, displayFrame, saveToFileFrame;

    /**
     * Panels for organizing GUI components
     */
    private JPanel generalPanel, regularPanel, premiumPanel, btnPanel, revertMemberPanel, saveToFilePanel;

    /**
     * Labels for all form fields
     */
    private JLabel welcomeLabel, idLabel, nameLabel, locationLabel, phoneLabel, emailLabel, genderLabel,
            dobLabel, referralLabel, paidAmountLabel, removalReasonLabel, trainerNameLabel, membershipLabel, planLabel,
            discountLabel, regularHeadingPanel, premiumHeadingPanel, revertMemberIdLabel,
            premiumChargeLabel;

    /**
     * Text fields for user input
     */
    private JTextField idField, nameField, locationField, phoneField, emailField, referralField,
            paidAmountField, removalReasonField, trainerNameField, planPriceField, discountField, revertMemberIdField,
            premiumChargeField;

    /**
     * Scroll pane for the display area
     */
    private JScrollPane scrollPane;

    /**
     * Text area for displaying member information
     */
    private JTextArea displayArea;

    /**
     * Combo boxes for date selection and plan selection
     */
    private JComboBox<String> yearComboBox, monthComboBox, dayComboBox, planComboBox, memYearComboBox,
            memMonthComboBox, memDayComboBox;

    /**
     * Radio buttons for gender selection
     */
    private JRadioButton maleButton, femaleButton;

    /**
     * Button group for gender radio buttons
     */
    private ButtonGroup genderButtonGroup;

    /**
     * Buttons for various actions
     */
    private JButton addRegButton, addPremButton, markAttendanceButton, activateMembershipButton,
            deactivateMembershipButton, revertMemberButton, clearButton, displayButton, revertRegularMemberButton,
            revertPremiumMemberButton, calculateDiscountButton, payDueAmountButton, saveToFileButton,
            LoadFromFileButton, UpgradePlanButton, saveToFileRegularMemberButton, saveToFilePremiumMemberButton;

    /**
     * ArrayList to store all gym members
     */
    private ArrayList<GymMember> members;

    /**
     * Main method to start the application
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        new GymGUI();
    }

    /**
     * Constructor for GymGUI
     * Initializes all GUI components and sets up the main application window
     * Adds sample members for testing purposes
     */
    @SuppressWarnings({"Convert2Lambda", "Convert2Diamond"})
    public GymGUI() {
        members = new ArrayList<>();
        members.add(new RegularMember(1, "Shulav Shakya", "Dhran", "9816338989",
                "shakyashulav29@gmail.com", "Male",
                "2006-09-06", "2021-04-7", "Ram"));
        members.add(new PremiumMember(2, "Ram Bahadur Thapa", "Kathmandu",
                "9812093091", "ram.thapa@example.com", "Male", "2000-04-05", "2025-06-02",
                "Bishnu Gurung"));
        // members.add(new RegularMember(3, "Bina Thapa", "Pokhara", "9890000050",
        // "bina.thapa@example.com",
        // "Female", "1990-07-25", "2023-10-20", "Manoj Shrestha"));
        // members.add(new RegularMember(4, "Gita Bhandari", "Biratnagar", "9844000004",
        // "gita.bhandari@example.com",
        // "Female", "1988-07-22", "2023-09-10", "Sita Magar"));

        // MAIN FRAME
        frame = new JFrame("Gym Buddy");
        frame.setSize(930, 690);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // REVERT FRAME
        revertFrame = new JFrame("Revert Member");
        revertFrame.setSize(400, 200);
        revertFrame.setVisible(false);
        revertFrame.setLocationRelativeTo(null);

        saveToFileFrame = new JFrame("Save to File");
        saveToFileFrame.setSize(400, 150);
        saveToFileFrame.setVisible(false);
        saveToFileFrame.setLocationRelativeTo(null);

        // DISPLAY FRAME
        displayFrame = new JFrame("Display Members");
        displayFrame.setSize(930, 600);
        displayFrame.setVisible(false);
        displayFrame.setLocationRelativeTo(null);

        // PANELS
        generalPanel = new JPanel(null);
        generalPanel.setBounds(20, 80, 520, 300);
        generalPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        regularPanel = new JPanel(null);
        regularPanel.setBounds(550, 80, 360, 135);
        regularPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        premiumPanel = new JPanel(null);
        premiumPanel.setBounds(550, 225, 360, 155);
        premiumPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        revertMemberPanel = new JPanel(null);
        revertMemberPanel.setBounds(10, 100, 400, 100);

        saveToFilePanel = new JPanel(null);
        saveToFilePanel.setBounds(10, 50, 400, 100);

        // WELCOME BANNER
        welcomeLabel = new JLabel("Welcome to GymBuddy");
        welcomeLabel.setBounds(330, 20, 300, 40);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Input Fields
        idLabel = new JLabel("Id: ");
        idLabel.setBounds(40, 23, 100, 30);
        idField = new JTextField();
        idField.setBounds(140, 23, 200, 30);

        // NAME
        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(40, 53, 100, 30);
        nameField = new JTextField();
        nameField.setBounds(140, 53, 200, 30);

        // LOCATION
        locationLabel = new JLabel("Location: ");
        locationLabel.setBounds(40, 83, 100, 30);
        locationField = new JTextField();
        locationField.setBounds(140, 83, 200, 30);

        // PHONE
        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(40, 113, 100, 30);
        phoneField = new JTextField();
        phoneField.setBounds(140, 113, 200, 30);

        // EMAIL
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(40, 143, 100, 30);
        emailField = new JTextField();
        emailField.setBounds(140, 143, 200, 30);

        // GENDER
        genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(40, 173, 100, 30);
        maleButton = new JRadioButton("Male");
        maleButton.setBounds(140, 173, 80, 30);
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(210, 173, 80, 30);

        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleButton);
        // BUTTONGROUP FOR GENDER BUTTONS
        genderButtonGroup.add(femaleButton);

        // COMBOBOX VALUES FOR DOB AND MEMBERSHIP START DATES
        String[] year = { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
                "2010",
                "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022",
                "2023",
                "2024", "2025" };
        String[] month = { "January", "February", "March", "April", "May", "June", "July", "August",
                "September",
                "October", "November", "December" };
        String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

        // DOB COMBOBOX
        dobLabel = new JLabel("DOB: ");
        dobLabel.setBounds(40, 203, 100, 30);
        yearComboBox = new JComboBox<String>(year);
        yearComboBox.setBounds(140, 203, 120, 30);
        yearComboBox.setEditable(true);
        yearComboBox.setSelectedItem("Year");
        yearComboBox.setEditable(false);

        monthComboBox = new JComboBox<String>(month);
        monthComboBox.setBounds(255, 203, 120, 30);
        monthComboBox.setEditable(true);
        monthComboBox.setSelectedItem("Month");
        monthComboBox.setEditable(false);

        dayComboBox = new JComboBox<String>(day);
        dayComboBox.setBounds(370, 203, 120, 30);
        dayComboBox.setEditable(true);
        dayComboBox.setSelectedItem("Day");
        dayComboBox.setEditable(false);

        // MEMBERSHIP START DAY COMBOBOX
        membershipLabel = new JLabel("<html>Membership <br>Start Date:</br> </html>");
        membershipLabel.setBounds(40, 238, 200, 30);

        memYearComboBox = new JComboBox<String>(year);
        memYearComboBox.setBounds(140, 238, 120, 30);
        memYearComboBox.setEditable(true);
        memYearComboBox.setSelectedItem("Year");
        memYearComboBox.setEditable(false);

        memMonthComboBox = new JComboBox<String>(month);
        memMonthComboBox.setBounds(255, 238, 120, 30);
        memMonthComboBox.setEditable(true);
        memMonthComboBox.setSelectedItem("Month");
        memMonthComboBox.setEditable(false);

        memDayComboBox = new JComboBox<String>(day);
        memDayComboBox.setBounds(370, 238, 120, 30);
        memDayComboBox.setEditable(true);
        memDayComboBox.setSelectedItem("Day");
        memDayComboBox.setEditable(false);

        generalPanel.add(idLabel);
        generalPanel.add(idField);
        generalPanel.add(nameLabel);
        generalPanel.add(nameField);
        generalPanel.add(locationLabel);
        generalPanel.add(locationField);
        generalPanel.add(phoneLabel);
        generalPanel.add(phoneField);
        generalPanel.add(emailLabel);
        generalPanel.add(emailField);
        generalPanel.add(genderLabel);
        generalPanel.add(maleButton);
        generalPanel.add(femaleButton);
        generalPanel.add(dobLabel);
        generalPanel.add(yearComboBox);
        generalPanel.add(monthComboBox);
        generalPanel.add(dayComboBox);
        generalPanel.add(membershipLabel);
        generalPanel.add(memYearComboBox);
        generalPanel.add(memMonthComboBox);
        generalPanel.add(memDayComboBox);

        // REGULAR PANEL LABEL
        regularHeadingPanel = new JLabel("Regular Member");
        regularHeadingPanel.setBounds(80, 2, 200, 30);
        regularHeadingPanel.setHorizontalAlignment(SwingConstants.CENTER);
        regularHeadingPanel.setVerticalAlignment(SwingConstants.CENTER);
        regularHeadingPanel.setFont(new Font("Arial", Font.BOLD, 12));

        // REFERRAL
        referralLabel = new JLabel("<html>Referral <br>Source:</br> </html>");
        referralLabel.setBounds(30, 35, 120, 28);
        referralField = new JTextField();
        referralField.setBounds(100, 33, 200, 30);

        // REMOVAL REASON
        removalReasonLabel = new JLabel("<html>Removal <br>Reason:</br> </html>");
        removalReasonLabel.setBounds(30, 69, 120, 28);
        removalReasonField = new JTextField();
        removalReasonField.setBounds(100, 67, 200, 30);

        // PLAN COMBOBOX
        planLabel = new JLabel("Plan: ");
        planLabel.setBounds(30, 98, 120, 30);
        planPriceField = new JTextField("6500.0");
        planPriceField.setBounds(220, 98, 120, 30);
        planPriceField.setEditable(false);

        String[] plan = { "Basic", "Standard", "Deluxe" };
        planComboBox = new JComboBox<String>(plan);
        planComboBox.setBounds(100, 100, 100, 30);

        planComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Item state changed: " + e.getItem());

                double price = 0.0;
                for (GymMember member : members) {
                    if (member instanceof RegularMember) {
                        System.out.println("RegularMember found");
                        RegularMember regularMember = (RegularMember) member;
                        price = regularMember.getPlanPrice(planComboBox.getSelectedItem().toString());
                        System.out.println(price);
                        break;
                    }
                }
                planPriceField.setText(String.valueOf(price));

            }
        });

        regularPanel.add(regularHeadingPanel);
        regularPanel.add(planLabel);
        regularPanel.add(planPriceField);
        regularPanel.add(planComboBox);
        regularPanel.add(referralLabel);
        regularPanel.add(referralField);
        regularPanel.add(removalReasonLabel);
        regularPanel.add(removalReasonField);

        // PREMIUM HEADING LABEL
        premiumHeadingPanel = new JLabel("Premium Member");
        premiumHeadingPanel.setBounds(80, 2, 200, 30);
        premiumHeadingPanel.setHorizontalAlignment(SwingConstants.CENTER);
        premiumHeadingPanel.setVerticalAlignment(SwingConstants.CENTER);
        premiumHeadingPanel.setFont(new Font("Arial", Font.BOLD, 12));

        // PREMIUM CHARGE
        premiumChargeLabel = new JLabel("<html>Premium <br> Charge</br></html>");
        premiumChargeLabel.setBounds(30, 32, 100, 31);
        premiumChargeField = new JTextField("50000.00");
        premiumChargeField.setBounds(100, 32, 200, 30);
        premiumChargeField.setEditable(false);

        // TRAINERNAME
        trainerNameLabel = new JLabel("Trainer: ");
        trainerNameLabel.setBounds(30, 60, 100, 30);
        trainerNameField = new JTextField();
        trainerNameField.setBounds(100, 60, 200, 30);

        // PAIDAMOUNT
        paidAmountLabel = new JLabel("<html>Paid <br>Amount:<br/><html> ");
        paidAmountLabel.setBounds(30, 90, 100, 26);
        paidAmountField = new JTextField();
        paidAmountField.setBounds(100, 88, 200, 30);

        // DISCOUNT
        discountLabel = new JLabel("Discount: ");
        discountLabel.setBounds(30, 120, 100, 28);
        discountField = new JTextField();
        discountField.setBounds(100, 118, 200, 30);
        discountField.setEditable(false);

        premiumPanel.add(premiumChargeLabel);
        premiumPanel.add(premiumChargeField);
        premiumPanel.add(premiumHeadingPanel);
        premiumPanel.add(trainerNameLabel);
        premiumPanel.add(trainerNameField);
        premiumPanel.add(paidAmountLabel);
        premiumPanel.add(paidAmountField);
        premiumPanel.add(discountLabel);
        premiumPanel.add(discountField);

        // REVERTPANELINPUT
        revertMemberIdLabel = new JLabel("Member ID: ");
        revertMemberIdLabel.setBounds(20, 35, 180, 40);

        revertMemberIdField = new JTextField();
        revertMemberIdField.setBounds(100, 35, 250, 40);

        revertFrame.add(revertMemberPanel);
        revertMemberPanel.add(revertMemberIdLabel);
        revertMemberPanel.add(revertMemberIdField);

        saveToFileFrame.add(saveToFilePanel);

        // DISPLAY AREA
        displayArea = new JTextArea();
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(displayArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        displayFrame.add(scrollPane);

        // BUTTON PANEL

        btnPanel = new JPanel(null);
        btnPanel.setBounds(10, 380, 920, 800);
        btnPanel.setVisible(true);

        // ADD REGULAR MEMBER BUTTON
        addRegButton = new JButton("Add Regular Member");
        addRegButton.setBounds(10, 40, 200, 40);
        addRegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRegularMember();
            }
        });

        // ADD PREMIUM MEMBER BUTTON
        addPremButton = new JButton("Add Premium Member");
        addPremButton.setBounds(240, 40, 200, 40);
        addPremButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPremiumMember();
            }
        });

        // MARK ATTENDANCE BUTTON
        markAttendanceButton = new JButton("Mark Attendance");
        markAttendanceButton.setBounds(470, 40, 200, 40);
        markAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkMembers()) {
                    return;
                }
                markMemberAttendance();
            }
        });

        // ACTIVATE MEMBERSHIP BUTTON
        activateMembershipButton = new JButton("Activate Membership");
        activateMembershipButton.setBounds(10, 100, 200, 40);
        activateMembershipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkMembers()) {
                    return;
                }
                activateMemberMembership();
            }
        });

        // DEACTIVATE MEMBERSHIP BUTTON
        deactivateMembershipButton = new JButton("Deactivate Membership");
        deactivateMembershipButton.setBounds(240, 100, 200, 40);
        deactivateMembershipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkMembers()) {
                    return;
                }
                deactivateMemberMembership();
            }
        });

        // REVERT MEMBER BUTTON
        revertMemberButton = new JButton("Revert Member");
        revertMemberButton.setBounds(470, 100, 200, 40);
        revertMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkMembers()) {
                    return;
                }
                revertFrame.setVisible(true);
            }
        });

        // REVERT REGULAR MEMBER
        revertRegularMemberButton = new JButton("Regular Member");
        revertRegularMemberButton.setBounds(10, 100, 180, 40);
        revertRegularMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                revertRegularMember();
            }
        });

        // REVERT PREMIUM MEMBER
        revertPremiumMemberButton = new JButton("Premium Member");
        revertPremiumMemberButton.setBounds(200, 100, 180, 40);
        revertPremiumMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkMembers()) {
                    return;
                }
                revertPremiumMember();
            }
        });

        saveToFileRegularMemberButton = new JButton("Regular Member");
        saveToFileRegularMemberButton.setBounds(10, 50, 180, 40);
        saveToFileRegularMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFileFrame.dispose();
                saveRegularMember();
            }
        });

        // REVERT PREMIUM MEMBER
        saveToFilePremiumMemberButton = new JButton("Premium Member");
        saveToFilePremiumMemberButton.setBounds(200, 50, 180, 40);
        saveToFilePremiumMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkMembers()) {
                    return;
                }
                saveToFileFrame.dispose();
                savePremiumMember();
            }
        });

        // CLEAR MEMBER BUTTON
        clearButton = new JButton("Clear");
        clearButton.setBounds(700, 40, 200, 40);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearField();
            }
        });

        // DISPLAY MEMBER BUTTON
        displayButton = new JButton("Display");
        displayButton.setBounds(350, 220, 200, 40);
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkMembers()) {
                    return;
                }
                displayMembers();
            }
        });

        // CALCULATE DISCOUNT AMOUNT
        calculateDiscountButton = new JButton("Calculate Discount");
        calculateDiscountButton.setBounds(240, 160, 200, 40);
        calculateDiscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMemberDiscount();
            }
        });

        // PAY DUE AMOUNT
        payDueAmountButton = new JButton("Pay Due Amount");
        payDueAmountButton.setBounds(10, 160, 200, 40);
        payDueAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payDueAmount();
            }
        });

        // SAVE TO FILE BUTTON
        saveToFileButton = new JButton("Save to File");
        saveToFileButton.setBounds(470, 160, 200, 40);
        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkMembers()) {
                    return;
                }
                saveToFileFrame.setVisible(true);
            }
        });

        // LOAD FROM FILE BUTTON
        LoadFromFileButton = new JButton("Read from File");
        LoadFromFileButton.setBounds(700, 160, 200, 40);
        LoadFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFromFile();
            }
        });

        // UPGRADE PLAN BUTTON
        UpgradePlanButton = new JButton("Upgrade Plan");
        UpgradePlanButton.setBounds(700, 100, 200, 40);
        UpgradePlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upgradePlan();
            }
        });

        btnPanel.add(addRegButton);
        btnPanel.add(addPremButton);
        btnPanel.add(markAttendanceButton);
        btnPanel.add(activateMembershipButton);
        btnPanel.add(deactivateMembershipButton);
        btnPanel.add(revertMemberButton);
        btnPanel.add(clearButton);
        btnPanel.add(displayButton);
        btnPanel.add(payDueAmountButton);
        btnPanel.add(calculateDiscountButton);
        btnPanel.add(saveToFileButton);
        btnPanel.add(LoadFromFileButton);
        btnPanel.add(UpgradePlanButton);

        revertMemberPanel.add(revertRegularMemberButton);
        revertMemberPanel.add(revertPremiumMemberButton);

        saveToFilePanel.add(saveToFileRegularMemberButton);
        saveToFilePanel.add(saveToFilePremiumMemberButton);

        frame.add(welcomeLabel);
        frame.add(btnPanel);
        frame.add(generalPanel);
        frame.add(regularPanel);
        frame.add(premiumPanel);
        frame.setVisible(true);
    }

    /**
     * Checks if there are any members in the system
     * 
     * @return true if members exist, false otherwise
     */
    public boolean checkMembers() {
        if (members.isEmpty()) {
            JOptionPane.showMessageDialog(revertFrame, "No members have been added yet.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Adds a new regular member to the system
     * Validates all required fields and checks for duplicate member IDs
     * Creates a new RegularMember instance with the provided information
     */
    public void addRegularMember() {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter all fields", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idField.getText());

            for (GymMember member : members) {
                if (member.getId() == id) {
                    JOptionPane.showMessageDialog(frame, "Member ID already exists", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender;
            if (maleButton.isSelected()) {
                gender = "Male";
            } else if (femaleButton.isSelected()) {
                gender = "Female";
            } else {
                gender = null;
            }
            String dob = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-"
                    + dayComboBox.getSelectedItem();
            String msd = memYearComboBox.getSelectedItem() + "-" + memMonthComboBox.getSelectedItem() + "-"
                    + memDayComboBox.getSelectedItem();
            String referral = referralField.getText();

            if (idField.getText().isEmpty() ||
                    nameField.getText().isEmpty() ||
                    locationField.getText().isEmpty() ||
                    phoneField.getText().isEmpty() || phoneField.getText().length() > 10 ||
                    emailField.getText().isEmpty() ||
                    gender == null ||
                    yearComboBox.getSelectedItem() == "Year" ||
                    monthComboBox.getSelectedItem() == "Month" ||
                    dayComboBox.getSelectedItem() == "Day" ||
                    memYearComboBox.getSelectedItem() == "Year" ||
                    memMonthComboBox.getSelectedItem() == "Month" ||
                    memDayComboBox.getSelectedItem() == "Day" ||
                    referralField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter all fields", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            members.add(new RegularMember(id, name, location, phone, email, gender, dob, msd, referral));

            JOptionPane.showMessageDialog(null, "Regular Member successfully added", "Information",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(frame, "Please enter valid Id:", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        clearField();
    }

    /**
     * Adds a new premium member to the system
     * Validates all required fields and checks for duplicate member IDs
     * Creates a new PremiumMember instance with the provided information
     */
    public void addPremiumMember() {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter all fields", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idField.getText());

            for (GymMember member : members) {
                if (member.getId() == id) {
                    JOptionPane.showMessageDialog(frame, "Member ID already exists", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender;
            if (maleButton.isSelected()) {
                gender = "Male";
            } else if (femaleButton.isSelected()) {
                gender = "Female";
            } else {
                gender = null;
            }
            String dob = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-"
                    + dayComboBox.getSelectedItem();
            String msd = memYearComboBox.getSelectedItem() + "-" + memMonthComboBox.getSelectedItem() + "-"
                    + memDayComboBox.getSelectedItem();
            String trainer = trainerNameField.getText();

            if (idField.getText().isEmpty() || nameField.getText().isEmpty() ||
                    locationField.getText().isEmpty() ||
                    phoneField.getText().isEmpty() || phoneField.getText().length() > 10 ||
                    emailField.getText().isEmpty() ||
                    yearComboBox.getSelectedItem() == "Year" ||
                    monthComboBox.getSelectedItem() == "Month" ||
                    dayComboBox.getSelectedItem() == "Day" ||
                    memYearComboBox.getSelectedItem() == "Year" ||
                    memMonthComboBox.getSelectedItem() == "Month" ||
                    memDayComboBox.getSelectedItem() == "Day" ||
                    trainerNameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter all fields");
                return;
            }

            members.add(new PremiumMember(id, name, location, phone, email, gender, dob, msd, trainer));

            JOptionPane.showMessageDialog(null, "Premium Member successfully added");

        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(frame, "Please enter valid Id:", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        clearField();
    }

    /**
     * Activates the membership for a specified member
     * Prompts for member ID and activates their membership if found
     * Shows appropriate messages for success/failure
     */
    public void activateMemberMembership() {
        String input = JOptionPane.showInputDialog(frame, "Enter Member ID: ");
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Member ID not entered.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(frame, "Invalid Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Boolean memberFound = false;

        for (GymMember member : members) {
            if (member.getId() == id) {
                memberFound = true;
                if (member.isActiveStatus()) {
                    JOptionPane.showMessageDialog(frame, "Membership already Activated for" + member.getName());
                } else {
                    member.activateMembership();
                    JOptionPane.showMessageDialog(frame, "Membership for " + member.getName() + " has been activated.");
                }
                break;
            }
        }
        if (!memberFound) {
            JOptionPane.showMessageDialog(frame, "Member " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(id);
        }
    }

    /**
     * Deactivates the membership for a specified member
     * Prompts for member ID and deactivates their membership if found
     * Shows appropriate messages for success/failure
     */
    public void deactivateMemberMembership() {
        String input = JOptionPane.showInputDialog(frame, "Enter Member ID: ");
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Member ID not entered.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(frame, "Invalid Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Boolean memberFound = false;

        for (GymMember member : members) {
            if (member.getId() == id) {
                memberFound = true;
                if (!member.isActiveStatus()) {
                    JOptionPane.showMessageDialog(frame, "Membership is already Deactivated for " + member.getName());
                } else {
                    member.deactivateMembership();
                    JOptionPane.showMessageDialog(frame,
                            "Membership for " + member.getName() + " has been deactivated.");
                }
                break;
            }
        }
        if (!memberFound) {
            JOptionPane.showMessageDialog(frame, "Member " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Marks attendance for a specified member
     * Prompts for member ID and marks their attendance if found and active
     * Shows appropriate messages for success/failure
     */
    public void markMemberAttendance() {
        String input = JOptionPane.showInputDialog(frame, "Enter Member ID:");

        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No member ID entered.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(input.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean memberFound = false;

        for (GymMember member : members) {
            if (member.getId() == id) {
                memberFound = true;
                if (member.activeStatus) {
                    member.markAttendance();
                    JOptionPane.showMessageDialog(frame,
                            "Attendance for " + member.getName() + " has been registered.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Member is not active.", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
                break;
            }
        }

        if (!memberFound) {
            JOptionPane.showMessageDialog(frame, "Member " + id + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Reverts a regular member's status
     * Prompts for member ID and removal reason
     * Resets the member's data if found
     * Shows appropriate messages for success/failure
     */
    public void revertRegularMember() {

        String input = revertMemberIdField.getText();
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(revertFrame, "Member ID was not entered.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(revertFrame, "Invalid Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean memberFound = false;

        for (GymMember member : members) {
            if (member.getId() == id) {
                memberFound = true;

                if (member instanceof RegularMember) {
                    String removalReason = JOptionPane.showInputDialog(revertFrame, "Enter the removal reason");
                    if (removalReason == null || removalReason.trim().isEmpty()) {
                        return;
                    }
                    ((RegularMember) member).revertRegularMethod(removalReason);
                    System.out.println("Removal Reason: " + removalReason);
                    JOptionPane.showMessageDialog(revertFrame,
                            "Member " + member.getId() + " has been successfully reverted.");
                    revertFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(revertFrame, "Selected member is not a regular member.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                return;
            }

        }
        if (!memberFound) {
            JOptionPane.showMessageDialog(revertFrame, "Member with ID " + id + " not found.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Reverts a premium member's status
     * Prompts for member ID
     * Resets the member's data if found
     * Shows appropriate messages for success/failure
     */
    public void revertPremiumMember() {
        String input = revertMemberIdField.getText();
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(revertFrame, "Member ID was not entered.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(revertFrame, "Invaiid Member ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean memberFound = false;

        for (GymMember member : members) {
            if (member.getId() == id) {
                memberFound = true;
                if (member instanceof PremiumMember) {
                    ((PremiumMember) member).revertPremiumMethod();
                    JOptionPane.showMessageDialog(revertFrame,
                            "Member" + member.getId() + "has been successfully reverted.");
                    revertFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(revertFrame, "Selected member is not a Premium Member.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
        }
        if (!memberFound) {
            JOptionPane.showMessageDialog(revertFrame, "Member with ID " + id + " not found", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        discountField.setText("");
    }

    public void upgradePlan() {
        String input = idField.getText();
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Member ID was not entered.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(frame, "Invalid Member ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean memberFound = false;
        for (GymMember member : members) {
            if (member.getId() == id) {
                memberFound = true;
                if (member instanceof RegularMember) {
                    String newPlan = (String) planComboBox.getSelectedItem();
                    String result = ((RegularMember) member).upgradePlan(newPlan);
                    JOptionPane.showMessageDialog(frame, result);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selected member is not a Regular Member.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
        }
        if (!memberFound) {
            JOptionPane.showMessageDialog(frame, "Member with ID " + id + " not found", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Displays all members in the system
     * Shows detailed information for both regular and premium members
     * Opens a new window with the member information
     */
    public void displayMembers() {
        displayFrame.setVisible(true);
        StringBuilder memberList = new StringBuilder();
        for (GymMember member : members) {
            if (member instanceof RegularMember) {
                RegularMember regularMember = (RegularMember) member;
                memberList.append("Id: ").append(regularMember.getId())
                        .append("\nName: ").append(regularMember.getName())
                        .append("\nLocation: ").append(regularMember.getLocation())
                        .append("\nPhone: ").append(regularMember.getPhone())
                        .append("\nEmail: ").append(regularMember.getEmail())
                        .append("\nGender: ").append(regularMember.getGender())
                        .append("\nDate of birth: ").append(regularMember.getDOB())
                        .append("\nMembership Start Date: ").append(regularMember.getMembershipStartDate())
                        .append("\nPlan: ").append(regularMember.getPlan())
                        .append("\nReferral Source: ").append(regularMember.getReferralSource())
                        .append("\nActive Status: ").append(regularMember.isActiveStatus())
                        .append("\nAttendance: ").append(regularMember.getAttendance())
                        .append("\nLoyalty points: ").append(regularMember.getLoyaltyPoints())
                        .append("\nRemoval Reason: ").append(regularMember.getRemovalReason())
                        .append("\n--------------------------------------------\n");

                member.display();
                System.out.println("\n");

            } else if (member instanceof PremiumMember) {
                PremiumMember premiumMember = (PremiumMember) member;
                memberList.append("Id: ").append(premiumMember.getId())
                        .append("\nName: ").append(premiumMember.getName())
                        .append("\nLocation: ").append(premiumMember.getLocation())
                        .append("\nPhone: ").append(premiumMember.getPhone())
                        .append("\nEmail: ").append(premiumMember.getEmail())
                        .append("\nGender: ").append(premiumMember.getGender())
                        .append("\nDate of birth: ").append(premiumMember.getDOB())
                        .append("\nMembership Start Date: ").append(premiumMember.getMembershipStartDate())
                        .append("\nPersonal Trainer: ").append(premiumMember.getPersonalTrainer())
                        .append("\nActive Status: ").append(premiumMember.isActiveStatus())
                        .append("\nAttendance: ").append(premiumMember.getAttendance())
                        .append("\nLoyalty points: ").append(premiumMember.getLoyaltyPoints())
                        .append("\nPayment Status: ").append(premiumMember.isFullPayment())
                        .append("\n--------------------------------------------\n");

                member.display();
                System.out.println("\n");
            }

        }
        displayArea.setText(memberList.toString());
    }

    /**
     * Clears all input fields in the GUI
     * Resets text fields, combo boxes, and radio buttons to their default state
     */
    public void clearField() {
        idField.setText("no");
        nameField.setText("");
        locationField.setText("");
        phoneField.setText("");
        emailField.setText("");
        genderButtonGroup.clearSelection();
        yearComboBox.setEditable(true);
        yearComboBox.setSelectedItem("Year");
        yearComboBox.setEditable(false);
        monthComboBox.setEditable(true);
        monthComboBox.setSelectedItem("Month");
        monthComboBox.setEditable(false);
        dayComboBox.setEditable(true);
        dayComboBox.setSelectedItem("Day");
        dayComboBox.setEditable(false);
        memYearComboBox.setEditable(true);
        memYearComboBox.setSelectedItem("Year");
        memYearComboBox.setEditable(false);
        memMonthComboBox.setEditable(true);
        memMonthComboBox.setSelectedItem("Month");
        memMonthComboBox.setEditable(false);
        memDayComboBox.setEditable(true);
        memDayComboBox.setSelectedItem("Day");
        memDayComboBox.setEditable(false);

        referralField.setText("");
        removalReasonField.setText("");
        planComboBox.setSelectedIndex(0);
        planPriceField.setText("6500.0");

        trainerNameField.setText("");
        paidAmountField.setText("");
        discountField.setText("");
    }

    /**
     * Calculates discount for a premium member
     * Checks if the member has paid the full amount
     * Shows the discount amount or remaining payment amount
     */
    public void calculateMemberDiscount() {
        String input = idField.getText();
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(revertFrame, "Member ID was not entered.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (members.isEmpty()) {
            JOptionPane.showMessageDialog(revertFrame, "No members have been added yet.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(revertFrame, "Invalid Member ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean memberFound = false;

        for (GymMember member : members) {
            if (member.getId() == id) {
                memberFound = true;
                if (member instanceof PremiumMember) {
                    PremiumMember premiumMember = (PremiumMember) member;
                    if (premiumMember.isFullPayment()) {
                        premiumMember.calculateDiscount();
                        JOptionPane.showMessageDialog(revertFrame,
                                "Discount calculated successfully.\nDiscounted Amount: "
                                        + premiumMember.getDiscountAmount());
                        discountField.setText(String.valueOf(premiumMember.getDiscountAmount()));
                    } else {
                        double remainingAmount = premiumMember.getPremiumCharge() - premiumMember.getPaidAmount();
                        JOptionPane.showMessageDialog(revertFrame,
                                "Cannot calculate discount. Total amount not paid: " + remainingAmount,
                                "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(revertFrame, "Selected member is not a Premium Member.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
        }
        if (!memberFound) {
            JOptionPane.showMessageDialog(revertFrame, "Member with ID " + id + " not found", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Processes payment for a premium member
     * Validates the payment amount
     * Updates the member's payment status
     * Shows remaining amount or success message
     */
    public void payDueAmount() {
        String input = idField.getText();
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Member ID was not entered.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (members.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No members have been added yet.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(input);
            if (id < 0) {
            }
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(frame, "Invalid Member ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean memberFound = false;
        for (GymMember member : members) {
            if (member.getId() == id) {
                memberFound = true;
                if (member instanceof PremiumMember) {
                    PremiumMember premiumMember = (PremiumMember) member;
                    if (!premiumMember.isActiveStatus()) {
                        JOptionPane.showMessageDialog(frame, "Member is not active.", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String amountStr = paidAmountField.getText();
                    if (amountStr == null || amountStr.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please enter the amount to pay", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    try {
                        double amount = Double.parseDouble(amountStr);
                        if (amount < 0) {
                            JOptionPane.showMessageDialog(frame, "Amount cannot be negative", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        String result = premiumMember.payDueAmount(amount);
                        JOptionPane.showMessageDialog(frame, result);
                        paidAmountField.setText("");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(frame, "Invalid amount entered", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Selected member is not a Premium Member.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
        }
        if (!memberFound) {
            JOptionPane.showMessageDialog(frame, "Member with ID " + id + " not found", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Loads member data from a file
     * Reads the saved text file and reconstructs member objects
     * Restores both regular and premium members with their attributes
     */
    public void loadFromFile() {
        try {
            File file = new File("gymmembers.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No members have been saved yet.");
                return;
            }

            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }

            if (content.length() == 0) {
                JOptionPane.showMessageDialog(frame, "No member data found in the file.");
                return;
            }

            // Create dialog
            JDialog dialog = new JDialog(frame, "Member Information", true);
            dialog.setSize(1000, 600);
            dialog.setLocationRelativeTo(frame);

            // Main panel with BorderLayout
            JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            mainPanel.setBackground(Color.WHITE);

            // Title label
            JLabel titleLabel = new JLabel("Gym Member Database", SwingConstants.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            titleLabel.setForeground(Color.BLACK); // Changed from blue to black
            mainPanel.add(titleLabel, BorderLayout.NORTH);

            // Text area in scroll pane
            JTextArea textArea = new JTextArea(content.toString());
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
            textArea.setEditable(false);
            textArea.setBackground(new Color(245, 245, 245));
            JScrollPane scrollPane = new JScrollPane(textArea);
            mainPanel.add(scrollPane, BorderLayout.CENTER);

            // Button panel at bottom
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.WHITE);
            JButton closeButton = new JButton("Close");
            closeButton.setFont(new Font("Arial", Font.BOLD, 14));
            closeButton.setBackground(new Color(70, 130, 180));
            closeButton.setForeground(Color.WHITE);

            // Replace lambda with anonymous inner class
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });

            buttonPanel.add(closeButton);
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);

            dialog.add(mainPanel);
            dialog.setVisible(true);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error reading member information.");
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void saveRegularMember() {
        try {
            FileWriter writer = new FileWriter("gymmembers.txt", true);

            final int TOTAL_WIDTH = 150;

            // Write header if file is empty
            if (new File("members.txt").length() == 0) {
                writer.write("=".repeat(TOTAL_WIDTH + 8) + "\n");
                writer.write(String.format(
                        "| %-5s | %-20s | %-15s | %-12s | %-25s | %-8s | %-20s | %-15s | %-10s |\n",
                        "ID", "Name", "Location", "Phone", "Email", "Gender", "DOB", "Start Date", "Type"));
                writer.write("=".repeat(TOTAL_WIDTH + 8) + "\n");
            }

            // Get member information
            String idText = idField.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enter a member id to continue.");
                return;
            }
            int id = Integer.parseInt(idText);
            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender = maleButton.isSelected() ? "Male" : "Female";

            // Format dates properly
            String dob = String.format("%s-%02d-%02d",
                    yearComboBox.getSelectedItem(),
                    monthComboBox.getSelectedIndex() + 1,
                    Integer.parseInt(dayComboBox.getSelectedItem().toString()));

            String membershipStartDate = String.format("%s-%02d-%02d",
                    memYearComboBox.getSelectedItem(),
                    memMonthComboBox.getSelectedIndex() + 1,
                    Integer.parseInt(memDayComboBox.getSelectedItem().toString()));

            String type = "Regular";

            // Write member data with proper formatting
            writer.write(String.format(
                    "| %-5d | %-20s | %-15s | %-12s | %-25s | %-8s | %-20s | %-15s | %-10s |\n",
                    id,
                    name.length() > 20 ? name.substring(0, 17) + "..." : name,
                    location.length() > 15 ? location.substring(0, 12) + "..." : location,
                    phone,
                    email.length() > 25 ? email.substring(0, 22) + "..." : email,
                    gender,
                    dob,
                    membershipStartDate,
                    type));

            // Add separator line
            writer.write("-".repeat(TOTAL_WIDTH) + "\n");

            writer.close();
            JOptionPane.showMessageDialog(frame, "Member information saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error saving member information.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format. Please enter a valid number.");
        }
    }

    public void savePremiumMember() {
        addPremiumMember();
        try {
            FileWriter writer = new FileWriter("gymmembers.txt", true);

            if (new File("members.txt").length() == 0) {
                writer.write("=".repeat(120) + "\n");
                writer.write(String.format(
                        "| %-4s | %-15s | %-12s | %-10s | %-20s | %-6s | %-10s | %-12s | %-8s |\n",
                        "ID", "Name", "Location", "Phone", "Email", "Gender", "DOB", "Start Date", "Type"));
                writer.write("=".repeat(120) + "\n");
            }

            String idText = idField.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enter a member id to continue.");
                return;
            }
            int id = Integer.parseInt(idText);
            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender = maleButton.isSelected() ? "Male" : "Female";
            String dob = yearComboBox.getSelectedItem() + "-" +
                    monthComboBox.getSelectedItem() + "-" +
                    dayComboBox.getSelectedItem();
            String membershipStartDate = memYearComboBox.getSelectedItem() + "-" +
                    memMonthComboBox.getSelectedItem() + "-" +
                    memDayComboBox.getSelectedItem();
            String type = "Premium";

            writer.write(
                    String.format("| %-4d | %-15s | %-12s | %-10s | %-20s | %-6s | %-10s | %-12s | %-8s |\n",
                            id, name, location, phone, email, gender, dob, membershipStartDate, type));
            writer.write("-".repeat(120) + "\n");

            writer.close();
            JOptionPane.showMessageDialog(frame, "Member information saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error saving member information.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid ID format. Please enter a valid number.");
        }
        addRegularMember();
    }
}
