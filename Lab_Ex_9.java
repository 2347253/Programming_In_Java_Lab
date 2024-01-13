import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab_Ex_9 extends JFrame {

    private JTextField playerNameField;
    private JTextField ageField;
    private JTextField favGameField;

    public Lab_Ex_9() {
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Esports Team Management");
        setSize(300 , 300);

        JPanel mainPanel = new JPanel(null);

        JButton registerButton = new JButton("Register New User");
        JButton exitButton = new JButton("Exit");

        registerButton.setBounds(50, 50, 200, 30);
        exitButton.setBounds(50, 100, 200, 30);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistrationPage();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainPanel.add(registerButton);
        mainPanel.add(exitButton);

        add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showRegistrationPage() {
        getContentPane().removeAll();

        JPanel registrationPanel = new JPanel(null);
        


        JLabel nameLabel = new JLabel("Player Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel favGameLabel = new JLabel("Favorite Game:");

        playerNameField = new JTextField();
        ageField = new JTextField();
        favGameField = new JTextField();

        JButton submitButton = new JButton("Register Player");

        nameLabel.setBounds(50, 50, 100, 30);
        playerNameField.setBounds(150, 50, 200, 30);

        ageLabel.setBounds(50, 100, 100, 30);
        ageField.setBounds(150, 100, 200, 30);

        favGameLabel.setBounds(50, 150, 100, 30);
        favGameField.setBounds(150, 150, 200, 30);

        submitButton.setBounds(150, 200, 150, 30);

        registrationPanel.add(nameLabel);
        registrationPanel.add(playerNameField);
        registrationPanel.add(ageLabel);
        registrationPanel.add(ageField);
        registrationPanel.add(favGameLabel);
        registrationPanel.add(favGameField);
        registrationPanel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPlayer();
            }
        });

        add(registrationPanel);

        pack();
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void registerPlayer() {
        String playerName = playerNameField.getText().trim();
        String ageStr = ageField.getText().trim();
        String favGame = favGameField.getText().trim();

        try {
            int age = Integer.parseInt(ageStr);
            JOptionPane.showMessageDialog(this,
                    "Registered Player: " + playerName,
                    "Registration Success",
                    JOptionPane.INFORMATION_MESSAGE);
            initializeUI();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid age.",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Lab_Ex_9();
    }
}
