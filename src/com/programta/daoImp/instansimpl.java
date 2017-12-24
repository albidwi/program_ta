/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.daoImp;

import com.programta.controller.instansic;
import com.programta.dao.dao_instansi;
import com.programta.entity.Intansi;
import com.programta.view.view_instansi;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class instansimpl implements dao_instansi{
    String header[] ={"Kode Instansi", "Nama", "Alamat","Kontak","email"};
Intansi i = new Intansi();
instansic a = new instansic();
    @Override
    public void save(view_instansi v) throws SQLException {
       String kd;
        String nama;
        String alamat;
        String kontak;
        String email;
      try{
        kd = v.txtkd_instansi.getText();
        nama = v.txtnm_instansi.getText();
        alamat = v.txtalamat.getText();
        kontak = v.txtkontak.getText();
        email = v.txtemail.getText();
      i.setKdInst(Integer.parseInt(kd));
       i.setNamaInstansi(nama);
       i.setKontak(kontak);
       i.setEmail(email);
       i.setAlamat(alamat);
       a.Saveinstansi(i);
        JOptionPane.showMessageDialog (null, "Save Berhasil", "Title", JOptionPane.INFORMATION_MESSAGE);
          tabel(v);
      }catch (Exception E){
      JOptionPane.showMessageDialog (null, "Save Tidak Berhasil", "Title", JOptionPane.INFORMATION_MESSAGE);
         
      }
    }

    @Override
    public void update(view_instansi v) throws SQLException {
               String kd;
        String nama;
        String alamat;
        String kontak;
        String email;
           kd = v.txtkd_instansi.getText();
        nama = v.txtnm_instansi.getText();
        alamat = v.txtalamat.getText();
        kontak = v.txtkontak.getText();
        email = v.txtemail.getText();
       i.setKdInst(Integer.parseInt(kd));
       i.setNamaInstansi(nama);
       i.setKontak(kontak);
       i.setEmail(email);
       i.setAlamat(alamat);
       a.Update(i);
        tabel(v);
    }

    @Override
    public void delete(view_instansi v) throws SQLException {
      a.delete(v.txtkd_instansi.getText());
        tabel(v);
    }

    @Override
    public void tabel(view_instansi v) throws SQLException {
       List<Intansi> list = a.getinstansis();
Object data[][] = new Object[list.size()][5];
 int i = 0;
            for(Intansi m : list){
                data[i][0] = m.getKdInst();
                data[i][1] = m.getNamaInstansi();
                data[i][2] = m.getAlamat();
                data[i][3] = m.getKontak();
                data[i][4] = m.getEmail();
                ++i;
                 
            }
           v.tblinst.setModel(new DefaultTableModel(data,header));
    }

    @Override
    public void kliktabel(view_instansi v) throws SQLException {
        try {
             int pilih = v.tblinst.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             String kd_inst = String.valueOf(v.tblinst.getValueAt(pilih, 0).toString());
             String nama = String.valueOf(v.tblinst.getValueAt(pilih, 1).toString());
             String alamat = String.valueOf(v.tblinst.getValueAt(pilih, 2).toString());
             String kontak = String.valueOf(v.tblinst.getValueAt(pilih, 3).toString());
             String email = String.valueOf(v.tblinst.getValueAt(pilih, 4).toString());
             
             v.txtkd_instansi.setText(kd_inst);
             v.txtnm_instansi.setText(nama);
             v.txtalamat.setText(alamat);
             v.txtkontak.setText(kontak);
             v.txtemail.setText(email);
             
        } catch (Exception e) {
            
        }   
    }
  
    
}
