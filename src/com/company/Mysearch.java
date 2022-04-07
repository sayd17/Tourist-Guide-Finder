package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Mysearch {

    private JPanel rootPanel;
    private JTextArea searchField;
    private JTable table1;
    private JPanel panel2;
    private JPanel panel1;

    public Mysearch() {
        createTable();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createTable() {
        int data;
        table1.setModel(new DefaultTableModel(
                null,
                new String[]{"ID", "Title", "Year", "Rating"}

        ));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        new Mysearch();
    }
}
