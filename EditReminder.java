package com.Dose4U;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EditReminder extends JFrame implements ActionListener{
    JTable table;
    JScrollPane sp;
    JButton b1_search, b2_update, b3_delete, b4_cancel;
    JLabel topl1_sr, topl2_med, topl3_time, l1_sr, l2_med, l3_time;
    JComboBox <String> ampm;
    JTextField tf1_sr, tf2_med, medtimefieldhour, medtimefieldminute, medtimefieldsecond;
    String username;
    int flag = 0;

    EditReminder(String userid){
        this.username = userid;

        table = new JTable();
        table.setBounds(50, 50, 590, 280);
        add(table);

//        sp = new JScrollPane(table);
//        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        add(sp);

        l1_sr = new JLabel("Sr. No.");
        l1_sr.setBounds(60, 390, 60, 20);
        add(l1_sr);

        l2_med = new JLabel("Medicine");
        l2_med.setBounds(290, 390, 60, 20);
        add(l2_med);

        l3_time = new JLabel("Time");
        l3_time.setBounds(530, 390, 60, 20);
        add(l3_time);

        topl1_sr = new JLabel("Sr. No.");
        topl1_sr.setBounds(130, 30, 60, 20);
        add(topl1_sr);

        topl2_med = new JLabel("Medicine");
        topl2_med.setBounds(320, 30, 60, 20);
        add(topl2_med);

        topl3_time = new JLabel("Time");
        topl3_time.setBounds(530, 30, 60, 20);
        add(topl3_time);

        tf1_sr = new JTextField();
        tf1_sr.setBounds(60, 360, 40, 25);
        add(tf1_sr);

        tf2_med = new JTextField();
        tf2_med.setBounds(220, 360, 200, 25);
        add(tf2_med);

        medtimefieldhour = new JTextField();
        medtimefieldhour.setBounds(455, 360, 40, 25);
        add(medtimefieldhour);

        medtimefieldminute = new JTextField();
        medtimefieldminute.setBounds(500, 360, 40, 25);
        add(medtimefieldminute);

        medtimefieldsecond = new JTextField();
        medtimefieldsecond.setBounds(545, 360, 40, 25);
        add(medtimefieldsecond);

        String[] ap = {"am", "pm"};
        ampm = new JComboBox<>(ap);
        ampm.setBounds(590, 360, 50, 25);
        add(ampm);

        b1_search = new JButton("Search");
        b1_search.setBounds(110, 360, 80, 25);
        b1_search.addActionListener(this);
        add(b1_search);

        b2_update = new JButton("Update");
        b2_update.setBounds(200, 450, 100, 25);
        b2_update.addActionListener(this);
        add(b2_update);

        b3_delete = new JButton("Delete");
        b3_delete.setBounds(320, 450, 100, 25);
        b3_delete.addActionListener(this);
        add(b3_delete);

        b4_cancel = new JButton("Cancel");
        b4_cancel.setBounds(440, 450, 100, 25);
        b4_cancel.addActionListener(this);
        add(b4_cancel);

        MyJdbc edit_connect = new MyJdbc();
        String input = "select sr_no, medicine, time from reminder where username = '" +username+ "'";
        try {
            ResultSet rs = edit_connect.st.executeQuery(input);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            edit_connect.conn.close();
            edit_connect.st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        this.setBounds(415,100,700,550);
        this.setTitle("Edit Reminder");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        int num;
        if(e.getSource()==b1_search){
            num = Integer.parseInt(tf1_sr.getText());
            MyJdbc search_connect = new MyJdbc();
            String input = "select * from reminder where sr_no = " + num;
            try{
                ResultSet rs = search_connect.st.executeQuery(input);
                while (rs.next()){
                    int sr = rs.getInt("sr_no");
                    if(num == sr) {
                        String med = rs.getString("medicine");
                        String time = rs.getString("time");
                        String hr = time.substring(0,2);
                        String min = time.substring(3,5);
                        String sec = time.substring(6,8);
                        String ap = time.substring(9,11);
                        tf2_med.setText(med);
                        medtimefieldhour.setText(hr);
                        medtimefieldminute.setText(min);
                        medtimefieldsecond.setText(sec);
                        ampm.setSelectedItem(ap);
                    }
                }
                search_connect.st.close();
                search_connect.conn.close();
            }
            catch(Exception ee){
                System.out.println(ee);
            }
            flag = 1;
        }

        if(e.getSource()==b2_update){
            if (flag == 1){
                num = Integer.parseInt(tf1_sr.getText());
                String time = medtimefieldhour.getText()+":"+medtimefieldminute.getText()+":"+medtimefieldsecond.getText()+" "+ampm.getSelectedItem();
                String med = tf2_med.getText();
                MyJdbc update_connect = new MyJdbc();
                String input = "update reminder set medicine = '" +med+ "', time = '" +time+ "' where sr_no =" +num;
                try{
                    update_connect.st.executeUpdate(input);
                    ResultSet rs = update_connect.st.executeQuery("select sr_no, medicine, time from reminder where username = '" +username+ "'");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    JOptionPane.showMessageDialog(null, "Selected Reminder is Updated Successfully");
                    update_connect.st.close();
                    update_connect.conn.close();
                }
                catch (Exception ex){
                    System.out.println(ex);
                }

            }
            else if(flag == 0){
                JOptionPane.showMessageDialog(null, "Please Select a Reminder to Edit");
            }
        }

        if(e.getSource()==b3_delete){
            if(flag == 1){
                num = Integer.parseInt(tf1_sr.getText());
                MyJdbc delete_connect = new MyJdbc();
                String input = "delete from reminder where sr_no = " +num;
                String input2 = "select sr_no, medicine, time from reminder where username = '" +username+ "'";
                try{
                    delete_connect.st.executeUpdate(input);
                    JOptionPane.showMessageDialog(null, "Selected Reminder is Deleted Successfully");
                    tf1_sr.setText("");
                    tf2_med.setText("");
                    medtimefieldhour.setText("");
                    medtimefieldminute.setText("");
                    medtimefieldsecond.setText("");
                    ampm.setSelectedItem("am");
                    ResultSet rs = delete_connect.st.executeQuery(input2);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    delete_connect.conn.close();
                    delete_connect.conn.close();
                }
                catch (Exception ed){
                    System.out.println(ed);
                }
            }
            else if(flag == 0){
                JOptionPane.showMessageDialog(null, "Please Select a Reminder to delete");
            }
        }

        if(e.getSource()==b4_cancel){
            new ViewReminder(username);
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        //new EditReminder("hi");
    }
}