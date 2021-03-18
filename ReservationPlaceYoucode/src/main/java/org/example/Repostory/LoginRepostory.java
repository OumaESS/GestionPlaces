package org.example.Repostory;

import org.example.Entity.UseradminEntity;
import org.example.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;

public class LoginRepostory {

        Session session;
    public UseradminEntity getUserByEmailPassword(String email, String password){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from UseradminEntity where email=: email and password=: password");
        query.setParameter("email", email);
        query.setParameter("password",password);
        try {
            UseradminEntity userEntity = (UseradminEntity) query.getSingleResult();
            return userEntity;
        }
        catch (Exception e){
            return null;
        }
    }
}
