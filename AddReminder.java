package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class AddReminder extends JFrame implements ActionListener {
    JLabel l1;
    JButton addbutton,backbutton;
    JTextField medtimefieldhour,medtimefieldminute,medtimefieldsecond, medtextfield;

    JComboBox <String> ampm,HrCb,MinCb,SecCb;
    String time;
    String username;
AddReminder(String username){
      this.username=username;

    Container c = getContentPane();
    c.setBackground(Color.pink);
    c.setLayout(null);

    JLabel title = new JLabel("ADD A REMINDER");
    title.setFont(new Font("Times New Roman", Font.BOLD, 30));
    title.setSize(275, 40);
    title.setLocation(313, 30);
    c.add(title);

    JLabel medlabel = new JLabel("Add Medicine Name:");
    medlabel.setBounds(230,150,180,25);
    medlabel.setFont(new Font("Times New Roman", Font.PLAIN,20 ));
    c.add(medlabel);

    medtextfield = new JTextField();
    medtextfield.setBounds(420, 150, 250, 25);
    c.add(medtextfield);

    JLabel medtime = new JLabel("Add Time:");
    medtime.setBounds(230,220,150,25);
    medtime.setFont(new Font("Times New Roman", Font.PLAIN,20 ));
    c.add(medtime);

    String Hr[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
    HrCb=new JComboBox(Hr);
    HrCb.setBounds(420, 220, 50, 25);
    c.add(HrCb);
    /*
    medtimefieldhour = new JTextField();
    medtimefieldhour.setBounds(420, 220, 50, 25);
    c.add(medtimefieldhour);
     */
    String[] MinSec= new String[61];
    for(int i=0;i<=9;i++)
    {
        MinSec[i]="0"+i;
    }
    for(int i = 10; i<61; i++)
    {
        MinSec[i]= String.valueOf(i);
    }
    MinCb=new JComboBox(MinSec);
    MinCb.setBounds(480, 220, 50, 25);
    c.add(MinCb);

    /*
    medtimefieldminute = new JTextField();
    medtimefieldminute.setBounds(480, 220, 50, 25);
    c.add(medtimefieldminute);
     */
    SecCb=new JComboBox(MinSec);
    SecCb.setBounds(540, 220, 50, 25);
    c.add(SecCb);
/*
    medtimefieldsecond = new JTextField();
    medtimefieldsecond.setBounds(540, 220, 50, 25);
    c.add(medtimefieldsecond);
 */

    String[] ap = {"am", "pm"};
    ampm = new JComboBox<>(ap);
    ampm.setBounds(600, 220, 70, 25);
    c.add(ampm);


    addbutton = new JButton("Add");
    addbutton.setBounds(280,290,80, 20);
    addbutton.addActionListener(this);
    c.add(addbutton);

    backbutton = new JButton("Back");
    backbutton.setBounds(540,290,80, 20);
    backbutton.addActionListener(this);
    c.add(backbutton);


    l1 = new JLabel("Please fill all the details.");
    l1.setBounds(345,360,215,25);
    l1.setForeground(Color.RED);
    l1.setFont(new Font("Times New Roman", Font.BOLD,20 ));
    c.add(l1);
    l1.setVisible(false);

    setBounds(320,100,900,500);
    setTitle("Dose4U");
    setLayout(null);
    setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        time=HrCb.getSelectedItem()+":"+MinCb.getSelectedItem()+":"+SecCb.getSelectedItem()+" "+ampm.getSelectedItem();
        if(e.getSource()==addbutton && !medtextfield.getText().equals(""))
        {
            MyJdbc AddReminder_connect=new MyJdbc();
            try {
                 AddReminder_connect.st.executeUpdate("insert into reminder(username,medicine,time) values('" + username + "','" +
                        medtextfield.getText() + "','" + time + "')");
                 AddReminder_connect.st.close();
                 AddReminder_connect.conn.close();
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
            this.setVisible(false);
        }
        else if (e.getSource()==backbutton)
        {
            this.setVisible(false);
        }
        else
        {
            System.out.println(time);
            l1.setVisible(true);
        }
    }

    public static void main(String[] args) {
              new AddReminder("admin2");

    }
}
