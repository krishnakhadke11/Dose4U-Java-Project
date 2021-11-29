package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{
    static JLabel Time;
    JButton b2,b3;
    LinkedList ll1=new LinkedList();
    Home(String username){
        JButton b1= new JButton("Add Patients Record");
        b1.setBounds(20,50,150,30);
        add(b1);

         b2= new JButton("Add Reminder");
        b2.setBounds(20,120,150,30);
        add(b2);
        b2.addActionListener( this);

        b3= new JButton("Logout");
        b3.setBounds(20,190,150,30);
        add(b3);

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
            new AddReminder(ll1);
            //this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Home("admin2");
    }
}
