/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.dao;

import com.programta.view.view_pekerja;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public interface dao_pekerja {
     public void save(view_pekerja pkrj) throws SQLException;
    public void update(view_pekerja pkrj) throws SQLException;
    public void delete(view_pekerja pkrj) throws SQLException;
    public void table(view_pekerja pkrj) throws SQLException;
    public void table2(view_pekerja pkrj) throws SQLException;
    public void kliktabel(view_pekerja pkrj) throws SQLException;
     public void kliktabel2(view_pekerja pkrj) throws SQLException;
    public void getcombo(view_pekerja pkrj) throws SQLException;
}
