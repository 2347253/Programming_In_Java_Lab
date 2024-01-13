import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lab_Ex_10 extends JFrame {

    private JTextField playerNameField;
    private JTextField ageField;
    private JTextField favGameField;
    private JTextField deleteIdField; // new field for entering ID for deletion

    public Lab_Ex_10() {
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Esports Team Management");
        setSize(500, 300);

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
        deleteIdField = new JTextField();

        JButton submitButton = new JButton("Register Player");
        JButton deleteButton = new JButton("Delete(ID :)");

        nameLabel.setBounds(50, 50, 100, 30);
        playerNameField.setBounds(150, 50, 200, 30);

        ageLabel.setBounds(50, 100, 100, 30);
        ageField.setBounds(150, 100, 200, 30);

        favGameLabel.setBounds(50, 150, 100, 30);
        favGameField.setBounds(150, 150, 200, 30);

        deleteIdField.setBounds(410, 200, 50, 33);
        submitButton.setBounds(50, 200, 150, 30);
        deleteButton.setBounds(300, 200, 100, 30);

        registrationPanel.add(nameLabel);
        registrationPanel.add(playerNameField);
        registrationPanel.add(ageLabel);
        registrationPanel.add(ageField);
        registrationPanel.add(favGameLabel);
        registrationPanel.add(favGameField);
        registrationPanel.add(submitButton);
        registrationPanel.add(deleteIdField);
        registrationPanel.add(deleteButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPlayer();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePlayer();
            }
        });

        add(registrationPanel);

        pack();
        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    private void registerPlayer() {
        String playerName = playerNameField.getText().trim();
        String ageStr = ageField.getText().trim();
        String favGame = favGameField.getText().trim();

        try {
            int age = Integer.parseInt(ageStr);

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/new",
                    "root",
                    "root"
            );

            String query = "INSERT INTO players (player_name, age, fav_game) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, playerName);
                preparedStatement.setInt(2, age);
                preparedStatement.setString(3, favGame);
                preparedStatement.executeUpdate();

        
            }

            JOptionPane.showMessageDialog(this,
                    "Registered Player: " + playerName,
                    "Registration Success",
                    JOptionPane.INFORMATION_MESSAGE);

            initializeUI();
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error in registration. Please check your input.",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deletePlayer() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/new",
                    "root",
                    "root"
            );

            String deleteIdStr = deleteIdField.getText().trim();
            int deleteId = Integer.parseInt(deleteIdStr);

            String query = "DELETE FROM players WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, deleteId);
                preparedStatement.executeUpdate();
            }

            JOptionPane.showMessageDialog(this,
                    "Player Deleted",
                    "Deletion Success",
                    JOptionPane.INFORMATION_MESSAGE);

            initializeUI();
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error in deletion. Please try again.",
                    "Deletion Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new Lab_Ex_10());
    }
}
