package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Clock extends Thread{
    String username;
    //CONSTRUCTOR
    Clock(String username)
    {
        this.username=username;
    }
    @Override
    public void run() {
        Home home = new Home(2);
        String time;
        while(true) {

            SimpleDateFormat timeformat=new SimpleDateFormat("hh:mm:ss a");
            time=timeformat.format(Calendar.getInstance().getTime());
            home.Time.setText("Time:"+time);
            System.out.println(time);

            try{
                MyJdbc clock_connect=new MyJdbc();
                ResultSet rs=clock_connect.st.executeQuery("select * from reminder where username='"+this.username+"'");
                while (rs.next())
                {
                 String dbtime=rs.getString("time");
                 if(time.equals(dbtime))
                 {
                     Toolkit.getDefaultToolkit().beep();
                     System.out.println("In if statement");
                     JOptionPane.showMessageDialog(null, "Hey time to take:"+rs.getString("medicine"));
                 }
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
       // new Clock();
    }
}
