package org.example.Repostory;

import org.example.Entity.UsersEntity;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserRepostory {

    Session session;
    public List<UsersEntity> getAllStudents() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        List<UsersEntity> userList = session.createQuery("From UsersEntity  where role.roleName='student'").list();
        session.getTransaction().commit();
        return userList;
    }



    public UsersEntity updateUserAccpect(UsersEntity user) {
        UsersEntity userEntity;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        userEntity = session.find(UsersEntity.class, user.getId());
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
