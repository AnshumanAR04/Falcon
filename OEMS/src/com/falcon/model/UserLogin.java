package com.falcon.model;
import java.sql.*;
import java.util.*;
public class UserLogin{

    static final String JDBCDriver = "oracle.jdbc.OracleDriver";
    static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";

    //Enter Database credentials here
    static final String dbuser = "mendax";
    static final String dbpass = "padfoot";

    public static boolean signin( String uname, String upass) {
        boolean rvalue = false;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(URL,dbuser,dbpass);
            String query = "select * from logindetails where erno=? and password=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,uname);
            pstmt.setString(2,upass);
            ResultSet res = pstmt.executeQuery();
            if (!res.isBeforeFirst() )
                rvalue = false;
            else
                rvalue = true;
            res.close();
            pstmt.close();
            con.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return rvalue;
    }
}



