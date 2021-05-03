/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bean.tblRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Administrator
 */
public class addRoomDao {
       public static int themPhong(tblRoom room , int idHotel){
        
        String sql = "insert into tblroom (name, type,displayPrice, description,idHotel) values(?,?,?,?,?) ";
         getConnection g = new getConnection();
            Connection c = g.getJDBC();
            int flag = -1;
        try {
             PreparedStatement preparedStatement = c.prepareStatement(sql);
           preparedStatement.setString(1, room.getName());
           preparedStatement.setString(2, room.getTypeString());
           preparedStatement.setFloat(3, room.getDisplayPrice());
           preparedStatement.setString(4, room.getDescription());
           preparedStatement.setInt(5, idHotel);
         flag  =  preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
