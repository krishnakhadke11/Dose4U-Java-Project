package com.Dose4U;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class SignUp extends JFrame implements ActionListener
{
    private final JTextField fname;
    private final JTextField user_name;
    private final JTextField password;
 //   private final JTextField std;
    private final JTextField tmno;
    private final JTextField mail;
    private final JComboBox<String> date;
    private final JComboBox<String> month;
    private final JComboBox<String> year;
    private final JTextField tadd;
    private final JCheckBox term;
    private final JButton sub;
    private final JButton reset;
    private final JLabel res;

    SignUp()
    {
        setTitle("Dose4U");
        setBounds(320,100,900,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container c = getContentPane();
        c.setBackground(Color.lightGray);
        c.setLayout(null);

        JLabel title = new JLabel("NEW PATIENT RECORD");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setSize(600, 40);
        title.setLocation(300, 30);
        c.add(title);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        fname = new JTextField("");
        fname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        fname.setSize(250, 20);
        fname.setLocation(200, 100);
        c.add(fname);

        JLabel mno = new JLabel("Mobile");
        mno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 140);
        c.add(mno);
/*
        std = new JTextField();
        std.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        std.setSize(40, 20);
        std.setLocation(200, 140);
        c.add(std);
 */

        tmno = new JTextField(null);
        tmno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tmno.setSize(200, 20);
        tmno.setLocation(250, 140);
        c.add(tmno);

        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        dob.setSize(150, 20);
        dob.setLocation(70, 180);
        c.add(dob);

        String[] dates = {"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31"};
        date = new JComboBox<>(dates);
        date.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        date.setSize(75, 20);
        date.setLocation(200, 180);
        c.add(date);

        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};

        month = new JComboBox<>(months);
        month.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        month.setSize(120, 20);
        month.setLocation(280, 180);
        c.add(month);

        String[] years = {"1947","1948","1949","1950","1951", "1952", "1953", "1954","1955",
                "1956","1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970",
                "1971","1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981","1982","1983","1984","1985",
                "1986","1987", "1988", "1989", "1990", "1991","1992","1993", "1994","1995", "1996", "1997", "1998",
                "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010",
                "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020","2021"};

        year = new JComboBox<>(years);
        year.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        year.setSize(90, 20);
        year.setLocation(400, 180);
        c.add(year);

        JLabel add = new JLabel("City");
        add.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 220);
        c.add(add);

        tadd = new JTextField();
        tadd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tadd.setSize(250, 20);
        tadd.setLocation(200, 220);
        c.add(tadd);

        JLabel Email = new JLabel("E-mail");
        Email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Email.setSize(100, 20);
        Email.setLocation(100, 260);
        c.add(Email);

        mail = new JTextField("user@example.com");
        mail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        mail.setSize(250, 20);
        mail.setLocation(200, 260);
        c.add(mail);

        term = new JCheckBox("I have filled all the details.");
        term.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        term.setSize(400, 20);
        term.setLocation(85, 300);
        c.add(term);

        sub = new JButton("Sign up");
        sub.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(100, 340);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 340);
        reset.addActionListener(this);
        c.add(reset);



        res = new JLabel("");
        res.setFont(new Font("Times New Roman", Font.BOLD, 20));
        res.setSize(500, 25);
        res.setLocation(100, 380);
        c.add(res);



        JLabel user = new JLabel("Username");
        user.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        user.setSize(100, 25);
        user.setLocation(500, 100);
        c.add(user);

        user_name = new JTextField();
        user_name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        user_name.setSize(250, 20);
        user_name.setLocation(600, 100);
        c.add(user_name);

        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pass.setSize(100, 25);
        pass.setLocation(500, 140);
        c.add(pass);

        password = new JPasswordField();
        password.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        password.setSize(250, 20);
        password.setLocation(600, 140);
        c.add(password);

        c.setVisible(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub)
        {
            if (term.isSelected() && !fname.getText().equals("") &&!tmno.getText().equals("") && !mail.getText().equals("") && !tadd.getText().equals("") && !user_name.getText().equals("") && !password.getText().equals(""))
            {
                res.setText("Registration Successful.");
                String name = fname.getText();
                String phone = tmno.getText();
                String username = user_name.getText();
                String password1 = password.getText();
                String dob = date.getSelectedItem() + " " + month.getSelectedItem() + " " + year.getSelectedItem() ;
                String city = tadd.getText();
                String email = mail.getText();

                MyJdbc signup_connect = new MyJdbc();
                String input = "insert into login values ('"+username+"','"+password1+"','"+name+"','"+dob+"','"+email+"','"+city+"','"+phone+"')";
                try{
                    signup_connect.st.executeUpdate(input);
                    JOptionPane.showMessageDialog(null, "You Signed Up Succesfully");
                    this.setVisible(false);
                    new Login();
                    signup_connect.conn.close();
                    signup_connect.st.close();
                }catch(Exception ae){
                    System.out.println(ae);
                }

            }
            else {
                res.setText("Please enter all details!");
            }
        }
        else if (e.getSource() == reset) {
            String def = "";
            String first = "Enter First Name";
            fname.setText(first);
            tadd.setText(def);
            //std.setText(def);
            tmno.setText(def);
            res.setText(def);
            mail.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            user_name.setText(def);
            password.setText(def);
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}