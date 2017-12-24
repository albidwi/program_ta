/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.controller;

import com.programta.entity.Rumus;
import com.programta.hibernateutil.HibernateUtil;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author albidwi
 */
public class rumusc {
 Session session;
public List<Rumus> getrumus(){
session = HibernateUtil.getSessionFactory().openSession();
session.beginTransaction();
List<Rumus> list = session.createCriteria(Rumus.class).list();
return list;
}
    public void SaveRumus(Rumus rms){

String berhasil = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rms);// save ke database
        session.getTransaction().commit();
        session.close();

}catch (Exception E){

}

    }
        public void Update(Rumus rms){

String berhasil = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
              session.beginTransaction();
        session.saveOrUpdate(rms);
        session.getTransaction().commit();
        session.close();

}catch (Exception E){

}

    }
        public void delete(String kd_rms){
 session = HibernateUtil.getSessionFactory().openSession();
    try{
   int id1 = Integer.parseInt(kd_rms);
Transaction transaction = session.getTransaction();
        transaction.begin();
        Rumus rms =  (Rumus) session.get(Rumus.class, id1);
        session.delete(rms);// save ke database
        transaction.commit();
}catch (Exception E){}
finally {
         
      }
}
     
}
