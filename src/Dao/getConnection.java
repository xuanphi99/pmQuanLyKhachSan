/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class getConnection {
     public static Connection getJDBC() {
      Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		connection =	DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qlykhachsan?autoReconnect=true&useSSL=false", "root", "xuanphi99ndt2");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
                return  connection;
     }
//     public static void main(String[] args) {  
//          getConnection g = new getConnection();
//          if (g.getJDBC()!=null) {
//              System.out.println("yes");
//          }
//  
//    }
}
