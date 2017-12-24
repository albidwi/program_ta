/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.dao;

import com.programta.view.view_login;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public interface dao_login {
    public void login(view_login login) throws SQLException;
    public void batal()throws SQLException;
}
