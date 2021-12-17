package com.Dose4U;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login implements ActionListener {
    private JFrame f;
    private JLabel l3,l4;
    private JButton b1,b2;
    private JTextField t1;
    private JPasswordField t2;


    Login(){
        f = new JFrame("Dose4U");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container c = f.getContentPane();
        c.setBackground(Color.PINK);
        c.setLayout(null);

        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("com/Dose4U/LogoDose4u.jpeg"));
        Image logo2  = logo.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon final_logo = new ImageIcon(logo2);
        JLabel image = new JLabel(final_logo);
        image.setBounds(350, 10,500,450);
        f.add(image);

        /*
        JLabel title = new JLabel("DOSE4U : Medicine Reminders");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setSize(600, 40);
        title.setLocation(250, 40);
        c.add(title);
         */

        JLabel l1 = new JLabel("Username :");
        l1.setBounds(100,150,180,25);
        l1.setFont(new Font("Times New Roman", Font.BOLD,20 ));
        c.add(l1);

         t1 = new JTextField();
        t1.setBounds(100, 180, 180, 25);
        c.add(t1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(100,220,180,25);
        l2.setFont(new Font("Times New Roman", Font.BOLD,20 ));
        c.add(l2);

        t2 = new JPasswordField();
        t2.setBounds(100, 250, 180, 25);
        c.add(t2);

        l3 = new JLabel("Invalid Username or password ! ");
        l3.setBounds(95,350,210,25);
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        l3.setForeground(Color.RED);
        c.add(l3);
        l3.setVisible(false);

        l4 = new JLabel("Fields cannot be empty ! ");
        l4.setBounds(100,350,210,25);
        l4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        l4.setForeground(Color.RED);
        c.add(l4);
        l4.setVisible(false);

        b1 = new JButton("Login");
        b1.setBounds(100,300,80, 20);
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c.add(b1);

        b2 = new JButton("Sign Up");
        b2.setBounds(200,300,83, 20);
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c.add(b2);

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
                else if (t1.getText().equals("") || t2.getText().equals(""))
                {
                    l4.setVisible(true);
                    l3.setVisible(false);
                }
                else
                {
                    l4.setVisible(false);
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
