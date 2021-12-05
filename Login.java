package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login implements ActionListener {
    private JFrame f;
    private JLabel l3;
    private JButton b1,b2;
    private JTextField t1;
    private JPasswordField t2;


    Login(){
        f = new JFrame("Dose4U");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("logo4.jpeg"));
        //Krishna
        Image logo1=logo.getImage().getScaledInstance();
        ImageIcon logo2=new ImageIcon(logo1)
        JLabel image = new JLabel(logo2);
        image.setBounds(130, 20,120,120);
        f.add(image);
        */

        JLabel l1 = new JLabel("Username");
        l1.setBounds(100,150,80,25);
        f.add(l1);

         t1 = new JTextField();
        t1.setBounds(100, 180, 180, 25);
        f.add(t1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(100,220,80,25);
        f.add(l2);

        t2 = new JPasswordField();
        t2.setBounds(100, 250, 180, 25);
        f.add(t2);

        l3 = new JLabel("Invalid Username or password");
        l3.setBounds(100,270,180,25);
        l3.setForeground(Color.RED);
        f.add(l3);
        l3.setVisible(false);

        b1 = new JButton("LogIn");
        b1.setBounds(100,300,80, 20);
        f.add(b1);

         b2 = new JButton("SignUp");
        b2.setBounds(200,300,80, 20);
        f.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.setBounds(320,100,900,500);
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            String userid=t1.getText();
            String password=t2.getText();


            MyJdbc login_connect=new MyJdbc();
            try {
                ResultSet rs=login_connect.st.executeQuery("select * from login where username='"+userid+"' and password='"+password+"'");
                if (rs.next())
                {
                   Home home= new Home(userid);
                  home.clock();
                    f.setVisible(false);
                }
                else
                {
                    l3.setVisible(true);
                    // JOptionPane.showMessageDialog(b1,"Invalid Username or password");
                }
                login_connect.st.close();
                login_connect.conn.close();
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==b2)
        {
            new SignUp();
            f.setVisible(false);
        }


    }

    public static void main(String[] args) {
        new Login();
    }
}
