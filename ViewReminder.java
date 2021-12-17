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
        Container c = getContentPane();
        c.setBackground(Color.pink);
        c.setLayout(null);

        JLabel title = new JLabel("YOUR REMINDERS");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setSize(290, 40);
        title.setLocation(305, 20);
        c.add(title);

        table = new JTable();
        table.setBounds(150, 110, 590, 250);
        table.setBackground(Color.lightGray);
        c.add(table);


        l1_sr = new JLabel("Sr No.");
        l1_sr.setBounds(155, 80, 60, 20);
        l1_sr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.add(l1_sr);

        l2_med = new JLabel("Medicine");
        l2_med.setBounds(350, 80, 100, 20);
        l2_med.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.add(l2_med);

        l3_time = new JLabel("Time");
        l3_time.setBounds(550, 80, 60, 20);
        l3_time.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.add(l3_time);

        b1_edit = new JButton("Edit ");
        b1_edit.setBounds(275, 380, 100, 25);
        b1_edit.addActionListener(this);
        c.add(b1_edit);

        b2_back = new JButton("Back");
        b2_back.setBounds(525, 380, 100,25);
        b2_back.addActionListener(this);
        c.add(b2_back);

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

        this.setBounds(320,100,900,500);
        this.setTitle("Dose4U");
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
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        //new ViewReminder("hi");
    }
}