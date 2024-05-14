/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.*;
/**
 *
 * @author emir_mac
 */
public class DatabaseConnection {
    
    public static Connection getConnection() throws SQLException {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bilCollab", "root", "A646138a646138");
    }
    
    public static void close(Connection connection, Statement st, ResultSet result){
        
        try{
            
            if(result != null){
                result.close();
            }
            if(st != null){
                st.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        catch(SQLException se){
            se.printStackTrace();
        }
    }
}
