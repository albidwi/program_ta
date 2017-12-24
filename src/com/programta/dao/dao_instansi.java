/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.dao;

import com.programta.view.view_instansi;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public interface dao_instansi {
    public void save(view_instansi v)throws SQLException;
    public void update(view_instansi v)throws SQLException;
            public void delete(view_instansi v)throws SQLException;
            public void tabel(view_instansi v)throws SQLException;
            public void kliktabel(view_instansi v)throws SQLException;
}

