import java.sql.*;
import java.util.*;
class Database {

    static final String JDBCDriver = "oracle.jdbc.OracleDriver";
    static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";

    //Enter Database credentials here
    static final String dbuser = "mendax";
    static final String dbpass = "padfoot";

    public static void main( String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            //System.out.println("Connecting to Database XE.... ");
            Connection con = DriverManager.getConnection(URL,dbuser,dbpass);
            String query = "select * from logindetails where erno=? and password=?";
            //String query = "select * from logindetails where erno=? and name=? and password=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            /*System.out.println("Enter id, name: ");
            Scanner scan = new Scanner(System.in);
            pstmt.setString(1,scan.next());
            scan.nextLine();
            pstmt.setString(2,scan.nextLine());
            int rows = pstmt.executeUpdate();*/
            pstmt.setString(1,"141356");
            pstmt.setString(2,"newpass");
            /*pstmt.close()
            Statement stmt = con.createStatement();*/
            ResultSet res = pstmt.executeQuery();
            if (!res.isBeforeFirst() ) {
                System.out.println("No data");
            }
            //Retrieve information from result set
            while(res.next()) {
                String id = res.getString(1);
                String usr = res.getString(2);
                String pass = res.getString(3);

                //Display parsed information
                System.out.println("User ID: " + id + " User Name: " + usr + pass);
            }
            res.close();
            pstmt.close();
            con.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}



