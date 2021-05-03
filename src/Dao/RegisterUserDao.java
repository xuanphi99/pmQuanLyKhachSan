/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bean.tblHotel;
import bean.tblUser;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Administrator
 */
public class RegisterUserDao {
        public static int themUser(tblUser user){
        
  
        String sql = "insert into tbluser (fullname, username,password, idCardNumber,idCardType,description,address ) values(?,?,?,?,?,?,?) ";
         getConnection g = new getConnection();
            Connection c = g.getJDBC();
            int flag = -1;
        try {
             PreparedStatement preparedStatement = c.prepareStatement(sql);
           preparedStatement.setString(1, user.getFullname());
           preparedStatement.setString(2, user.getUsername());
           preparedStatement.setString(3, user.getPassword());
           preparedStatement.setString(4, user.getIdCardNumber());
           preparedStatement.setString(5, user.getIdCardType());
           preparedStatement.setString(6, user.getDescription());
           preparedStatement.setString(7, user.getAddress());
         
         flag  =  preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
