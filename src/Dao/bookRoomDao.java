/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bean.tblBooking;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Administrator
 */
public class bookRoomDao {
        public static int DatPhong(tblBooking booking ){
        
            
            if (checkBooking(booking) == false) {
                return  -2;
            }
            else {
                System.out.println("hihi");
        String sql = "insert into tblbooking (startDate, endDate,price, description,idRoom,idUser,status) values(?,?,?,?,?,?,?) ";
         getConnection g = new getConnection();
            Connection c = g.getJDBC();
            int flag = -1;
        try {
             PreparedStatement preparedStatement = c.prepareStatement(sql);
            String  startDate = booking.getStartDate();
            
         String  endDate = booking.getEndDate();
 //   java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            
     
           preparedStatement.setString(1, startDate);
           preparedStatement.setString(2, endDate);
           preparedStatement.setFloat(3, booking.getPrice());
           preparedStatement.setString(4, booking.getDescription());
           preparedStatement.setInt(5, booking.getIdRoom());
           preparedStatement.setInt(6, booking.getIdUser());
           preparedStatement.setString(7, "Chưa Thanh Toán");
           flag  =  preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
            }
    }

        public static boolean checkBooking(tblBooking booking) {
            System.out.println("Nhay vao dya");
      getConnection g = new getConnection();
            Connection c = g.getJDBC();
        String sql = " select * from tblbooking as b\n" +
"where b.idRoom =? and (\n" +
"( b.startDate < ? and  b.endDate <=?) \n" +
"or \n" +
"( b.startDate >= ? and  b.endDate > ?) \n" +
") ";
            List<Integer> list = new ArrayList<>();
              try {
                  PreparedStatement preparedStatement = c.prepareStatement(sql);
                  preparedStatement.setString(1, String.valueOf(booking.getIdRoom()));
                  preparedStatement.setString(2, booking.getStartDate());
                   preparedStatement.setString(3, booking.getStartDate());
                    preparedStatement.setString(4, booking.getEndDate());
                     preparedStatement.setString(5, booking.getEndDate());
               ResultSet resultSet1 = preparedStatement.executeQuery(); 
                     while (resultSet1.next()) {
                        list.add(resultSet1.getInt("id"));
                         System.out.println();
                      
                  }
                     
            } catch (Exception e) {
                e.printStackTrace();
            }
              System.out.println(list.size());
            if (getSumBooking(booking.getIdRoom()) == list.size() || list.size()==0) {
                
                return  true;
            }
            else
                return  false;
            
    }
        
        
         public static int getSumBooking(int idroom) {
          
      getConnection g = new getConnection();
            Connection c = g.getJDBC();
            // phai them dk room ===
        String sql = " SELECT count(*) FROM qlykhachsan.tblbooking where idRoom = ? ; ";   
          
            List<Integer> list = new ArrayList<>();
              try {
                   PreparedStatement preparedStatement = c.prepareStatement(sql);
                  preparedStatement.setInt(1, idroom);
                   ResultSet resultSet1 = preparedStatement.executeQuery(); 
//                    Statement stmt =    c.createStatement();
//                 ResultSet resultSet1 = stmt.executeQuery(sql); 
                 resultSet1.next();
                return  resultSet1.getInt("count(*)");
                     
            } catch (Exception e) {
                e.printStackTrace();
            }
          return 0;
    }    

//         public static void main(String[] args) {
//             System.out.println(getSumBooking(1));
//    }
//         
}
