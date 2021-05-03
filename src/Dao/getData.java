/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bean.tblBooking;
import bean.tblHotel;
import bean.tblRoom;
import bean.tblUser;
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
public class getData {
         public static List<tblHotel> SelectHotel(){
      List<  tblHotel> list =  new ArrayList<>();
        String sql = "select * from  tblHotel";
         getConnection g = new getConnection();
            Connection c = g.getJDBC();
            int flag = -1;
        try {
             PreparedStatement preparedStatement = c.prepareStatement(sql);    
         ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
                tblHotel hotel = new tblHotel();
                hotel.setId(resultSet.getInt("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setStarLevel(resultSet.getInt("startLevel"));
                hotel.setAddress(resultSet.getString("address"));
                hotel.setDescription(resultSet.getString("description"));
                list.add(hotel);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
         public static List<tblRoom> SelectRoom(){
      List<  tblRoom> list =  new ArrayList<>();
        String sql = "select * from  tblroom";
         getConnection g = new getConnection();
            Connection c = g.getJDBC();
            int flag = -1;
        try {
             PreparedStatement preparedStatement = c.prepareStatement(sql);    
         ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
                tblRoom room = new tblRoom();
                room.setId(resultSet.getInt("id"));
                room.setName(resultSet.getString("name"));
                room.setTypeString(resultSet.getString("type"));
                room.setDisplayPrice(resultSet.getFloat("displayPrice"));
                room.setDescription(resultSet.getString("description"));
                room.setidHotels(resultSet.getInt("idHotel"));             
                list.add(room);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
         public static List<tblUser> SelectUser(){
      List<tblUser> list =  new ArrayList<>();
        String sql = "select * from  tbluser";
         getConnection g = new getConnection();
            Connection c = g.getJDBC();
            int flag = -1;
        try {
             PreparedStatement preparedStatement = c.prepareStatement(sql);    
         ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
                tblUser user = new tblUser();
                user.setId(resultSet.getInt("id"));
                user.setFullname(resultSet.getString("fullname"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAddress(resultSet.getString("address"));
                user.setIdCardNumber(resultSet.getString("idCardNumber"));             
                user.setIdCardType(resultSet.getString("idCardType"));
                user.setDescription(resultSet.getString("description"));
                list.add(user);
            }      
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
         
           public static List<tblBooking> Selectbooking(){
      List<tblBooking> list =  new ArrayList<>();
        String sql = "select * from  tblbooking";
         getConnection g = new getConnection();
            Connection c = g.getJDBC();
           
        try {
             PreparedStatement preparedStatement = c.prepareStatement(sql);    
         ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
                tblBooking b = new tblBooking();
                b.setId(resultSet.getInt("id"));
                b.setIdRoom(resultSet.getInt("idRoom"));
                b.setIdUser(resultSet.getInt("idUser"));
                b.setStartDate(resultSet.getString("startDate"));
                b.setEndDate(resultSet.getString("endDate"));
                b.setPrice(resultSet.getFloat("price"));             
                b.setDescription(resultSet.getString("description"));
                b.setStatus(resultSet.getString("status"));
                list.add(b);
            }      
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
         
}
