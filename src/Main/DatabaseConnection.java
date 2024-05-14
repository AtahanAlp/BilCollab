/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author emir_mac
 */
public class DatabaseConnection {
    
    public static Connection getConnection() throws SQLException {
       
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "A646138a646138");
    }
}
