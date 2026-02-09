package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBC {

    // 1. GLOBAL VARIABLES (To hold user data after login)
    public static String username;
    public static String email;
    public static String role;

    // 2. CONNECT TO SQLITE (AND FIX MISSING TABLE)
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); 
            // This creates 'connectionDB8.db' in your project folder
            con = DriverManager.getConnection("jdbc:sqlite:connectionDB8.db"); 
            


            String sql = "CREATE TABLE IF NOT EXISTS Tbl_user ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "username TEXT, "
                    + "email TEXT, "
                    + "password TEXT, "
                    + "role TEXT)";
            
            java.sql.Statement stmt = con.createStatement();
            stmt.execute(sql);
            // ----------------------------------
            
            System.out.println("Connection Successful & Table Checked");
            
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

    // 3. ADD RECORD (For Registration)
    public void addRecord(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }

            pstmt.executeUpdate();
            System.out.println("Record added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding record: " + e.getMessage());
        }
    }
}