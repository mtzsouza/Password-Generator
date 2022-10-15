import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class mainFrame extends JFrame {
    // UI Elements
    JPanel panel = new JPanel();
    JLabel text1 = new JLabel("PASSWORD GENERATOR");
    JLabel text2 = new JLabel("Include:");
    JCheckBox numbersCheckBox = new JCheckBox("Numbers");
    JCheckBox lowerCaseCheckBox = new JCheckBox("Lower-case letters");
    JCheckBox upperCaseCheckBox = new JCheckBox("Upper-case letters");
    JCheckBox symbolsCheckBox = new JCheckBox("Symbols");
    JLabel text3 = new JLabel("Length:");
    String[] options = {"6","7","8","9","10","11","12","13","14","15","16","17","18"};
    JComboBox lengthComboBox = new JComboBox(options);
    JTextField passwordText = new JTextField();
    JButton createPasswordButton = new JButton("CREATE PASSWORD");

    public mainFrame() {
        // Setting up the frame
        setTitle("Password Generator");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Configuring UI Elements
        add(panel);
        panel.setLayout(null);
        setContentPane(panel);

        add(text1);
        text1.setFont(new Font("Cascadia Code", Font.BOLD,16));
        text1.setBounds(200,20,500,20);

        add(text2);
        text2.setFont(new Font("Cascadia Code", Font.BOLD,14));
        text2.setBounds(20,50,500,20);

        add(numbersCheckBox);
        numbersCheckBox.setFont(new Font("Cascadia Code", Font.BOLD, 14));
        numbersCheckBox.setBounds(25,80,500,20);
        numbersCheckBox.setFocusable(false);
        numbersCheckBox.addActionListener(
                e -> toggleButton()
        );

        add(lowerCaseCheckBox);
        lowerCaseCheckBox.setFont(new Font("Cascadia Code", Font.BOLD, 14));
        lowerCaseCheckBox.setBounds(25,100,500,20);
        lowerCaseCheckBox.setFocusable(false);
        lowerCaseCheckBox.addActionListener(
                e -> toggleButton()
        );

        add(upperCaseCheckBox);
        upperCaseCheckBox.setFont(new Font("Cascadia Code", Font.BOLD, 14));
        upperCaseCheckBox.setBounds(25,120,500,20);
        upperCaseCheckBox.setFocusable(false);
        upperCaseCheckBox.addActionListener(
                e -> toggleButton()
        );

        add(symbolsCheckBox);
        symbolsCheckBox.setFont(new Font("Cascadia Code", Font.BOLD, 14));
        symbolsCheckBox.setBounds(25,140,500,20);
        symbolsCheckBox.setFocusable(false);
        symbolsCheckBox.addActionListener(
                e -> toggleButton()
        );

        add(text3);
        text3.setFont(new Font("Cascadia Code", Font.BOLD,14));
        text3.setBounds(20,175,500,20);

        add(lengthComboBox);
        lengthComboBox.setFont(new Font("Cascadia Code", Font.BOLD,14));
        lengthComboBox.setBounds(30,205,50,20);
        lengthComboBox.setFocusable(false);

        add(passwordText);
        passwordText.setFont(new Font("Cascadia Code", Font.BOLD,16));
        passwordText.setBounds(195,255,200,25);
        passwordText.setEditable(false);
        passwordText.setVisible(false);
        passwordText.setHorizontalAlignment(passwordText.CENTER);
        passwordText.setBorder(null);

        add(createPasswordButton);
        createPasswordButton.setFont(new Font("Cascadia Code", Font.BOLD,16));
        createPasswordButton.setBounds(195,295,200,25);
        createPasswordButton.setEnabled(false);
        createPasswordButton.setFocusable(false);
        createPasswordButton.addActionListener(
                e -> createPassword()
        );
    }

    // Method to enable 'Create Password' button when at least one checkbox is selected
    public void toggleButton () {
        createPasswordButton.setEnabled(numbersCheckBox.isSelected() || lowerCaseCheckBox.isSelected() ||
        upperCaseCheckBox.isSelected() || symbolsCheckBox.isSelected());
    }

    // Method to create and display the password
    public void createPassword() {

        // Object to randomize characters
        Random random = new Random();

        // Defining the numbers, alphabet, and symbols
        char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
        char[] lowerCase = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','v','x','y','z'};
        char[] upperCase = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','V','X','Y','Z'};
        char[] symbols = {'!','@','#','$','%','^','&','*','(',')'};

        // Creating the password
        int passwordLength = lengthComboBox.getSelectedIndex() + 6;
        char[] passwordArray = new char[passwordLength];

        for (int i = 0; i < passwordLength; i++) {
            int randomType = random.nextInt(4);
            switch (randomType) {
                case 0:
                    if (numbersCheckBox.isSelected()) {
                        int randomNumber = random.nextInt(numbers.length);
                        passwordArray[i] = numbers[randomNumber];
                    }
                    else {
                        i--;
                    }
                    break;
                case 1:
                    if (lowerCaseCheckBox.isSelected()) {
                        int randomLowerCase = random.nextInt(lowerCase.length);
                        passwordArray[i] = lowerCase[randomLowerCase];
                    }
                    else {
                        i--;
                    }
                    break;
                case 2:
                    if (upperCaseCheckBox.isSelected()) {
                        int randomUpperCase = random.nextInt(upperCase.length);
                        passwordArray[i] = upperCase[randomUpperCase];
                    }
                    else {
                        i--;
                    }
                    break;
                case 3:
                    if (symbolsCheckBox.isSelected()) {
                        int randomSymbol = random.nextInt(symbols.length);
                        passwordArray[i] = symbols[randomSymbol];
                    }
                    else {
                        i--;
                    }
                    break;
            }
        }

        // Displaying the password
        String password = new String(passwordArray); // Transforming the password from an array of chars to a String
        passwordText.setText(password);
        passwordText.setVisible(true);
    }
}
