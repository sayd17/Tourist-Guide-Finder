package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgetPassword extends JFrame implements ActionListener{
    JButton sendButton, backButton;
    JTextField emailPhoneArea;
    JTextField usernameArea;
    JPasswordField passwordField;
    ForgetPassword(){
        setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZED_BOTH it will adjust Panel with Screen
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/hotel10.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel totalLabel = new JLabel(i3);
        totalLabel.setBounds(0, 0, 1920, 1080);
        add(totalLabel);

        JLabel headingLabel = new JLabel("              Admin Login Page");
        headingLabel.setBounds(300, 180, 1100, 80);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 65));
        totalLabel.add(headingLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(440, 280, 140, 40);
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(usernameLabel);

        usernameArea = new JTextField();
        usernameArea.setBounds(620, 285, 500, 30);
        usernameArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        usernameArea.setBackground(Color.WHITE);
        usernameArea.setForeground(new Color(255, 128, 0));
        usernameArea.setBorder(BorderFactory.createEmptyBorder());
        totalLabel.add(usernameArea);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(440, 340, 140, 40);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(620, 350, 500, 30);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(new Color(255, 128, 0));
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        add(passwordField);

        sendButton = new JButton("Send");
        sendButton.setBackground(Color.WHITE);
        sendButton.setForeground(new Color(255, 128, 0));
        sendButton.setBounds(620, 400, 180, 40);
        sendButton.setBorder(BorderFactory.createEmptyBorder());
        sendButton.addActionListener(this);
        totalLabel.add(sendButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(new Color(255, 128, 0));
        backButton.setBounds(940, 400, 180, 40);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.addActionListener(this);
        totalLabel.add(backButton);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == sendButton){
            //new SignIn().setVisible(true);
            //this.setVisible(false);
            try {
                ConnectDB c = new ConnectDB();
                //c.s.executeUpdate(data);
                //JOptionPane.showMessageDialog(null, "Already sent a code on your address.");
                //this.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace(); // To check exception
            }
        }
        else  if(ae.getSource() == backButton){
            new SignIn().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new ForgetPassword().setVisible(true);
    }
}
