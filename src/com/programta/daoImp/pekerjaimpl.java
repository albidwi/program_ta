/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.daoImp;

import com.programta.controller.instansic;
import com.programta.controller.pekerjac;
import com.programta.dao.dao_pekerja;
import com.programta.entity.Intansi;
import com.programta.entity.Pekerja;
import com.programta.entity.Rumus;
import com.programta.view.view_pekerja;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class pekerjaimpl implements dao_pekerja{
Pekerja c = new Pekerja();
pekerjac c1 = new pekerjac();
instansic a = new instansic();
Intansi i =new Intansi();
 String header[] ={"id","Kode Instansi", "Kode Pekerja", "divisi","Nama Pekerja","No Ktp","Rumus"};
  String header2[] ={"Kode Instansi", "Nama Instansi"};
Rumus r = new Rumus();
int id;
    @Override
    public void save(view_pekerja pkrj) throws SQLException {
      int kd_inst;
      int kd_pkrj;
      String divisi;
      String nm_pkrj;  
      String no_ktp;
      String rumus;
      try{
      kd_inst = Integer.parseInt(pkrj.txtkd_inst.getText());
      kd_pkrj = Integer.parseInt(pkrj.txtkd_pkrj.getText());
      divisi = pkrj.txtdivisi.getText();
      nm_pkrj = pkrj.txtnm_pkrj.getText();
      no_ktp = pkrj.txtnoktp.getText();
      rumus = c1.getjnsradiasi((String) pkrj.cmbrms.getSelectedItem()) ;
      i.setKdInst(kd_inst);
      c.setIntansi(i);
      c.setKdPekerja(kd_pkrj);
      c.setDivisi(divisi);
      c.setNamaPekerja(nm_pkrj);
      c.setNoKtp(no_ktp);
      r.setKdRumus(Integer.parseInt(rumus));
      c.setRumus(r);
          c1.SavePekerja(c);
              table(pkrj);
      
      }catch(Exception e){
      System.out.println(e);
      }
    }

    @Override
    public void update(view_pekerja pkrj) throws SQLException {
      
      int kd_inst;
      int kd_pkrj;
      String divisi;
      String nm_pkrj;  
      String no_ktp;
      String rumus;
      try{
      
      kd_inst = Integer.parseInt(pkrj.txtkd_inst.getText());
      kd_pkrj = Integer.parseInt(pkrj.txtkd_pkrj.getText());
      divisi = pkrj.txtdivisi.getText();
      nm_pkrj = pkrj.txtnm_pkrj.getText();
      no_ktp = pkrj.txtnoktp.getText();
      rumus = c1.getjnsradiasi((String) pkrj.cmbrms.getSelectedItem()) ;
      c.setId(id);
      i.setKdInst(kd_inst);
      c.setIntansi(i);
      c.setKdPekerja(kd_pkrj);
      c.setDivisi(divisi);
      c.setNamaPekerja(nm_pkrj);
      c.setNoKtp(no_ktp);
      r.setKdRumus(Integer.parseInt(rumus));
      c.setRumus(r);
   
          c1.SavePekerja(c);
             table(pkrj);
      }catch(Exception e){
      System.out.println(e);
      }
    }

    @Override
    public void delete(view_pekerja pkrj) throws SQLException {
        c1.delete(id);
              table(pkrj);
    }

    @Override
    public void table(view_pekerja pkrj) throws SQLException {
try{
    List<Pekerja> list = c1.getpekerjas(pkrj.txtkd_inst.getText());
Object data[][] = new Object[list.size()][9];
 int i = 0;
            for(Pekerja m : list){
                data[i][0] = m.getId();
                data[i][1] = m.getIntansi().getKdInst();
                data[i][2] = m.getKdPekerja();
                data[i][3] = m.getDivisi();
                data[i][4] = m.getNamaPekerja();
                data[i][5] = m.getNoKtp();
                String nma = c1.getnama(String.valueOf(m.getRumus().getKdRumus()));
                data[i][6] = nma;    
                ++i;
                 
            }
           pkrj.jTable1.setModel(new DefaultTableModel(data,header)); }
catch (Exception e){
System.out.println(e);

}

    }

    @Override
    public void kliktabel(view_pekerja pkrj) throws SQLException {
     try {
             int pilih = pkrj.jTable1.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             id = Integer.parseInt(String.valueOf(pkrj.jTable1.getValueAt(pilih, 0).toString()));
             String kd_inst = String.valueOf(pkrj.jTable1.getValueAt(pilih, 1).toString());
             String kdpkrj = String.valueOf(pkrj.jTable1.getValueAt(pilih, 2).toString());
             String divisi = String.valueOf(pkrj.jTable1.getValueAt(pilih, 3).toString());
             String namapkrj = String.valueOf(pkrj.jTable1.getValueAt(pilih, 4).toString());
             String no_ktp = String.valueOf(pkrj.jTable1.getValueAt(pilih, 5).toString());
             String namarumus = String.valueOf(pkrj.jTable1.getValueAt(pilih, 6).toString());
          pkrj.txtkd_inst.setText(kd_inst);
          pkrj.txtkd_pkrj.setText(kdpkrj);
          pkrj.txtdivisi.setText(divisi);
          pkrj.txtnm_pkrj.setText(namapkrj );
          pkrj.txtnoktp.setText(no_ktp);
          pkrj.cmbrms.setSelectedItem(namarumus);
        } catch (Exception e) {
            
        } 
    }

    @Override
    public void getcombo(view_pekerja pkrj) throws SQLException {
         List<Rumus> list = c1.getradias();
                Object data[][] = new Object[list.size()][5];
            int i = 0;
            for(Rumus m : list){
               data[i][0] = m.getNamaRumus();
               pkrj.cmbrms.addItem(data[i][0].toString()); 
                ++i;
    }
    
}

    @Override
    public void table2(view_pekerja pkrj) throws SQLException {
   List<Intansi> list = a.getinstansis();
Object data[][] = new Object[list.size()][5];
 int i = 0;
            for(Intansi m : list){
                data[i][0] = m.getKdInst();
                data[i][1] = m.getNamaInstansi();
                ++i;
                 
            }
           pkrj.jTable2.setModel(new DefaultTableModel(data,header2));
    }

    @Override
    public void kliktabel2(view_pekerja pkrj) throws SQLException {
      try {
             int pilih = pkrj.jTable2.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             String kd_inst = String.valueOf(pkrj.jTable2.getValueAt(pilih, 0).toString());
          pkrj.txtkd_inst.setText(kd_inst);
          table(pkrj);
        } catch (Exception e) {
            
        } 
    }
}