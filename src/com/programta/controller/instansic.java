/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.programta.entity.Intansi;
import com.programta.hibernateutil.HibernateUtil;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author albi
 */

public class instansic{
    
Session session;
public List<Intansi> getinstansis(){
session = HibernateUtil.getSessionFactory().openSession();
session.beginTransaction();
List<Intansi> list = session.createCriteria(Intansi.class).list();
return list;
}
    public void Saveinstansi(Intansi ins){

String berhasil = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(ins);// save ke database
        session.getTransaction().commit();
        session.close();

}catch (Exception E){

}

    }
        public void Update(Intansi ins){

String berhasil = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
              session.beginTransaction();
        session.update(ins);// save ke database
        session.getTransaction().commit();
        session.close();

}catch (Exception E){

}

    }
        public void delete(String kd_inst){
 session = HibernateUtil.getSessionFactory().openSession();
    try{
   int id1 = Integer.parseInt(kd_inst);
Transaction transaction = session.getTransaction();
        transaction.begin();
        Intansi inst =  (Intansi) session.get(Intansi.class, id1);
        session.delete(inst);// save ke database
        transaction.commit();
}catch (Exception E){}
finally {
         
      }
}
      
}

