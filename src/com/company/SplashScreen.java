package com.company;

import javax.swing.*; // For ImageIcon
import java.awt.*;

/*
    Method Uses:
        1. Multi Threading
        2. Inheritance
        3. Overriding
        4. Swing
        5. AWT
*/

public class SplashScreen {
    // Using Multi threading java's concept to create splash screen
    public static void main(String[] args){
        SplashFrame frame = new SplashFrame();
        frame.setVisible(true);

        int x = 1;
        for(int i = 1; i <= 700; i += 6, x += 5) {
            frame.setLocation(760 - (x + i) / 2, 430 - (i / 2));
            frame.setSize(x + i, i);
            try{
                Thread.sleep(10);
            }catch (Exception e){}
        }

        frame.setVisible(true);
    }
}

class SplashFrame extends JFrame implements Runnable{
    Thread t1;
    SplashFrame(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 700, Image.SCALE_DEFAULT); // To scale the image for minimize screen
        ImageIcon i3 = new ImageIcon(i2); // Creating object i3 of ImageIcon
        JLabel l1 = new JLabel(i3); // We keep object of ImageIcon inside JLabel
        add(l1);

        // setLocation(300, 200); // showing image: x - from left and y - from top
        // setSize(600, 400);  // size of the image
        // setBounds(200, 200, 1600, 700); // First two argument showing image: x - from left and y - from top and last two argument showing image size

        setUndecorated(true); /// For removing upper boarder of splash frame.
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{   /// Frame of current class will be closed after 7 seconds.
            Thread.sleep(3000);
            this.setVisible(false);

            new SignIn().setVisible(true);
        }catch (Exception e){}
    }
}