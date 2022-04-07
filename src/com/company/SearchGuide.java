package com.company;

import javax.swing.*;

public class SearchGuide{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
    private static void createGUI(){

        Mysearch ui;
        ui = new Mysearch();

        //JPanel root = ui.getRootPanel();
        //JFrame frame = new JFrame();
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setContentPane(root);
       // frame.pack();
       // frame.setLocationRelativeTo(null);
       // frame.setVisible(true);
    }
}


