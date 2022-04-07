package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton profileButton, findGuideButton, guideLeaderboardButton, touristLeaderboardButton, contactUsButton, logoutButton;
    String username;

    Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZED_BOTH it will adjust Panel with Screen
        setLayout(null);

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(null);
        dashboardPanel.setBounds(0, 0, 1920, 50);
        dashboardPanel.setBackground(new Color(255, 128, 0));
        add(dashboardPanel);

        JLabel dashboardLabel = new JLabel("Dashboard");
        dashboardLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        dashboardLabel.setForeground(Color.WHITE);
        dashboardLabel.setBounds(10, 5, 300, 40);
        dashboardPanel.add(dashboardLabel);

        JPanel featurePanel = new JPanel();
        featurePanel.setLayout(null);
        featurePanel.setBounds(0, 51, 300, 1080);
        featurePanel.setBackground(new Color(51, 51, 51));
        add(featurePanel);

        profileButton = new JButton("Profile");
        profileButton.setBackground(new Color(51, 51, 51));
        profileButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        profileButton.setForeground(Color.WHITE);
        profileButton.setBounds(0, 0, 300, 40);
        profileButton.setMargin(new Insets(0, 0, 0, 210));
        profileButton.addActionListener((ActionListener) this);
        //b1.setBorder(BorderFactory.createEmptyBorder());
        featurePanel.add(profileButton);

        findGuideButton = new JButton("Find Guide");
        findGuideButton.setBackground(new Color(51, 51, 51));
        findGuideButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        findGuideButton.setForeground(Color.WHITE);
        findGuideButton.setMargin(new Insets(0, 0, 0, 167));
        findGuideButton.setBounds(0, 40, 300, 40);
        //b2.setBorder(BorderFactory.createEmptyBorder());
        findGuideButton.addActionListener(this);
        featurePanel.add(findGuideButton);

        guideLeaderboardButton = new JButton("Guide Leaderboard");
        guideLeaderboardButton.setBackground(new Color(51, 51, 51));
        guideLeaderboardButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        guideLeaderboardButton.setForeground(Color.WHITE);
        guideLeaderboardButton.setMargin(new Insets(0, 0, 0, 88));
        guideLeaderboardButton.setBounds(0, 80, 300, 40);
        //b2.setBorder(BorderFactory.createEmptyBorder());
        featurePanel.add(guideLeaderboardButton);

        touristLeaderboardButton = new JButton("Tourist Leaderboard");
        touristLeaderboardButton.setBackground(new Color(51, 51, 51));
        touristLeaderboardButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        touristLeaderboardButton.setForeground(Color.WHITE);
        touristLeaderboardButton.setBounds(0, 120, 300, 40);
        touristLeaderboardButton.setMargin(new Insets(0, 0, 0, 77));
        //b3.setBorder(BorderFactory.createEmptyBorder());
        featurePanel.add(touristLeaderboardButton);

        contactUsButton = new JButton("Contact US");
        contactUsButton.setBackground(new Color(51, 51, 51));
        contactUsButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        contactUsButton.setForeground(Color.WHITE);
        contactUsButton.setBounds(0, 160, 300, 40);
        contactUsButton.setMargin(new Insets(0, 0, 0, 170));
        contactUsButton.addActionListener(this);
        //b3.setBorder(BorderFactory.createEmptyBorder());
        featurePanel.add(contactUsButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(51, 51, 51));
        logoutButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBounds(0, 200, 300, 40);
        logoutButton.setMargin(new Insets(0, 0, 0, 210));
        //b3.setBorder(BorderFactory.createEmptyBorder());
        logoutButton.addActionListener(this);
        featurePanel.add(logoutButton);


        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/home.jpg"));
        Image i2 = backgroundImage.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1920, 1080);
        add(l1);

        JLabel headingLabel = new JLabel("Tour Guide Finder");
        headingLabel.setBounds(640, 100, 1000, 80);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 75));
        l1.add(headingLabel);

        JLabel subscriptHeadingLabel = new JLabel("Find your tour guide");
        subscriptHeadingLabel.setBounds(650, 185, 1000, 25);
        subscriptHeadingLabel.setForeground(Color.WHITE);
        subscriptHeadingLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.add(subscriptHeadingLabel);

        JLabel purposeLabel1 = new JLabel("Our purpose is to help tourist to find");
        purposeLabel1.setBounds(430, 365, 1000, 60);
        purposeLabel1.setForeground(new Color(255, 128, 0));
        purposeLabel1.setFont(new Font("Tahoma", Font.PLAIN, 58));
        l1.add(purposeLabel1);

        JLabel purposeLabel2 = new JLabel("reliable tour guide around the world");
        purposeLabel2.setBounds(435, 430, 1000, 70);
        purposeLabel2.setForeground(new Color(255, 128, 0));
        purposeLabel2.setFont(new Font("Tahoma", Font.PLAIN, 58));
        l1.add(purposeLabel2);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == profileButton) {
            try {
                new UpdateProfile(username).setVisible(true); /// username add 2
                this.setVisible(false);
            } catch (Exception e) {}
        } else if (ae.getSource() == findGuideButton) {
            new FindGuide().setVisible(true);
            //this.setVisible(false);
        } else if (ae.getSource() == guideLeaderboardButton) {
           // new GuideLeaderboard();
        } else if (ae.getSource() == touristLeaderboardButton) {
           // new TouristLeaderboard();
        } else if (ae.getSource() == contactUsButton) {
            new Contact(username).setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == logoutButton) {
            new SignIn().setVisible(true);
            this.setVisible(false);
        }
    }


    public static void main(String[] args) {
        new Dashboard("").setVisible(true);
    }
}
