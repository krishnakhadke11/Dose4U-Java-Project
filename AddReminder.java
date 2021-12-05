package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class AddReminder extends JFrame implements ActionListener {
    //static linklist head=null;
    JFrame  f;
    JLabel l1;
    JButton addbutton,backbutton;
    JTextField medtimefieldhour,medtimefieldminute,medtimefieldsecond, medtextfield;
    JComboBox <String> ampm;
    String time;
    String username;
AddReminder(String username){
      this.username=username;
    JLabel medlabel = new JLabel("Add Medicine Name:");
    medlabel.setBounds(30,150,130,25);
    add(medlabel);

     medtextfield = new JTextField();
     medtextfield.setBounds(180, 150, 180, 25);
     add(medtextfield);

    JLabel medtime = new JLabel("Add Time:");
    medtime.setBounds(30,190,160,25);
    add(medtime);


     medtimefieldhour = new JTextField();
    medtimefieldhour.setBounds(180, 190, 50, 25);
    add(medtimefieldhour);


     medtimefieldminute = new JTextField();
    medtimefieldminute.setBounds(240, 190, 50, 25);
    add(medtimefieldminute);

     medtimefieldsecond = new JTextField();
    medtimefieldsecond.setBounds(300, 190, 50, 25);
    add(medtimefieldsecond);

    String[] ap = {"am", "pm"};
    ampm = new JComboBox<>(ap);
    ampm.setBounds(360, 190, 50, 25);
    add(ampm);


    addbutton = new JButton("Add");
    addbutton.setBounds(170,245,80, 20);
    addbutton.addActionListener(this);
    add(addbutton);


    backbutton = new JButton("Back");
    backbutton.setBounds(300,245,80, 20);
    backbutton.addActionListener(this);
    add(backbutton);


    l1 = new JLabel("Please fill all the details");
    l1.setBounds(135,245,180,25);
    l1.setForeground(Color.RED);
    add(l1);
    l1.setVisible(false);

    setBounds(550,150,450,400);
    setTitle("Add Reminder");
    setLayout(null);
    setVisible(true);
}
AddReminder(int x)
{

}

    @Override
    public void actionPerformed(ActionEvent e) {
        time=medtimefieldhour.getText()+":"+medtimefieldminute.getText()+":"+medtimefieldsecond.getText()+" "+ampm.getSelectedItem();
        if(e.getSource()==addbutton && !time.equals("") && !medtextfield.getText().equals(""))
        {
            MyJdbc AddReminder_connect=new MyJdbc();
            try {
                 AddReminder_connect.st.executeUpdate("insert into reminder(username,medicine,time) values('" + username + "','" +
                        medtextfield.getText() + "','" + time + "')");
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

                    new Home(username).setVisible(true);
                    this.setVisible(false);
        }
        else if (e.getSource()==backbutton)
        {
            new Home(username);
            this.setVisible(false);
        }
        else
        {
            System.out.println(time);
            l1.setVisible(true);
        }
    }

    public static void main(String[] args) {
              //new AddReminder(ll1);

    }
}
