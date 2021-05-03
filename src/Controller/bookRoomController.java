/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.addRoomDao;
import Dao.bookRoomDao;
import Dao.getConnection;
import bean.tblBooking;
import bean.tblRoom;
import bean.tblUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import view.ViewFrm;

/**
 *
 * @author Administrator
 */
public class bookRoomController {
    private ViewFrm vf;
    private tblRoom room;
    private tblUser user;
    private tblBooking booking;
    public bookRoomController(ViewFrm vf) {
        this.vf = vf;
         vf.addbtnDatPhUserListener(new addBookingRoomListener());
    }
    
       class addBookingRoomListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                booking = vf.getDatPh();
                
                if (booking.getStartDate().compareTo(booking.getEndDate())>0) {
                     vf.showMessage("Wrong Date !");
                }
                
               else if (bookRoomDao.DatPhong(booking)>0) {
                    vf.showMessage("add Room succesfully!");
                } 
               else if (bookRoomDao.DatPhong(booking) == -2) {
                    vf.showMessage("Phong da co nguoi dat");
                }
               else {
                   vf.showMessage("Dat phong that bai");
               }
            } catch (Exception ex) {
                vf.showMessage("Nhap gia lai");
            }
        }
    } 
    
    

}
