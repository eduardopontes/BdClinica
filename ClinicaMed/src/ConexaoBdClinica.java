//STEP 1. Import required packages

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBdClinica {
    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/bdclinica";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "batata02";

    static String inserts[] = {""
    };
    
    static void popularDatabase(Statement stmt){
        for(int i = 0; i < inserts.length; i++){
            try {
                String sql = inserts[i];
                stmt.execute(sql);
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBdClinica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");

            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            Splash s = new Splash();
            s.setVisible(true);
//            popularDatabase(stmt);
//            String sql = "CREATE DATABASE STUDENTS";
//            stmt.execute(sql);
//            sql = "DROP DATABASE STUDENTS";
//            stmt.executeUpdate(sql);
//            System.out.println("Database created successfully...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }//end main
}//end JDBCExample
