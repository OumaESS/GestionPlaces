package org.example.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "role")
public class RoleEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    @Column(nullable = false, unique = true)
    private String roleName;

    public RoleEntity() {
    }

    public RoleEntity(int id, String roleName) {
        this.idRole = id;
        this.roleName = roleName;
    }

    public RoleEntity(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return idRole;
    }

    public void setId(int id) {
        this.idRole = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public void showRole() {
        System.out.println("RoleEntity{" +
                "id=" + idRole +
                ", roleName='" + roleName + '\'' +
                '}');
    }
}
