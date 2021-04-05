package org.example.service;

import org.example.Entity.UsersEntity;

import java.util.List;

public interface UserService {
    public  void addUser(UsersEntity user);
    public UsersEntity getUserById(int id);
    public List<UsersEntity> getAllUsers();
    public void deleteUser(int id);
    public UsersEntity updateUser(UsersEntity user);

}

