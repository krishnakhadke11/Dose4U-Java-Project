package com.Dose4U;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ViewReminder extends JFrame implements ActionListener{
    JTable table;
    JButton b1_edit, b2_back;
    JLabel l1_sr, l2_med, l3_time;
    String username;
    ViewReminder(String userid){
        this.username = userid;
        table = new JTable();
        table.setBounds(50, 50, 590, 300);
        add(table);

        l1_sr = new JLabel("Sr. No.");
        l1_sr.setBounds(130, 30, 60, 20);
        add(l1_sr);

        l2_med = new JLabel("Medicine");
        l2_med.setBounds(320, 30, 60, 20);
        add(l2_med);

        l3_time = new JLabel("Time");
        l3_time.setBounds(530, 30, 60, 20);
        add(l3_time);

        b1_edit = new JButton("Edit ");
        b1_edit.setBounds(210, 380, 100, 25);
        b1_edit.addActionListener(this);
        add(b1_edit);

        b2_back = new JButton("Back");
        b2_back.setBounds(360, 380, 100,25);
        b2_back.addActionListener(this);
        add(b2_back);

        MyJdbc view_connect = new MyJdbc();
        String input = "select sr_no, medicine, time from reminder where username = '" +username+ "'";
//        String input = "select sr_no, medicine, time from reminder where username = 'hi'";
        try {
            ResultSet rs = view_connect.st.executeQuery(input);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            view_connect.conn.close();
            view_connect.st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        this.setBounds(415,100,700,500);
        this.setTitle("View Reminder");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1_edit){
            new EditReminder(username);
            this.setVisible(false);
        }
        else if(e.getSource()==b2_back){
            new Home(username);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        //new ViewReminder("hi");
    }
}