//Fix prepared statments error
import java.sql.*;
import java.util.*;
class Database {

    //JDBC Driver name and URL 
    static final String JDBCDriver = "oracle.jdbc.OracleDriver";
    static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";

    //Database credentials
    static final String username = "mendax";
    static final String password = "padfoot";

    public static void main( String[] args) {
        try {   
            //Initializing JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");
        
            System.out.println("Connecting to Database XE.... ");
            Connection con = DriverManager.getConnection(URL,username,password);
            System.out.println("Enter your statement..");
            //Statement stmt = con.createStatement();
            String query = "insert into students(id,name) values (?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            Scanner scan = new Scanner(System.in);
            //String query = scan.nextLine();
            pstmt.setString(1,scan.next());
            pstmt.setString(2,scan.nextLine());
            ResultSet res = pstmt.executeQuery();
            //pstmt.executeUpdate();

            //Retrieve information from result set
            while(res.next()) {
                int id = res.getInt("id");
                String usr = res.getString("name");

                //Display parsed information
                System.out.println("User ID: " + id + " User Name: " + usr);
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


        
