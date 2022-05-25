package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;

public class UpdateProfile extends JFrame implements ActionListener {
    JTextField nameArea, emailPhoneArea, usernameArea, numberArea, languageProficiencyArea, countryArea, addressArea;
    JButton saveButton, backButton, updatePasswordButton, browseButton;
    String username;
    String selectedImagePath; /// for image filename or file path
    //JLabel jLabelImage;
    JLabel jLabelImage = new JLabel();

    UpdateProfile(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZED_BOTH it will adjust Panel with Screen
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(selectedImagePath);

        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/hotel10.jpg"));
        Image i2 = backgroundImage.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel totalLabel = new JLabel(i3);
        totalLabel.setBounds(0, 0, 1920, 1080);
        add(totalLabel);

        browseButton = new JButton("Add Image");
        browseButton.setBackground(Color.WHITE);
        browseButton.setForeground(new Color(255, 128, 0));
        browseButton.setBounds(1200, 500, 100, 40);
        browseButton.setBorder(BorderFactory.createEmptyBorder());
        browseButton.addActionListener(this);
        totalLabel.add(browseButton);

        jLabelImage.setBounds(1200, 100, 250, 200);
        //jLabelImage.add(imageIcon);
        totalLabel.add(jLabelImage);

        JLabel headingLabel = new JLabel("User Profile");
        headingLabel.setBounds(540, 60, 1100, 80);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 65));
        totalLabel.add(headingLabel);


        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(280, 190, 240, 40);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(nameLabel);

        nameArea = new JTextField();
        nameArea.setBounds(580, 200, 500, 30);
        nameArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        nameArea.setBackground(Color.WHITE);
        nameArea.setForeground(new Color(255, 128, 0));
        nameArea.setBorder(BorderFactory.createEmptyBorder());
        totalLabel.add(nameArea);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(280, 240, 240, 40);
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(usernameLabel);

        usernameArea = new JTextField();
        usernameArea.setBounds(580, 250, 500, 30);
        usernameArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        usernameArea.setBackground(Color.WHITE);
        usernameArea.setForeground(new Color(255, 128, 0));
        usernameArea.setBorder(BorderFactory.createEmptyBorder());
        totalLabel.add(usernameArea);

        JLabel emailPhoneLabel = new JLabel("Email/Phone");
        emailPhoneLabel.setBounds(280, 290, 290, 40);
        emailPhoneLabel.setForeground(Color.WHITE);
        emailPhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(emailPhoneLabel);

        emailPhoneArea = new JTextField();
        emailPhoneArea.setBounds(580, 300, 500, 30);
        emailPhoneArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        emailPhoneArea.setBackground(Color.WHITE);
        emailPhoneArea.setForeground(new Color(255, 128, 0));
        emailPhoneArea.setBorder(BorderFactory.createEmptyBorder());
        totalLabel.add(emailPhoneArea);

        JLabel numberLabel = new JLabel("NID/Passport Number");
        numberLabel.setBounds(280, 340, 300, 40);
        numberLabel.setForeground(Color.WHITE);
        numberLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(numberLabel);

        numberArea = new JTextField();
        numberArea.setBounds(580, 350, 500, 30);
        numberArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        numberArea.setBackground(Color.WHITE);
        numberArea.setForeground(new Color(255, 128, 0));
        numberArea.setBorder(BorderFactory.createEmptyBorder());
        totalLabel.add(numberArea);

        JLabel languageProficiencyLabel = new JLabel("Language Proficiency");
        languageProficiencyLabel.setBounds(280, 390, 290, 40);
        languageProficiencyLabel.setForeground(Color.WHITE);
        languageProficiencyLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(languageProficiencyLabel);

        languageProficiencyArea = new JTextField();
        languageProficiencyArea.setBounds(580, 400, 500, 30);
        languageProficiencyArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        languageProficiencyArea.setBackground(Color.WHITE);
        languageProficiencyArea.setForeground(new Color(255, 128, 0));
        languageProficiencyArea.setBorder(BorderFactory.createEmptyBorder());
        totalLabel.add(languageProficiencyArea);

        JLabel countryLabel = new JLabel("Country");
        countryLabel.setBounds(280, 440, 240, 40);
        countryLabel.setForeground(Color.WHITE);
        countryLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(countryLabel);

        countryArea = new JTextField();
        countryArea.setBounds(580, 450, 500, 30);
        countryArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        countryArea.setBackground(Color.WHITE);
        countryArea.setForeground(new Color(255, 128, 0));
        countryArea.setBorder(BorderFactory.createEmptyBorder());
        totalLabel.add(countryArea);


        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(280, 490, 240, 40);
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        totalLabel.add(addressLabel);

        addressArea = new JTextField();
        addressArea.setBounds(580, 500, 500, 30);
        addressArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addressArea.setBackground(Color.WHITE);
        addressArea.setForeground(new Color(255, 128, 0));
        addressArea.setBorder(BorderFactory.createEmptyBorder());
        totalLabel.add(addressArea);

       /* updatePasswordButton = new JButton("Change Password");
        updatePasswordButton.setBackground(Color.WHITE);
        updatePasswordButton.setForeground(new Color(255, 128, 0));
        updatePasswordButton.setBounds(580, 560, 500, 40);
        updatePasswordButton.setBorder(BorderFactory.createEmptyBorder());
        updatePasswordButton.addActionListener(this);
        totalLabel.add(updatePasswordButton);*/

        saveButton = new JButton("Save");
        saveButton.setBackground(Color.WHITE);
        saveButton.setForeground(new Color(255, 128, 0));
        saveButton.setBounds(580, 650, 100, 40);
        saveButton.setBorder(BorderFactory.createEmptyBorder());
        saveButton.addActionListener(this);
        totalLabel.add(saveButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(new Color(255, 128, 0));
        backButton.setBounds(980, 650, 100, 40);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.addActionListener(this);
        totalLabel.add(backButton);

// For retrieving username and name to profile
        try {
            ConnectDB c = new ConnectDB();
            ResultSet rs = c.s.executeQuery("select * from account where username = '" + username + "'"); /// username add 5
            while (rs.next()) {
                nameArea.setText(rs.getString("name"));
                emailPhoneArea.setText(rs.getString("emailPhone"));
                usernameArea.setText(rs.getString("username"));
                numberArea.setText(rs.getString("nidPassport"));
                languageProficiencyArea.setText(rs.getString("languageProficiency"));
                countryArea.setText(rs.getString("country"));
                addressArea.setText(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == browseButton){
            //Setting default browser location
            JFileChooser browseImageFile = new JFileChooser("C:\\Movies&Others\\1.Pictures\\Profile");
            // filter image extensions
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg");
            browseImageFile.addChoosableFileFilter(fnef);
            int showOpenDialogue = browseImageFile.showOpenDialog(null);

            if(showOpenDialogue == JFileChooser.APPROVE_OPTION){
                File selectedImageFile = browseImageFile.getSelectedFile();
                selectedImagePath = selectedImageFile.getAbsolutePath();
                JOptionPane.showMessageDialog(null, selectedImagePath);
                //Display image on JLabel
                ImageIcon imageIcon2 = new ImageIcon(selectedImagePath);
                //Resize image to fit JLabel
                Image image = imageIcon2.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
                jLabelImage.setIcon(new ImageIcon(image));

                //For storing data into database
                try{

                }catch(Exception e){
                    e.printStackTrace();
                }

            }

        }
        else if (ae.getSource() == updatePasswordButton) {
            new ResetPassword(username).setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == saveButton) {
            String name = nameArea.getText();

            //String id = (String) identityCardSelect.getSelectedItem();
            String emailPh = emailPhoneArea.getText();
            String number = numberArea.getText();
            String languageProficiency = languageProficiencyArea.getText();
            String country = countryArea.getText();
            String address = addressArea.getText();

            String nameUpdate = "update account set name = '" + name + "' where username = '" + username + "'";  /// username updat combine 6
            String emailPhUpdate = "update account set emailPhone = '" + emailPh + "' where username = '" + username + "'";
            String numberUpdate = "update account set nidPassport = '" + number + "' where username = '" + username + "'";
            String languageUpdate = "update account set languageProficiency = '" + languageProficiency + "' where username = '" + username + "'";
            String countryUpdate = "update account set country = '" + country + "' where username = '" + username + "'";
            String addressUpdate = "update account set address = '" + address + "' where username = '" + username + "'";

            try {
                ConnectDB c1 = new ConnectDB();
                c1.s.executeUpdate(nameUpdate);

                ConnectDB c2 = new ConnectDB();
                c2.s.executeUpdate(emailPhUpdate);

                ConnectDB c3 = new ConnectDB();
                c3.s.executeUpdate(numberUpdate);

                ConnectDB c4 = new ConnectDB();
                c4.s.executeUpdate(languageUpdate);

                ConnectDB c5 = new ConnectDB();
                c5.s.executeUpdate(countryUpdate);

                ConnectDB c6 = new ConnectDB();
                c6.s.executeUpdate(addressUpdate);

                JOptionPane.showMessageDialog(null, "All detail update successfully");
                //this.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace(); // To check exception
            }
        } else if (ae.getSource() == backButton) {
            new Dashboard(username).setVisible(true); /// username update 4
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateProfile("").setVisible(true);
    }
}