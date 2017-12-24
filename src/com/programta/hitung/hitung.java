/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.hitung;

import com.programta.entity.Pekerja;
import com.programta.hibernateutil.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author user
 */
public class hitung {
   String dosis;
   Session session;
   String nama,r1 , r2, tanda;
   public String rumus(String d1,String d2, String d3,String id_pkrj,String kontrol){
       Query query;
      session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String b = null;
        String hql;
              hql = "from Pekerja where id =:p13"; 
           query = session.createQuery(hql);
           query.setParameter("p13", id_pkrj);
        List<Pekerja> list = query.list();
        int i = 0;
        Object jns1[][]= new Object[list.size()][4];
        for(Pekerja get : list){
        jns1[i][0]= get.getRumus().getNamaRumus();
        jns1[i][1]= get.getRumus().getR1();
        jns1[i][2]= get.getRumus().getR2();
        jns1[i][3]= get.getRumus().getTanda();
        nama = jns1[i][0].toString();
        r1 = jns1[i][1].toString();
        r2 = jns1[i][2].toString();
        tanda = jns1[i][3].toString();
        i++;
        }
        if(nama.equals("cs137")){
        double hasilkontrol;
        double hasil;
        hasilkontrol = (Double.parseDouble(d1)-Double.parseDouble(kontrol));
        if(tanda.equals("-")){
            hasil = Double.parseDouble(r1)*hasilkontrol-Double.parseDouble(r2);
        dosis = String.valueOf(hasil);   
        }
        else{
        hasil = Double.parseDouble(r1)*hasilkontrol-Double.parseDouble(r2);
        dosis = String.valueOf(hasil);
        } 
        
        }
 return dosis;
}
}
