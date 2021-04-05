package org.example.DAO;

import org.example.Entity.UsersEntity;

import java.util.List;

public interface UserDAO {
    public  void addUser(UsersEntity user);
    public UsersEntity getUserById(int id);
    public List<UsersEntity> getAllUsers();
    public void deleteUser(int id);
    public UsersEntity updateUser(UsersEntity user);
}
