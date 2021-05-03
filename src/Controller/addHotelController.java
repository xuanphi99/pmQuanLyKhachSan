/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.addHotelDao;
import bean.tblHotel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ViewFrm;

/**
 *
 * @author Administrator
 */
public class addHotelController {
    private ViewFrm vf;
    private tblHotel hotel;

    public addHotelController(ViewFrm vf) {
        this.vf = vf;
       vf.addSubmitListener(new addHotelListener());
    }
 
    class addHotelListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                hotel = vf.getHotel();
                if (hotel.getName().equals("") || hotel.getStarLevel()<=0 || hotel.getAddress().equals("") || hotel.getAddress().equals("")) {
                    vf.showMessage("No empyy!");
                }
                else if (addHotelDao.themKhachsan(hotel)>0) {
                    vf.showMessage("add Hotel succesfully!");
                } else {
                    vf.showMessage("Invalid startLevel ");
                }
            } catch (Exception ex) {
                vf.showMessage(ex.getStackTrace().toString());
            }
        }
    }
}

