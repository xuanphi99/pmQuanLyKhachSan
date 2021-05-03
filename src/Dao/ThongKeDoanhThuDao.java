/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bean.tblbill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ThongKeDoanhThuDao {
        
      public static int addBill(tblbill b) {
          
      getConnection g = new getConnection();
            Connection c = g.getJDBC();
            // phai them dk room ===
            changeStatusBook(b.getIdBooking());
        String sql = " INSERT INTO `qlykhachsan`.`tblbill` (`idBooking`, `paymentDate`, `amount`, `paymentType`, `notes`) VALUES (?,?,?,?,?); ";   
            int flag = -1;
           
              try {
                   PreparedStatement preparedStatement = c.prepareStatement(sql);
                  preparedStatement.setInt(1, b.getIdBooking());
                  preparedStatement.setString(2, b.getPaymentDate());
                  preparedStatement.setFloat(3, b.getAmount());
                  preparedStatement.setString(4, b.getPaymentType());
                  preparedStatement.setString(5, b.getNotes());
                
                  flag  =  preparedStatement.executeUpdate();
                     
            } catch (Exception e) {
                e.printStackTrace();
            }
          return flag;
    }
      
      
    public  static  void changeStatusBook(int idBook){
         getConnection g = new getConnection();
            Connection c = g.getJDBC();
            // phai them dk room ===
        String sql = " UPDATE `qlykhachsan`.`tblbooking` SET `status` = ? WHERE (`id` = ?); ";   
            int flag = -1;
           
              try {
                   PreparedStatement preparedStatement = c.prepareStatement(sql);
                  preparedStatement.setString(1, " Đã Thanh Toán" );
                  preparedStatement.setInt(2, idBook);
               
                
                 preparedStatement.executeUpdate();
                     
            } catch (Exception e) {
                e.printStackTrace();
            }
          
    
    }
    
    
    
    public static void main(String[] args) {
        try {
            
       
        for (int i = 14; i <= 42; i++) {
             changeStatusBook(i);
        }
        } catch (Exception e) {
        }
    }
}
