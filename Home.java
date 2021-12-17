package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{
    static JLabel Time;
    JButton b1,b2,b3,b4;
    String username;
    Clock clc;
    Home(String username){
        Container c = getContentPane();
        c.setBackground(Color.pink);
        c.setLayout(null);

        this.username=username;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel title = new JLabel("HOME");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setSize(600, 40);
        title.setLocation(400, 30);
        c.add(title);

        b1= new JButton("View/Edit Reminder");
        b1.setBounds(375,255,150,40);
        b1.addActionListener(this);
        c.add(b1);

        b2= new JButton("Add Reminder");
        b2.setBounds(375,180,150,40);
        c.add(b2);
        b2.addActionListener( this);

        b3= new JButton("Edit Profile");
        b3.setBounds(375,330,150,40);
        c.add(b3);
        b3.addActionListener(this);

        b4= new JButton("Log Out");
        b4.setBounds(375,405,150,40);
        c.add(b4);
        b4.addActionListener(this);

        Time = new JLabel("");
        Time.setBounds(387,105,290,40);
        Time.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        c.add(Time);

        setTitle("Dose4U");
        setBounds(320,100,900,500);
        setLayout(null);
        setVisible(true);

    }

    void clock()
    {
        clc=new Clock(username);
        clc.start();
    }


     Home(int i) {
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            new ViewReminder(username);
        }
        if (e.getSource()==b2)
        {
            new AddReminder(username);
        }
        else if(e.getSource()==b3)
        {
            new EditProfile(username);
        }
        else if(e.getSource()==b4)
        {
            new Login();
            clc.stop();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        //Home home=new Home("admin2");
        //home.clock();

    }
}
