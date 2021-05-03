/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bean.tblHotel;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Administrator
 */
public class addHotelDao {
      public static int themKhachsan(tblHotel hotel){
        
        String sql = "insert into tblhotel (name, startLevel,address, description) values(?,?,?,?) ";
         getConnection g = new getConnection();
            Connection c = g.getJDBC();
            int flag = -1;
        try {
            PreparedStatement preparedStatement = c.prepareStatement(sql);
           preparedStatement.setString(1, hotel.getName());
           preparedStatement.setInt(2, hotel.getStarLevel());
           preparedStatement.setString(3, hotel.getAddress());
           preparedStatement.setString(4, hotel.getDescription());
         
         flag  =  preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
