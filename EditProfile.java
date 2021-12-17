package com.Dose4U;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class EditProfile extends JFrame implements ActionListener{
    JLabel l_name, l_dob, l_phone, l_emailid, l_city, l_all;
    JTextField tf_name, tf_phone, tf_emailid, tf_city;
    JComboBox <String> cb_date, cb_month, cb_year;
    JCheckBox term;
    JButton b1_edit, b2_back;
    String username;
    MyJdbc profile_connect;
    EditProfile(String userid) {
        this.username = userid;

        Container c = getContentPane();
        c.setBackground(Color.pink);
        c.setLayout(null);

        JLabel title = new JLabel("EDIT PROFILE");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setSize(290, 40);
        title.setLocation(330, 20);
        c.add(title);

        l_name = new JLabel("Name :");
        l_name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l_name.setSize(100, 20);
        l_name.setLocation(258, 100);
        c.add(l_name);

        tf_name = new JTextField();
        tf_name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        tf_name.setSize(285, 20);
        tf_name.setLocation(358, 100);
        c.add(tf_name);

        l_phone = new JLabel("Mobile :");
        l_phone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l_phone.setBounds(258, 140, 100, 20);
        this.add(l_phone);

        tf_phone = new JTextField();
        tf_phone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tf_phone.setBounds(358, 140, 285, 20);
        this.add(tf_phone);

        l_dob = new JLabel("Date of Birth :");
        l_dob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l_dob.setBounds(233, 180, 150, 20);
        c.add(l_dob);

        String[] dates = {"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31"};
        cb_date = new JComboBox<>(dates);
        cb_date.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cb_date.setBounds(363, 180, 75, 20);
        c.add(cb_date);

        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        cb_month = new JComboBox<>(months);
        cb_month.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cb_month.setBounds(443, 180, 120, 20);
        c.add(cb_month);

        String[] years = {"1947","1948","1949","1950","1951", "1952", "1953", "1954","1955", "1956","1957", "1958",
                "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970",
                "1971","1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981","1982","1983",
                "1984","1985", "1986","1987", "1988", "1989", "1990", "1991","1992","1993", "1994","1995", "1996",
                "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
                "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020","2021"};

        cb_year = new JComboBox<>(years);
        cb_year.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        cb_year.setSize(90, 20);
        cb_year.setLocation(563, 180);
        this.add(cb_year);

        l_city = new JLabel("City :");
        l_city.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l_city.setSize(100, 20);
        l_city.setLocation(258, 220);
        c.add(l_city);

        tf_city = new JTextField();
        tf_city.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tf_city.setSize(285, 20);
        tf_city.setLocation(358, 220);
        c.add(tf_city);

        l_emailid = new JLabel("E-mail :");
        l_emailid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l_emailid.setSize(100, 20);
        l_emailid.setLocation(258, 260);
        c.add(l_emailid);

        tf_emailid = new JTextField("user@example.com");
        tf_emailid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        tf_emailid.setSize(285, 20);
        tf_emailid.setLocation(358, 260);
        c.add(tf_emailid);

        term = new JCheckBox("I want to update my details.");
        term.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        term.setSize(400, 20);
        term.setLocation(305, 320);
        c.add(term);

        l_all = new JLabel("");
        l_all.setBounds(305, 365, 500, 20);
        l_all.setForeground(Color.RED);
        l_all.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l_all.setVisible(true);
        c.add(l_all);

        b1_edit = new JButton("Save");
        b1_edit.setBounds(267, 430, 80, 25);
        b1_edit.addActionListener(this);
        this.add(b1_edit);

        b2_back = new JButton("Back");
        b2_back.setBounds(574, 430, 80, 25);
        b2_back.addActionListener(this);
        this.add(b2_back);

        profile_connect = new MyJdbc();
        String input = "select * from login where username= '" +username+ "'";
        try {
            ResultSet rs = profile_connect.st.executeQuery(input);
            if(rs.next()){
                tf_name.setText(rs.getString("name"));
                tf_phone.setText(rs.getString("phone_no"));
                tf_emailid.setText(rs.getString("emailid"));
                tf_city.setText(rs.getString("city"));
                String dob = rs.getString("dob");
                int first_space = dob.indexOf(" ", 1);
                int second_space = dob.indexOf(" ", 3);
                String date = dob.substring(0,first_space);
                String month = dob.substring(first_space+1, second_space);
                String year = dob.substring(second_space+1);
                cb_date.setSelectedItem(date);
                cb_month.setSelectedItem(month);
                cb_year.setSelectedItem(year);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        this.setBounds(320,100,900,500);
        this.setTitle("Dose4U");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1_edit)
        {
            if(tf_name.getText().equals("") || tf_phone.getText().equals("") || tf_emailid.getText().equals("") || tf_city.getText().equals("")){
                l_all.setText("These fields cannot be empty.");
            }
            else if (!term.isSelected())
            {
                l_all.setText("Do you want to update your details ?");
            }
            else if ((term.isSelected() && !tf_name.getText().equals("") &&!tf_phone.getText().equals("") && !tf_emailid.getText().equals("") && !tf_city.getText().equals("")))
            {
                l_all.setVisible(false);
                String name = tf_name.getText();
                String dob = cb_date.getSelectedItem() + " " + cb_month.getSelectedItem() + " " + cb_year.getSelectedItem() ;
                String phone = tf_phone.getText();
                String email =tf_emailid.getText();
                String city = tf_city.getText();
                String input = "update login  set name='" +name+ "', dob='" +dob+ "', emailid='" +email+ "', city='" +city+ "', phone_no='" +phone+ "' where username='" +username+ "'";
                try{
                    profile_connect.st.executeUpdate(input);
                    JOptionPane.showMessageDialog(null, "Your Profile is Edited Successfully");
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
        }
        else if (ae.getSource()==b2_back){
            try{
                profile_connect.conn.close();
                profile_connect.st.close();
            }
            catch (Exception ex){
                System.out.println(ex);
            }
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        //new EditProfile("");
    }
}