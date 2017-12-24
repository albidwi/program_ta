/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.daoImp;

import com.programta.controller.loginc;
import com.programta.dao.dao_login;
import com.programta.menu.menu;
import com.programta.view.view_login;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class loginimpl implements dao_login{
loginc l = new loginc();
    @Override
    public void login(view_login login) throws SQLException {
        String username = login.txtusername.getText();
        String password = login.txtpassword.getText();
        String b = l.getlogin(username, password);
        System.out.println(b);
        if(b!=null){   
        menu a = new menu();
        login.dispose();
        a.show();
        }
        else{
        JOptionPane.showMessageDialog (null, "usernmae atau password salah", "Title", JOptionPane.INFORMATION_MESSAGE);
        }
        
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void batal() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
