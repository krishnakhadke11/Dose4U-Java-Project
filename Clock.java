package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
public class Clock extends Thread{
    LinkedList ll1=new LinkedList();
    String username;
    //CONSTRUCTOR
    Clock(LinkedList ll1,String username)
    {
        this.ll1=ll1;
        this.username=username;
    }
    @Override
    public void run() {
        Home home = new Home(2);
        String time;
        while(true) {
            node temp= ll1.head;
            /*
            Calendar cal = new GregorianCalendar();
            int Hour = cal.get(Calendar.HOUR);
            int Minute = cal.get(Calendar.MINUTE);
            int Second = cal.get(Calendar.SECOND);
            int am_pm1 = cal.get(Calendar.AM_PM);
            String am_pm2 = null;
            if (am_pm1 == 0) {
                am_pm2 = "AM";
            } else {
                am_pm2 = "PM";
            }
            home.Time.setText("Time"+":-" + Hour + ":" + Minute + ":" + " " + Second + " " + am_pm2);
            */
            SimpleDateFormat timeformat=new SimpleDateFormat("hh:mm:ss a");
            time=timeformat.format(Calendar.getInstance().getTime());
            home.Time.setText("Time:"+time);
            System.out.println(time);
            /*
            if(temp!=null) {
                //System.out.println("In if statement");
                ll1.show();
                while (temp != null) {
                    if (Hour == temp.hour && Minute == temp.minute && Second == temp.second) {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println("In if statement");
                        JOptionPane.showMessageDialog(null, "Hey time to take:"+temp.medicine);
                    }
                    temp = temp.next;
                }
            }

             */
            /* //Working code
            if(temp!=null) {
                //System.out.println("In if statement");
                ll1.show();
                while (temp != null) {
                    if (time.equals(temp.time)) {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println("In if statement");
                        JOptionPane.showMessageDialog(null, "Hey time to take:"+temp.medicine);
                    }
                    temp = temp.next;
                }
            }
            */
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
