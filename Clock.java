package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Clock extends Thread{
    String username;
    MyJdbc clock_connect=new MyJdbc();
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
                ResultSet rs=clock_connect.st.executeQuery("select * from reminder where username='"+this.username+"'");
                ResultSet rs1=clock_connect.st1.executeQuery("select emailid from login where username='"+this.username+"'");
                while (rs.next())
                {
                 String dbtime=rs.getString("time");
                 if(time.equals(dbtime))
                 {
                     if(rs1.next()) {
                         Toolkit.getDefaultToolkit().beep();
                         JOptionPane.showMessageDialog(null, "Hey ! \nIt's time for : " + rs.getString("medicine"));
                         System.out.println("Medicine Time");
                        Email mail=new Email();
                        mail.send("hiptriger4612@gmail.com","joftkiuulgcudlpq",rs1.getString("emailid"),"Dose Reminder","heY!\nDose4U here! Time to take:"+rs.getString("medicine"));
                     }
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
