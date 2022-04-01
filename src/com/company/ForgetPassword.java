package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgetPassword extends JFrame implements ActionListener{
    JButton sendButton, backButton;
    JTextField emailPhoneArea;
    ForgetPassword(){
        setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZED_BOTH it will adjust Panel with Screen
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/hotel10.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel totalLabel = new JLabel(i3);
        totalLabel.setBounds(0, 0, 1920, 1080);
        add(totalLabel);

        JLabel headingLabel = new JLabel("Enter your Email or Phone number");
        headingLabel.setBounds(300, 180, 1100, 80);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 65));
        totalLabel.add(headingLabel);

        JLabel emailLabel = new JLabel("Email/Phone");
        emailLabel.setBounds(420, 310, 200, 40);
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(emailLabel);

        emailPhoneArea = new JTextField();
        emailPhoneArea.setBounds(640, 310, 500, 40);
        emailPhoneArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        emailPhoneArea.setBackground(Color.WHITE);
        emailPhoneArea.setForeground(new Color(255, 128, 0));
        emailPhoneArea.setBorder(BorderFactory.createEmptyBorder());
        add(emailPhoneArea);

        sendButton = new JButton("Send");
        sendButton.setBackground(Color.WHITE);
        sendButton.setForeground(new Color(255, 128, 0));
        sendButton.setBounds(640, 400, 200, 40);
        sendButton.setBorder(BorderFactory.createEmptyBorder());
        sendButton.addActionListener(this);
        totalLabel.add(sendButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(new Color(255, 128, 0));
        backButton.setBounds(940, 400, 200, 40);
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
                JOptionPane.showMessageDialog(null, "Already sent a code on your address.");
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
