import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATMGUI extends JFrame implements ActionListener {

    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton, withdrawButton, depositButton, transferButton, historyButton, quitButton;
    private JTextArea textArea;

    // Constructor
    public ATMGUI() {
        super("ATM Machine");
        setSize(500, 500);                                                     
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Login Screen
        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(100, 100, 80, 30);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(200, 100, 150, 30);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(100, 150, 80, 30);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(200, 150, 150, 30);
        add(passField);

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 200, 80, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        // Main Menu
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 300, 100, 30);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(200, 300, 100, 30);
        depositButton.addActionListener(this);
        add(depositButton);

        transferButton = new JButton("Transfer");
        transferButton.setBounds(350, 300, 100, 30);
        transferButton.addActionListener(this);
        add(transferButton);

        historyButton = new JButton("Transaction History");
        historyButton.setBounds(150, 350, 200, 30);
        historyButton.addActionListener(this);
        add(historyButton);

        quitButton = new JButton("Quit");
        quitButton.setBounds(200, 400, 100, 30);
        quitButton.addActionListener(this);
        add(quitButton);

        // Text Area
        textArea = new JTextArea();
        textArea.setBounds(50, 50, 400, 200);
        add(textArea);

        setVisible(true);
    }

    // Action Listener
    public void actionPerformed(ActionEvent e) {

        // Login Button
        if (e.getSource() == loginButton) {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            // Check if user ID and password match
            if (user.equals("123") && pass.equals("password")) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                userField.setEditable(false);
                passField.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid user ID or password.");
            }
        }

        // Withdraw Button
        if (e.getSource() == withdrawButton) {
            String amountString = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            double amount = Double.parseDouble(amountString);

            // Check if balance is sufficient
            if (amount > 0 && amount <= 1000) {
                JOptionPane.showMessageDialog(this, "Successfully withdrew $" + amount);
                textArea.append("\nWithdraw: $" + amount);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid amount or insufficient funds.");
            }
        }

        // Deposit Button
               if (e.getSource() == depositButton) {
            String amountString = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            double amount = Double.parseDouble(amountString);

            // Check if amount is valid
            if (amount > 0 && amount <= 1000) {
                JOptionPane.showMessageDialog(this, "Successfully deposited $" + amount);
                textArea.append("\nDeposit: $" + amount);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid amount.");
            }
        }

        // Transfer Button
        if (e.getSource() == transferButton) {
            String amountString = JOptionPane.showInputDialog(this, "Enter amount to transfer:");
            double amount = Double.parseDouble(amountString);
            String accountString = JOptionPane.showInputDialog(this, "Enter account number to transfer to:");
            int account = Integer.parseInt(accountString);

            // Check if balance is sufficient
            if (amount > 0 && amount <= 1000) {
                JOptionPane.showMessageDialog(this, "Successfully transferred $" + amount + " to account " + account);
                textArea.append("\nTransfer: $" + amount + " to account " + account);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid amount or insufficient funds.");
            }
        }

        // Transaction History Button
        if (e.getSource() == historyButton) {
            JOptionPane.showMessageDialog(this, "Transaction History:\n" + textArea.getText());
        }

        // Quit Button
        if (e.getSource() == quitButton) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?");
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        new ATMGUI();
    }
}

