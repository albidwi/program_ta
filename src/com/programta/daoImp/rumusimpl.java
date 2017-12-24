/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.daoImp;

import com.programta.controller.rumusc;
import com.programta.dao.dao_rumus;
import com.programta.entity.Rumus;
import com.programta.view.view_rumus;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class rumusimpl implements dao_rumus{
    rumusc c = new rumusc();
    Rumus r = new Rumus();
    String header[] ={"Kode Rumus", "Nama Rumus", "r1","r2","tanda"};
    @Override
    public void save(view_rumus rms) throws SQLException {
String kd_rms;
String nm_rms;
String r1; 
String r2;
String tanda;
try{
kd_rms =rms.txtkd_rumus.getText();
nm_rms = rms.txtnama_rumus.getText();
r1 = rms.txtr1.getText();
r2 = rms.txtr2.getText();
tanda = rms.txttanda.getText();

r.setKdRumus(Integer.parseInt(kd_rms));
r.setNamaRumus(nm_rms);
r.setR1(r1);
r.setR2(r2);
r.setTanda(tanda);
   c.Update(r);
        table(rms);

}catch (Exception e){}
    }

    

    
    @Override
    public void update(view_rumus rms) throws SQLException {
    String kd_rms;
String nm_rms;
String r1; 
String r2;
String tanda;
try{
kd_rms =rms.txtkd_rumus.getText();
nm_rms = rms.txtnama_rumus.getText();
r1 = rms.txtr1.getText();
r2 = rms.txtr2.getText();
tanda = rms.txttanda.getText();

r.setKdRumus(Integer.parseInt(kd_rms));
r.setNamaRumus(nm_rms);
r.setR1(r1);
r.setR2(r2);
r.setTanda(tanda);
   c.Update(r);
        table(rms);

}catch (Exception e){}
    }

    @Override
    public void delete(view_rumus rms) throws SQLException {
   String kd_rms;
kd_rms =rms.txtkd_rumus.getText();
        c.delete(kd_rms);
        table(rms);
    }

    @Override
    public void table(view_rumus rms) throws SQLException {
        List<Rumus> getr = c.getrumus();
        Object data[][] = new Object[getr.size()][5];
       int i = 0;
            for(Rumus m : getr){
                data[i][0] = m.getKdRumus();
                data[i][1] = m.getNamaRumus();
                data[i][2] = m.getR1();
                data[i][3] = m.getR2();
                data[i][4] = m.getTanda();
                ++i;
            }
           rms.jTable1.setModel(new DefaultTableModel(data,header));
    }
    

    @Override
    public void kliktabel(view_rumus rms) throws SQLException {
        try {
             int pilih = rms.jTable1.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             String kd_rms = String.valueOf(rms.jTable1.getValueAt(pilih, 0).toString());
             String nm_rms = String.valueOf(rms.jTable1.getValueAt(pilih, 1).toString());
             String r1 = String.valueOf(rms.jTable1.getValueAt(pilih, 2).toString());
             String r2 = String.valueOf(rms.jTable1.getValueAt(pilih, 3).toString());
             String tanda = String.valueOf(rms.jTable1.getValueAt(pilih, 4).toString());
             
             rms.txtkd_rumus.setText(kd_rms);
             rms.txtnama_rumus.setText(nm_rms);
             rms.txtr1.setText(r1);
             rms.txtr2.setText(r2);
             rms.txttanda.setText(tanda);
        } catch (Exception e) {
            
        }   
    }
    
}
