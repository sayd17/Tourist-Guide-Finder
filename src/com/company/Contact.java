package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contact extends JFrame implements ActionListener {
    JButton sendButton, backButton;
    JTextArea messageTextArea;
    String username;
    Contact(String username){
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZED_BOTH it will adjust Panel with Screen
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/hotel10.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel totalLabel = new JLabel(i3);
        totalLabel.setBounds(0, 0, 1920, 1080);
        add(totalLabel);

        JLabel headingLabel = new JLabel("If you have any query contact us");
        headingLabel.setBounds(330, 100, 1000, 70);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
        totalLabel.add(headingLabel);

        JLabel messageLabel = new JLabel("Message");
        messageLabel.setBounds(400, 220, 250, 40);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(messageLabel);

        messageTextArea = new JTextArea();
        messageTextArea.setBounds(570, 220, 500, 300);
        messageTextArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        messageTextArea.setBackground(Color.WHITE);
        messageTextArea.setForeground(new Color(255, 128, 0));
        messageTextArea.setBorder(BorderFactory.createEmptyBorder());
        messageTextArea.setLineWrap(true);
        messageTextArea.setWrapStyleWord(true);
        totalLabel.add(messageTextArea);


        sendButton = new JButton("Send");
        sendButton.setBounds(570, 550, 130, 40);
        sendButton.setBackground(Color.WHITE);
        sendButton.setForeground(new Color(255, 128, 0));
        sendButton.setBorder(BorderFactory.createEmptyBorder());
        sendButton.addActionListener(this);
        totalLabel.add(sendButton);

        backButton = new JButton("Back");
        backButton.setBounds(940, 550, 130, 40);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(new Color(255, 128, 0));
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.addActionListener(this);
        totalLabel.add(backButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == sendButton) {
            String text = messageTextArea.getText();
            //String get = "insert account values ('sea_26', '"+text+"')";
            String nameU = "insert into contactRelation values('"+username+"', '"+text+"')";


            try {
                ConnectDB c = new ConnectDB();
                c.s.executeUpdate(nameU);
                messageTextArea.setText("");
                JOptionPane.showMessageDialog(null, "Your message recoded.");
                //this.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace(); // To check exception
            }
        }else  if(ae.getSource() == backButton){
            new Dashboard(username).setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new Contact("").setVisible(true);
    }
}
