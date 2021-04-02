package org.example.Repostory;

import org.example.Entity.UseradminEntity;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserRepostory {

    Session session;
    public List<UseradminEntity> getAllStudents() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        List<UseradminEntity> userList = session.createQuery("From UseradminEntity  where role.roleName='student'").list();
        session.getTransaction().commit();
        return userList;
    }



    public UseradminEntity updateUserAccpect(UseradminEntity user) {
        UseradminEntity userEntity;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        userEntity = session.find(UseradminEntity.class, user.getId());
        if (userEntity != null){
            userEntity.setAccepted(user.isAccepted());
            System.out.println("User update");
        }else{
            System.out.println("User does not exist");
        }
        session.getTransaction().commit();
        return userEntity;
    }
}
