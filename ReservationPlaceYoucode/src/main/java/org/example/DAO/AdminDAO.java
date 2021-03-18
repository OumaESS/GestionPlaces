package org.example.DAO;

import org.example.Entity.AdminEntity;

import java.util.List;

public interface AdminDAO {
    public  void addAdmin(AdminEntity admin);
    public AdminEntity getAdminById(int id);
    public List<AdminEntity> getAllAdmins();
    public void deleteAdmin(int id);
    public AdminEntity updateAdmin(AdminEntity admin);
}
