package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetPassword extends JFrame implements ActionListener {
    JPasswordField newPassword, reEnterNewPassword;
    JButton backButton, sendButton;
    String username;
    ResetPassword(String username){
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZED_BOTH it will adjust Panel with Screen
        setLayout(null);

        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/hotel10.jpg"));
        Image i2 = backgroundImage.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel totalLabel = new JLabel(i3);
        totalLabel.setBounds(0, 0, 1920, 1080);
        add(totalLabel);

        JLabel headingLabel = new JLabel("Change Password");
        headingLabel.setBounds(550, 160, 1100, 80);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 65));
        totalLabel.add(headingLabel);

        JLabel newPasswordLabel = new JLabel("Password");
        newPasswordLabel.setBounds(380, 280, 340, 40);
        newPasswordLabel.setForeground(Color.WHITE);
        newPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(newPasswordLabel);

        newPassword = new JPasswordField();
        newPassword.setBounds(700, 285, 500, 30);
        newPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        newPassword.setBackground(Color.WHITE);
        newPassword.setForeground(new Color(255, 128, 0));
        newPassword.setBorder(BorderFactory.createEmptyBorder());
        add(newPassword);

        JLabel reEnterNewPasswordLabel = new JLabel("Re enter password");
        reEnterNewPasswordLabel.setBounds(380, 335, 340, 40);
        reEnterNewPasswordLabel.setForeground(Color.WHITE);
        reEnterNewPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(reEnterNewPasswordLabel);

        reEnterNewPassword = new JPasswordField();
        reEnterNewPassword.setBounds(700, 335, 500, 30);
        reEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        reEnterNewPassword.setBackground(Color.WHITE);
        reEnterNewPassword.setForeground(new Color(255, 128, 0));
        reEnterNewPassword.setBorder(BorderFactory.createEmptyBorder());
        add(reEnterNewPassword);

        sendButton = new JButton("Send");
        sendButton.setBackground(Color.WHITE);
        sendButton.setForeground(new Color(255, 128, 0));
        sendButton.setBounds(700, 400, 200, 40);
        sendButton.setBorder(BorderFactory.createEmptyBorder());
        sendButton.addActionListener(this);
        totalLabel.add(sendButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(new Color(255, 128, 0));
        backButton.setBounds(1000, 400, 200, 40);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.addActionListener(this);
        totalLabel.add(backButton);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == sendButton){
            if(newPassword.equals(reEnterNewPassword)){
                JOptionPane.showMessageDialog(null, "Please enter same password.");
            }
            else {
                //new SignIn().setVisible(true);
                //this.setVisible(false);
                String newPass = newPassword.getText();
                String passUpdate = "update account set password = '"+newPass+"' where username = '"+username+"'";

                try {

                    ConnectDB c = new ConnectDB();
                    c.s.executeUpdate(passUpdate);
                    JOptionPane.showMessageDialog(null, "Changed Password Successfully.");
                    //this.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace(); // To check exception
                }
            }
        }
        else  if(ae.getSource() == backButton){
            new UpdateProfile(username).setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new ResetPassword("").setVisible(true);
    }

}
