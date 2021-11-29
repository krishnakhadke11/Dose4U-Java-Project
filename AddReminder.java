package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AddReminder implements ActionListener {
    //static linklist head=null;
    JFrame  f;
    JButton addbutton;
    JTextField medtimefieldhour,medtimefieldminute,medtimefieldsecond;
    JTextField medtextfield;

    LinkedList ll1=new LinkedList();
AddReminder(LinkedList ll1){
    this.ll1=ll1;
      f =new JFrame();
    JLabel medlabel = new JLabel("Add Medicine Name:");
    medlabel.setBounds(70,150,130,25);
    f.add(medlabel);

     medtextfield = new JTextField();
    medtextfield.setBounds(240, 150, 180, 25);
    f.add(medtextfield);

    JLabel medtime = new JLabel("Add Time(hh:mm:ss: am/pm):");
    medtime.setBounds(70,185,160,25);
    f.add(medtime);

     medtimefieldhour = new JTextField();
    medtimefieldhour.setBounds(240, 190, 180, 25);
    f.add(medtimefieldhour);
/*
width of medtimefieldhour is 50
     medtimefieldminute = new JTextField();
    medtimefieldminute.setBounds(300, 190, 50, 25);
    f.add(medtimefieldminute);

     medtimefieldsecond = new JTextField();
    medtimefieldsecond.setBounds(360, 190, 50, 25);
    f.add(medtimefieldsecond);
 */


     addbutton = new JButton("Add");
    addbutton.setBounds(170,245,80, 20);
    f.add(addbutton);
    addbutton.addActionListener(this);

    f.setBounds(550,150,450,400);
    f.setTitle("Add Reminder");
    f.setLayout(null);
    f.setVisible(true);
}
AddReminder(int x)
{

}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addbutton)
        {

           // ll1.insert(Integer.parseInt(medtimefieldhour.getText()),Integer.parseInt(medtimefieldminute.getText()),Integer.parseInt(medtimefieldsecond.getText()),medtextfield.getText());
            ll1.insert(medtimefieldhour.getText(),medtextfield.getText());
            ll1.show();
         //new Home().setVisible(true);
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
              //new AddReminder(ll1);

    }
}
