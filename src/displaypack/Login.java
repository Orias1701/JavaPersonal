package displaypack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JCheckBox showPass;
    private final JButton loginButton, exitButton;
    private final String predefinedUsername = "admin";
    private final String predefinedPassword = "12345";

    public Login() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 500);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("LOGIN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel usernameLabel = new JLabel("Account: ");
        JLabel passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        showPass = new JCheckBox("Show password");
        loginButton = new JButton("Login");
        exitButton = new JButton("Cancel");

        showPass.addActionListener(this);
        loginButton.addActionListener(this);
        exitButton.addActionListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        // gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridy++;
        add(usernameLabel, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(usernameField, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_START;
        // gbc.anchor = GridBagConstraints.LINE_END;
        add(passwordLabel, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(loginButton, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(exitButton, gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(showPass, gbc);

        Font font_title = new Font("Arial", Font.BOLD, 30);
        titleLabel.setFont(font_title);

        Font font = new Font("Arial", Font.PLAIN, 20);
        usernameLabel.setFont(font);
        passwordLabel.setFont(font);
        usernameField.setFont(font);
        passwordField.setFont(font);

        Font font_end = new Font("Arial", Font.PLAIN, 15);
        showPass.setFont(font_end);
        loginButton.setFont(font_end);
        exitButton.setFont(font_end);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showPass) {
            if (showPass.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        } else if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals(predefinedUsername) && password.equals(predefinedPassword)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
    }
}