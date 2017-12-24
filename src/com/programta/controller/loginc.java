/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.controller;

import com.programta.entity.Login;
import java.util.List;
import org.hibernate.Query;
import com.programta.hibernateutil.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author user
 */
public class loginc {
    Session session;
    Query query;
    
    public String getlogin(String username,String pass){
      session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String b = null;
        String hql;
              hql = "from Login where username=:p12 and password =:p13"; 
           query = session.createQuery(hql);
           query.setParameter("p12", username);
           query.setParameter("p13", pass);
        List<Login> list = query.list();
        int i = 0;
        Object bundel1[][]= new Object[list.size()][1];
        for(Login get : list){
        bundel1[i][0]= get.getNama();
        b = bundel1[i][0].toString();
        i++;
        } 
        return b;
    }
}
