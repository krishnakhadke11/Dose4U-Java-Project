package com.Dose4U;
import java.sql.*;
public class MyJdbc {
    Connection conn;
    Statement st,st1;
    MyJdbc()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dose4u","root","Rootmysql");
            st=conn.createStatement();
            st1=conn.createStatement();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
