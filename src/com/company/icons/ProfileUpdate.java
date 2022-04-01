package com.company.icons;

import com.company.ConnectDB;
import com.company.SignIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Stack;

public class ProfileUpdate extends JFrame implements ActionListener {
    JTextField t2, t3, t4, t5, t6, t7, t8, t9, t10;
    JButton b1, b2;
    Choice choice1, choice2;
    JComboBox c1, c2;
    ProfileUpdate(){

        setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZED_BOTH it will adjust Panel with Screen
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/hotel10.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l0 = new JLabel(i3);
        l0.setBounds(0, 0, 1920, 1080);
        add(l0);

        JLabel l1 = new JLabel("User Profile");
        l1.setBounds(640, 60, 1100, 80);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 65));
        l0.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(380, 180, 240, 40);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l0.add(l2);

        t2 = new JTextField();
        t2.setBounds(680, 185, 500, 30);
        t2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        t2.setBackground(Color.WHITE);
        t2.setForeground(new Color(255, 128, 0));
        t2.setBorder(BorderFactory.createEmptyBorder());
        add(t2);

        JLabel l3 = new JLabel("Username");
        l3.setBounds(380, 240, 240, 40);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l0.add(l3);

        t3 = new JTextField();
        t3.setBounds(680, 250, 500, 30);
        t3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        t3.setBackground(Color.WHITE);
        t3.setForeground(new Color(255, 128, 0));
        t3.setBorder(BorderFactory.createEmptyBorder());
        add(t3);

        JLabel l4 = new JLabel("Identity Card");
        l4.setBounds(380, 290, 240, 40);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l0.add(l4);

        c1 = new JComboBox(new String[] {"National Identity Number", "Passport Number", "Social Security Number", "Driving License Number"});
        c1.setBounds(680, 300, 500, 30);
        c1.setBackground(Color.WHITE);
        c1.setForeground(new Color(255, 128, 0));
        l0.add(c1);
      /*
        choice1 = new Choice();
        choice1.add("National Identity Number");
        choice1.add("Passport Number");
        choice1.add("Social Security Number");
        choice1.add("Driving License Number");
        choice1.setBounds(680, 250, 500, 30);
        choice1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.add(choice1);
      */

        JLabel l5 = new JLabel("Number");
        l5.setBounds(380, 340, 240, 40);
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l0.add(l5);

        t5 = new JTextField();
        t5.setBounds(680, 350, 500, 30);
        t5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        t5.setBackground(Color.WHITE);
        t5.setForeground(new Color(255, 128, 0));
        t5.setBorder(BorderFactory.createEmptyBorder());
        add(t5);

        JLabel l6= new JLabel("Gender");
        l6.setBounds(380, 390, 240, 40);
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l0.add(l6);

        c2 = new JComboBox(new String[] {"Male", "Female", "Others"});
        c2.setBounds(680, 400, 500, 30);
        c2.setBackground(Color.WHITE);
        c2.setForeground(new Color(255, 128, 0));
        l0.add(c2);

        /*
        choice2 = new Choice();
        choice2.add("Male");
        choice2.add("Female");
        choice2.add("Others");
        choice2.setBounds(680, 350, 500, 30);
        choice2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.add(choice2);
        */
        JLabel l7 = new JLabel("Language Proficiency");
        l7.setBounds(380, 440, 290, 40);
        l7.setForeground(Color.WHITE);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l0.add(l7);

        t7 = new JTextField();
        t7.setBounds(680, 450, 500, 30);
        t7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        t7.setBackground(Color.WHITE);
        t7.setForeground(new Color(255, 128, 0));
        t7.setBorder(BorderFactory.createEmptyBorder());
        add(t7);

        JLabel l8 = new JLabel("Country");
        l8.setBounds(380, 490, 240, 40);
        l8.setForeground(Color.WHITE);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l0.add(l8);

        t8 = new JTextField();
        t8.setBounds(680, 500, 500, 30);
        t8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        t8.setBackground(Color.WHITE);
        t8.setForeground(new Color(255, 128, 0));
        t8.setBorder(BorderFactory.createEmptyBorder());
        add(t8);


        JLabel l9 = new JLabel("Address");
        l9.setBounds(380, 540, 240, 40);
        l9.setForeground(Color.WHITE);
        l9.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l0.add(l9);

        t9 = new JTextField();
        t9.setBounds(680, 550, 500, 30);
        t9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        t9.setBackground(Color.WHITE);
        t9.setForeground(new Color(255, 128, 0));
        t9.setBorder(BorderFactory.createEmptyBorder());
        add(t9);


        b1 = new JButton("Save");
        b1.setBackground(Color.WHITE);
        b1.setForeground(new Color(255, 128, 0));
        b1.setBounds(570, 650, 100, 40);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        l0.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(255, 128, 0));
        b2.setBounds(870, 650, 100, 40);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.addActionListener(this);
        l0.add(b2);

        try{

        }catch (Exception e){
            ConnectDB c =  new ConnectDB();
            //ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1) {
            String name = t2.getText();
            String username = t3.getText();
            String id = (String) c1.getSelectedItem();
            String number = t5.getText();
            String gender = (String) c2.getSelectedItem();
            String languageProficiency = t7.getText();
            String country = t8.getText();
            String address = t9.getText();
            String data = "insert into customer values('" + name + "','" + username + "', '" + id + "', '" + number + "', '" + gender + "', '" + languageProficiency + "', '" + country + "', '" + address + "')";

            try {
                ConnectDB c = new ConnectDB();
                //c.s.executeUpdate(data);
                JOptionPane.showMessageDialog(null, "User Details Added Successfully");
                this.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace(); // To check exception
            }
        }else  if(ae.getSource() == b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new ProfileUpdate().setVisible(true);
    }
}
