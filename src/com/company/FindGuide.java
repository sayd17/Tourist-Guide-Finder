package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindGuide extends JFrame {
    JFrame frame;
    DefaultTableModel defaultTableModel;
    JTable table;

    public FindGuide() {
        frame = new JFrame("Guide List");
        frame.setLayout(new FlowLayout());
        frame.setBounds(400, 100, 750, 600);

        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(800, 600));
        table.setFillsViewportHeight(true);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(Object.class, centerRenderer);

        frame.add(new JScrollPane(table));
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Email/Phone");
        defaultTableModel.addColumn("Language Proficiency");
        defaultTableModel.addColumn("Address");
        defaultTableModel.addColumn("Country");

        try {
            ConnectDB c = new ConnectDB();
            String query = "select * from account where choice = 'Guide'";//Storing MySQL query in A string variable
            ResultSet resultSet = c.s.executeQuery(query);//executing query and storing result in ResultSet
            int len = query.length();

            if (len == 0) {
                JOptionPane.showMessageDialog(null, "No Such Username Found");//When invalid username is entered
            } else {
                while (len-- > 0) {
                    while (resultSet.next()) {
                        String Name = resultSet.getString("name");
                        String Phone = resultSet.getString("emailPhone");
                        String LanguageProficiency = resultSet.getString("languageProficiency");
                        String AddressC = resultSet.getString("address");
                        String CountryC = resultSet.getString("country");
                        defaultTableModel.addRow(new Object[]{Name, Phone, LanguageProficiency, AddressC, CountryC});
                        frame.setVisible(true);
                        frame.validate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FindGuide().setVisible(true);
    }
}