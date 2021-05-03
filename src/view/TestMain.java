/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.RegisterUserController;
import Controller.addHotelController;
import Controller.addRoomController;
import Controller.bookRoomController;
import bean.tblHotel;

/**
 *
 * @author Administrator
 */
public class TestMain {
   

   
    public static void main(String[] args) {
         ViewFrm vf  = new ViewFrm();
         addHotelController controller = new addHotelController(vf);
        addRoomController roomController = new addRoomController(vf);
        RegisterUserController registerUserController = new RegisterUserController(vf);
        bookRoomController bController = new bookRoomController(vf);
         vf.setLocationRelativeTo(null);
        vf.setVisible(true);               
    }
    
}
