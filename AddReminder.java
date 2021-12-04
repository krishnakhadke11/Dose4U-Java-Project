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
    JButton addbutton;
    JTextField medtimefieldhour,medtimefieldminute,medtimefieldsecond,ampm;
    JTextField medtextfield;
    String time;
    LinkedList ll1=new LinkedList();
    String username;
AddReminder(LinkedList ll1,String username){
    this.ll1=ll1;
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

    ampm =new JTextField();
    ampm.setBounds(360,190,50,25);
    add(ampm);

//45
    addbutton = new JButton("Add");
    addbutton.setBounds(170,270,80, 20);
    add(addbutton);
    addbutton.addActionListener(this);

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
        time=medtimefieldhour.getText()+":"+medtimefieldminute.getText()+":"+medtimefieldsecond.getText()+" "+ampm.getText().toLowerCase(Locale.ROOT);
        if(e.getSource()==addbutton && !time.equals("hh:mm:ss am/pm") && !medtextfield.getText().equals(""))
        {
            MyJdbc AddReminder_connect=new MyJdbc();
            try {
                 AddReminder_connect.st.executeUpdate("insert into reminder(username,medicine,time) values('" + username + "','" +
                        medtextfield.getText() + "','" + time + "')");
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
                    // ll1.insert(Integer.parseInt(medtimefieldhour.getText()),Integer.parseInt(medtimefieldminute.getText()),Integer.parseInt(medtimefieldsecond.getText()),medtextfield.getText());
            /*
            ll1.insert(medtimefieldhour.getText(),medtextfield.getText());
            ll1.show();
            */
                    //new Home().setVisible(true);
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
