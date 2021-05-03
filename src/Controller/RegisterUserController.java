/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.RegisterUserDao;
import Dao.addRoomDao;
import bean.tblRoom;
import bean.tblUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ViewFrm;

/**
 *
 * @author Administrator
 */
public class RegisterUserController {
      private ViewFrm vf;
    private tblUser user;

    public RegisterUserController(ViewFrm vf) {
        this.vf = vf;
        vf.addbtnAddUserListener(new RegisterUserListener());
    }
    
      class RegisterUserListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                user = vf.getUser();
                if (RegisterUserDao.themUser(user)>0) {
                    vf.showMessage("add user succesfully!");
                } 
                else {
                    vf.showMessage("Invalid add User ");
                }
            } catch (Exception ex) {
                vf.showMessage(ex.getStackTrace().toString());
            }
        }
    } 
    
}
