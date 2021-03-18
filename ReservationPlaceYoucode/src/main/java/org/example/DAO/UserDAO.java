package org.example.DAO;

import org.example.Entity.UseradminEntity;

import java.util.List;

public interface UserDAO {
    public  void addUser(UseradminEntity user);
    public UseradminEntity getUserById(int id);
    public List<UseradminEntity> getAllUsers();
    public void deleteUser(int id);
    public UseradminEntity updateUser(UseradminEntity user);
}
