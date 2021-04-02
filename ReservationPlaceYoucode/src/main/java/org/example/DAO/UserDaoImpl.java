package org.example.DAO;

import org.example.util.HibernateUtil;
import org.example.Entity.UseradminEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component("userDao")
public class UserDaoImpl implements UserDAO{
    Session session;
    @Override
    public void addUser(UseradminEntity user) {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("add user");
    }

    @Override
    public UseradminEntity getUserById(int id) {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        UseradminEntity user = session.find(UseradminEntity.class, id);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public List<UseradminEntity> getAllUsers() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        List<UseradminEntity> userList = session.createQuery("From UseradminEntity ").list();
        session.getTransaction().commit();
        return userList;
    }

    @Override
    public void deleteUser(int id) {
        UseradminEntity user;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        user = session.find(UseradminEntity.class, id);
        if (user != null){
            session.delete(user);
            session.flush();
            System.out.println("delete user");
        }else{
            System.out.println("user does not exist");
        }
        session.getTransaction().commit();
    }

    @Override
    public UseradminEntity updateUser(UseradminEntity user) {
        UseradminEntity userEntity;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        userEntity = session.find(UseradminEntity.class, user.getId());
        if (userEntity != null){
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setEmail(user.getEmail());
            userEntity.setPassword(user.getPassword());
//            userEntity.setPhone(user.getPhone());
//            userEntity.setRole(user.getRole());
            System.out.println("User update");
        }else{
            System.out.println("User does not exist");
        }
        session.getTransaction().commit();
        return userEntity;
    }
}
