package org.example.service;

import org.example.DAO.UserDAO;
import org.example.Entity.UseradminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Component("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("userDao")
    private UserDAO userDAO;

    @Override
    @Transactional
    public void addUser(UseradminEntity user) {

        userDAO.addUser(user);

    }

    @Override
    @Transactional
    public UseradminEntity getUserById(int id) {

      return userDAO.getUserById(id);
    }

    @Override
    public List<UseradminEntity> getAllUsers() {

        return  userDAO.getAllUsers();
    }

    @Override
    public void deleteUser(int id) {

        userDAO.deleteUser(id);

    }

    @Override
    public UseradminEntity updateUser(UseradminEntity user) {

       return  userDAO.updateUser(user);
    }
}
