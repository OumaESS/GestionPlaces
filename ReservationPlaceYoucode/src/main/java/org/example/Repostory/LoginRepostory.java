package org.example.Repostory;

import org.example.Entity.UsersEntity;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;

public class LoginRepostory {

        Session session;
    public UsersEntity getUserByEmailPassword(String email, String password){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from UsersEntity where email=: email and password=: password");
        query.setParameter("email", email);
        query.setParameter("password",password);
        try {
            UsersEntity userEntity = (UsersEntity) query.getSingleResult(); //execute query
            return userEntity;
        }
        catch (Exception e){
            return null;
        }
    }
}
