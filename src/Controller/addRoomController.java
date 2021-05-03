/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.addHotelDao;
import Dao.addRoomDao;
import bean.tblHotel;
import bean.tblRoom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ViewFrm;

/**
 *
 * @author Administrator
 */
public class addRoomController {
     private ViewFrm vf;
    private tblRoom room;

    public addRoomController(ViewFrm vf) {
        this.vf = vf;
        vf.addRoomSubmitListener(new addRoomListener());
    }
    
        class addRoomListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                room = vf.getRoom();
              
               if (addRoomDao.themPhong(room, room.getidHotels())>0) {
                    vf.showMessage("add Room succesfully!");
                } 
                else {
                    vf.showMessage("Invalid add Room ");
                }
            } catch (Exception ex) {
                vf.showMessage(ex.getStackTrace().toString());
            }
        }
    }
    
}
