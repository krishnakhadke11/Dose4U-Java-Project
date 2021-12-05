package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{
    static JLabel Time;
    JButton b1,b2,b3,b4;
    String username;

    Home(String username){
        this.username=username;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        b1= new JButton("View/Edit Reminder");
        b1.setBounds(20,50,150,30);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("Add Reminder");
        b2.setBounds(20,120,150,30);
        add(b2);
        b2.addActionListener( this);

        b3= new JButton("Edit Profile");
        b3.setBounds(20,190,150,30);
        add(b3);
        b3.addActionListener(this);

        b4= new JButton("Logout");
        b4.setBounds(20,260,150,30);
        add(b4);
        b4.addActionListener(this);

        Time = new JLabel("");
        Time.setBounds(450,50,100,25);
        add(Time);


        setTitle("Home");
        setBounds(320,100,900,500);
        setLayout(null);
        setVisible(true);

    }

    void clock()
    {
        Clock clc=new Clock(username);
        clc.start();
    }
     Home(int i) {
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            new ViewReminder(username);
            this.setVisible(false);
        }
        if (e.getSource()==b2)
        {
            new AddReminder(username);
            this.setVisible(false);
        }
        else if(e.getSource()==b3)
        {

        }
        else if(e.getSource()==b4)
        {
            new Login();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
       // Home home=new Home("admin2");
        //home.clock();

    }
}
