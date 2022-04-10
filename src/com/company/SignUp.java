package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {
    JButton createButton, backButton;
    JTextField nameArea, emailPhoneArea, usernameArea, numberArea;
    Choice choice1;
    JPasswordField  passwordArea;
    public SignUp(){

        setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZED_BOTH it will adjust Panel with Screen
        setLayout(null);

        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/hotel10.jpg"));
        Image i2 = backgroundImage.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel totalLabel = new JLabel(i3);
        totalLabel.setBounds(0, 0, 1920, 1080);
        add(totalLabel);

        JLabel headingLabel = new JLabel("Sign Up");
        headingLabel.setBounds(640, 60, 1100, 80);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 65));
        totalLabel.add(headingLabel);


        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(380, 180, 240, 40);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(nameLabel);

        nameArea = new JTextField();
        nameArea.setBounds(680, 185, 500, 30);
        nameArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        nameArea.setBackground(Color.WHITE);
        nameArea.setForeground(new Color(255, 128, 0));
        nameArea.setBorder(BorderFactory.createEmptyBorder());
        add(nameArea);

        JLabel usernameLabel = new JLabel("Email/Phone");
        usernameLabel.setBounds(380, 240, 240, 40);
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(usernameLabel);

        emailPhoneArea = new JTextField();
        emailPhoneArea.setBounds(680, 250, 500, 30);
        emailPhoneArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        emailPhoneArea.setBackground(Color.WHITE);
        emailPhoneArea.setForeground(new Color(255, 128, 0));
        emailPhoneArea.setBorder(BorderFactory.createEmptyBorder());
        add(emailPhoneArea);

        JLabel emailPhoneLabel = new JLabel("Username");
        emailPhoneLabel.setBounds(380, 290, 290, 40);
        emailPhoneLabel.setForeground(Color.WHITE);
        emailPhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(emailPhoneLabel);

        usernameArea = new JTextField();
        usernameArea.setBounds(680, 300, 500, 30);
        usernameArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        usernameArea.setBackground(Color.WHITE);
        usernameArea.setForeground(new Color(255, 128, 0));
        usernameArea.setBorder(BorderFactory.createEmptyBorder());
        add(usernameArea);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(380, 340, 300, 40);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(passwordLabel);

        passwordArea = new JPasswordField();
        passwordArea.setBounds(680, 350, 500, 30);
        passwordArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordArea.setBackground(Color.WHITE);
        passwordArea.setForeground(new Color(255, 128, 0));
        passwordArea.setBorder(BorderFactory.createEmptyBorder());
        add(passwordArea);

        JLabel numberLabel = new JLabel("NID/Passport Number");
        numberLabel.setBounds(380, 390, 300, 40);
        numberLabel.setForeground(Color.WHITE);
        numberLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(numberLabel);

        numberArea = new JTextField();
        numberArea.setBounds(680, 400, 500, 30);
        numberArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        numberArea.setBackground(Color.WHITE);
        numberArea.setForeground(new Color(255, 128, 0));
        numberArea.setBorder(BorderFactory.createEmptyBorder());
        add(numberArea);

        JLabel choiceArea = new JLabel("Registration as a");
        choiceArea.setBounds(380, 440, 300, 40);
        choiceArea.setForeground(Color.WHITE);
        choiceArea.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(choiceArea);

        choice1 = new Choice();
        choice1.add("Guide");
        choice1.add("Tourist");
        choice1.setBounds(680, 450, 500, 50);
        totalLabel.add(choice1);

        createButton = new JButton("Create");
        createButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        createButton.setForeground(new Color(255, 128, 0));
        createButton.setBackground(Color.WHITE);
        createButton.setBorder(BorderFactory.createEmptyBorder());
        createButton.setBounds(680, 490, 100, 30);
        createButton.addActionListener(this);
        totalLabel.add(createButton);

        // Back Button

        backButton = new JButton("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setForeground(new Color(255, 128, 0));
        backButton.setBackground(Color.WHITE);
        backButton.setBounds(1080, 490, 100, 30);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.addActionListener(this);
        totalLabel.add(backButton);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == createButton){
            String name = nameArea.getText();
            String emailPhone = emailPhoneArea.getText();
            String username = usernameArea.getText();
            String password = passwordArea.getText();
            String nidPassport = numberArea.getText();
            String choice = choice1.getSelectedItem();

            int lenName = name.length();
            int lenEmailPhone = emailPhone.length();
            int lenUsername = username.length();
            int lenPassword = password.length();
            int lenNidPassport = nidPassport.length();
            int lenChoice = choice.length();
            String lenLanguageProficiency = "Blank";
            String lenCountry = "Blank";
            String lenAddress = "Blank";

            String query = "insert into account(username, name, emailPhone, password, nidPassport, choice) values('"+username+"', '"+name+"', '"+emailPhone+"', '"+password+"' , '"+nidPassport+"', '"+choice+"' )";
            try{
                if(lenName == 0){
                    JOptionPane.showMessageDialog(null, "Please fill the name.");
                }
                else if(lenEmailPhone == 0){
                    JOptionPane.showMessageDialog(null, "Please fill the Email or Phone.");
                }
                else if(lenUsername  == 0){
                    JOptionPane.showMessageDialog(null, "Please fill the username.");
                }
                else if(lenPassword  == 0){
                    JOptionPane.showMessageDialog(null, "Please fill the password.");
                }
                else if(lenNidPassport  == 0){
                    JOptionPane.showMessageDialog(null, "Please fill the Nid or Passport.");
                }
                else if(lenChoice  == 0){
                    JOptionPane.showMessageDialog(null, "Please fill the tourist or guide.");
                }
                else if(lenName != 0 && lenEmailPhone != 0 && lenUsername != 0 && lenPassword != 0 && lenNidPassport != 0 && lenChoice != 0){
                    ConnectDB c = new ConnectDB();
                    c.s.execute(query);
                    JOptionPane.showMessageDialog(null, "Account Created Successfully.");

                    this.setVisible(false);
                    new Dashboard(username).setVisible(true);
                }

            }
            catch (Exception e){

            }

        }else if(ae.getSource() == backButton){
            new SignIn().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SignUp().setVisible(true);
    }
}
