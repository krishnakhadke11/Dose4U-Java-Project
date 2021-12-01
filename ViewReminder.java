package com.Dose4U;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;

public class ViewReminder extends JFrame {
    JTable t1;
    JButton b1,b2;
    String username;
    MyJdbc ViewReminder_connect=new MyJdbc();
    ViewReminder(String username)
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.username=username;
        t1=new JTable();
        t1.setBounds(100,50,700,300);
        add(t1);

        b1=new JButton("Edit data");
        b1.setBounds(270,390,150,30);
        add(b1);

        b2=new JButton("back");
        b2.setBounds(500,390,150,30);
        add(b2);
        try {
            ResultSet rs = ViewReminder_connect.st.executeQuery("select prescription,time from addreminder where username='"+username+"'");
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        setTitle("Home");
        setBounds(320,100,900,500);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewReminder("admin2");
    }
}
