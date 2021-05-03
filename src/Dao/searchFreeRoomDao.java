/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bean.tblRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class searchFreeRoomDao {
    public  static List timPhong(String time , String nameHotel){
          getConnection g = new getConnection();
            Connection c = g.getJDBC();
                 List<tblRoom> list = new ArrayList<>();
          if (nameHotel.equals("*")) {
            String sql = " select DISTINCT  r.id,r.name,r.type,r.displayPrice,r.description from tblroom as r,\n" +
"(\n" +
"select * from tblbooking as book\n" +
"where book.idRoom in\n" +
"(select room.id from tblroom as room \n" +
" \n" +
") and\n" +
"( book.startDate > ? or book.endDate < ?  ) \n" +
") as r1\n" +
"where r1.idRoom = r.id ";
              try {
                   PreparedStatement preparedStatement = c.prepareStatement(sql);
                 preparedStatement.setString(1, time);
                 preparedStatement.setString(2, time);
                   ResultSet resultSet = preparedStatement.executeQuery();
              while (resultSet.next()) {                
                tblRoom r = new tblRoom();
                r.setName(resultSet.getString("name"));
                r.setTypeString(resultSet.getString("type"));
                r.setDisplayPrice(resultSet.getFloat("displayPrice"));
                r.setDescription(resultSet.getString("description"));
                list.add(r);
            }
              } catch (Exception e) {
                  e.printStackTrace();
              }
             
            
        }
          else {
      String sql = " select  DISTINCT  r.id,r.name,r.type,r.displayPrice,r.description from tblroom as r,\n" +
"(\n" +
"select * from tblbooking as book\n" +
"where book.idRoom in\n" +
"(select room.id from tblroom as room \n" +
" where room.idhotel = (\n" +
"select hotel.id from tblhotel as hotel\n" +
"where hotel.name  = ? )\n" +
") and\n" +
"( book.startDate > ? or book.endDate < ?  ) \n" +
") as r1\n" +
"where r1.idRoom = r.id  ";
      
 
        try {
              PreparedStatement preparedStatement = c.prepareStatement(sql);
               preparedStatement.setString(1, nameHotel);
              preparedStatement.setString(2, time);
              preparedStatement.setString(3, time);
              ResultSet resultSet = preparedStatement.executeQuery();
              while (resultSet.next()) {                
                tblRoom r = new tblRoom();
                r.setName(resultSet.getString("name"));
                r.setTypeString(resultSet.getString("type"));
                r.setDisplayPrice(resultSet.getFloat("displayPrice"));
                r.setDescription(resultSet.getString("description"));
                list.add(r);
            }
              
        } catch (Exception e) {
        }
        
          }  
      return  list;
    }
}
