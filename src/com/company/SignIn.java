package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SignIn extends JFrame implements ActionListener{
    JButton signInButton, signUpButton, forgetPasswordButton;
    JTextField usernameArea;
    JPasswordField passwordField;
    SignIn(){

        setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZED_BOTH it will adjust Panel with Screen
        setLayout(null);

        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/hotel10.jpg"));
        Image i2 = backgroundImage.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel totalLabel = new JLabel(i3);
        totalLabel.setBounds(0, 0, 1920, 1080);
        add(totalLabel);

        JLabel headingLabel = new JLabel("Welcome to Tour Guide Finder");
        headingLabel.setBounds(360, 160, 1100, 80);
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

        signInButton = new JButton("Login");
        signInButton.setBounds(620, 450, 100, 40);
        signInButton.setBackground(Color.WHITE);
        signInButton.setForeground(new Color(255, 128, 0));
        signInButton.setBorder(BorderFactory.createEmptyBorder());
        signInButton.addActionListener(this);
        totalLabel.add(signInButton);

        signUpButton = new JButton("SignUp");
        signUpButton.setBounds(1020, 450, 100, 40);
        signUpButton.setBackground(Color.WHITE);
        signUpButton.setForeground(new Color(255, 128, 0));
        signUpButton.setBorder(BorderFactory.createEmptyBorder());
        signUpButton.addActionListener(this);
        totalLabel.add(signUpButton);

        forgetPasswordButton = new JButton("Admin Login");
        forgetPasswordButton.setBounds(800, 520, 150, 40);
        forgetPasswordButton.setBackground(Color.WHITE);
        forgetPasswordButton.setForeground(new Color(255, 128, 0));
        forgetPasswordButton.setBorder(BorderFactory.createEmptyBorder());
        forgetPasswordButton.addActionListener(this);
        totalLabel.add(forgetPasswordButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == signInButton){
            try {
                String username = usernameArea.getText();
                String password = passwordField.getText();

                int lenUsername = username.length();
                int lenPassword = password.length();
                if(lenUsername == 0 && lenPassword == 0){
                    JOptionPane.showMessageDialog(null, "Please fill up the username and password.");
                }
                else if(lenUsername == 0){
                    JOptionPane.showMessageDialog(null, "Please fill up username.");
                }
                else if(lenPassword == 0){
                    JOptionPane.showMessageDialog(null, "Please fill up password.");
                }
                else if(lenUsername != 0 && lenPassword != 0) {
                    String query = "select * from account where username = '"+username+"' and  password = '"+password+"'";
                    ConnectDB c = new ConnectDB();
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        new Dashboard(username).setVisible(true); /// User name add 1.
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Login");
                    }
                }
            }catch (Exception e){

            }
        }else if(ae.getSource() == signUpButton){
            new SignUp().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == forgetPasswordButton){
            new ForgetPassword().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new SignIn();
    }

}

