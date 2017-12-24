/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.dao;

import com.programta.view.view_evaluasi;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public interface dao_evaluasi {
    public void save (view_evaluasi e) throws SQLException;
    public void edit (view_evaluasi e) throws SQLException;
    public void delete (view_evaluasi e) throws SQLException;
    public void tampil (view_evaluasi e) throws SQLException;
    public void kliktabel(view_evaluasi e) throws SQLException;
    public void hitung (view_evaluasi e) throws SQLException;
    
}
