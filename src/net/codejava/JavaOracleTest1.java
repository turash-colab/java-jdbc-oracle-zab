package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.Statement;
import java.sql.ResultSet;

public class JavaOracleTest1 {

	public static void main(String[] args) {
		Statement stmt;
		ResultSet rset;
		String query;
		String sqlString;

		// TODO Auto-generated method stub
		Connection conn1 = null; 
		//Connection conn2 = null; 
        try {
        	//START working
        	//String dbURL1 = "jdbc:oracle:thin:turash/ttc@localhost:1521:orcl";
        	//END working
        	//not working strings: 
        	// 'jdbc:oracle:thin:turash/ttc@testtns'
        	String dbURL1 = "jdbc:oracle:thin:turash/ttc@localhost:1521:orcl";
        	conn1 = DriverManager.getConnection(dbURL1);
        	//conn1 = DriverManager.getConnection("jdbc:oracle:thin:@prod_db?TNS_ADMIN=/work/tns/");
             if (conn1 != null) {
                 System.out.println("Succefully connected!");
             }
     		stmt = conn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            query = "SELECT * FROM Xusers";
            System.out.println("\nExecuting query: " + query);
            rset = stmt.executeQuery(query); 
            System.out.println(rset);
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}

}
