package org.example.service;

import org.example.DAO.UserDAO;
import org.example.Entity.UsersEntity;
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
    public void addUser(UsersEntity user) {

        userDAO.addUser(user);

    }

    @Override
    @Transactional
    public UsersEntity getUserById(int id) {

      return userDAO.getUserById(id);
    }

    @Override
    public List<UsersEntity> getAllUsers() {

        return  userDAO.getAllUsers();
    }

    @Override
    public void deleteUser(int id) {

        userDAO.deleteUser(id);

    }

    @Override
    public UsersEntity updateUser(UsersEntity user) {

       return  userDAO.updateUser(user);
    }
}
