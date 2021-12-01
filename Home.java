package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{
    static JLabel Time;
    JButton b2,b3,b4;
    String username;
    LinkedList ll1=new LinkedList();
    Home(String username){
        this.username=username;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton b1= new JButton("Add Patients Record");
        b1.setBounds(20,50,150,30);
        add(b1);

        b2= new JButton("Add Reminder");
        b2.setBounds(20,120,150,30);
        add(b2);
        b2.addActionListener( this);

        b3= new JButton("View Reminder");
        b3.setBounds(20,190,150,30);
        add(b3);
        b3.addActionListener(this);

        b4= new JButton("Logout");
        b4.setBounds(20,260,150,30);
        add(b4);

        Time = new JLabel("");
        Time.setBounds(450,50,100,25);
        add(Time);

        Clock clc=new Clock(ll1,username);
        clc.start();

        setTitle("Home");
        setBounds(320,100,900,500);
        setLayout(null);
        setVisible(true);

    }
     Home(int i) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b2)
        {
            new AddReminder(ll1,username);
            //this.setVisible(false);
        }
        else if(e.getSource()==b3)
        {
            new ViewReminder(username);
        }
    }

    public static void main(String[] args) {
        new Home("admin2");
    }
}
