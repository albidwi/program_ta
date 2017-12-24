/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.dao;

import com.programta.view.view_rumus;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public interface dao_rumus {
    public void save(view_rumus rms) throws SQLException;
    public void update(view_rumus rms) throws SQLException;
    public void delete(view_rumus rms) throws SQLException;
    public void table(view_rumus rms) throws SQLException;
    public void kliktabel(view_rumus rms) throws SQLException;
}
