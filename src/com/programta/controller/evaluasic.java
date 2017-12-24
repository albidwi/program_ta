/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.controller;

import com.programta.dao.dao_evaluasi;
import com.programta.entity.Evaluasi;
import com.programta.entity.Pekerja;
import com.programta.entity.Rumus;
import com.programta.hibernateutil.HibernateUtil;
import com.programta.view.view_evaluasi;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author user
 */
public class evaluasic {
Session session;
  public void Saveevaluasi(Evaluasi e){

String berhasil = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);// save ke database
        session.getTransaction().commit();
        session.close();

}catch (Exception E){
System.out.println(E);
}

    }
  
    public List<Evaluasi> getevaluasis(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Evaluasi> list = session.createCriteria(Evaluasi.class).list();
        session.close();
return list;
} 
            public void Update(Evaluasi e){

String berhasil = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
              session.beginTransaction();
        session.update(e);// save ke database
        session.getTransaction().commit();
        session.close();

}catch (Exception E){

}
            } 
            
                   public void Delete(Evaluasi e){

String berhasil = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
              session.beginTransaction();
        session.delete(e);// save ke database
        session.getTransaction().commit();
        session.close();

}catch (Exception E){

}
            }
public String getpekerjaid(String kd_pkrj,String kd_inst){
          Query query;
      session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String b = null;
        String hql;
              hql = "from Pekerja where kd_inst=:p12 and kd_pekerja =:p13"; 
           query = session.createQuery(hql);
           query.setParameter("p12", kd_inst);
           query.setParameter("p13", kd_pkrj);
        List<Pekerja> list = query.list();
        int i = 0;
        Object jns1[][]= new Object[list.size()][1];
        for(Pekerja get : list){
        jns1[i][0]= get.getId();
        b = jns1[i][0].toString();
        i++;
        } 
        return b;
    }
}
