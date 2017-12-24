/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.controller;

import com.programta.entity.Pekerja;
import com.programta.entity.Rumus;
import com.programta.hibernateutil.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author user
 */
public class pekerjac {
    Session session;
    public void SavePekerja(Pekerja pkrj){

String berhasil = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(pkrj);// save ke database
        session.getTransaction().commit();
        session.close();

}catch (Exception E){
System.out.println(E);
}

    }
  
    public List<Rumus> getradias(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Rumus> list = session.createCriteria(Rumus.class).list();
        session.close();
return list;
} 
       public List<Pekerja> getpekerjas(String kd_inst){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Pekerja.class);
       cr.createCriteria("intansi", "i");
cr.add(Restrictions.eq("i.kdInst",Integer.parseInt(kd_inst)));
        List<Pekerja> list = cr.list();
        session.close();
return list;
} 
      public String getjnsradiasi(String jns){
          Query query;
      session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String b = null;
        String hql;
              hql = "from Rumus where nama_rumus=:p12"; 
           query = session.createQuery(hql);
           query.setParameter("p12", jns);
        List<Rumus> list = query.list();
        int i = 0;
        Object jns1[][]= new Object[list.size()][1];
        for(Rumus get : list){
        jns1[i][0]= get.getKdRumus();
        b = jns1[i][0].toString();
        i++;
        } 
        return b;
    }
      public String getnama(String id){
          Query query;
      session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String b = null;
        String hql;
              hql = "from Rumus where kd_rumus=:p12"; 
           query = session.createQuery(hql);
           query.setParameter("p12", id);
        List<Rumus> list = query.list();
        int i = 0;
        Object jns1[][]= new Object[list.size()][1];
        for(Rumus get : list){
        jns1[i][0]= get.getNamaRumus();
        b = jns1[i][0].toString();
        i++;
        } 
        return b;
    }
         public void delete(int id){
 session = HibernateUtil.getSessionFactory().openSession();
    try{
Transaction transaction = session.getTransaction();
        transaction.begin();
        Pekerja pkrj =  (Pekerja) session.get(Pekerja.class, id);
        session.delete(pkrj);// save ke database
        transaction.commit();
}catch (Exception E){}
finally {
         
      }
}
      
}
