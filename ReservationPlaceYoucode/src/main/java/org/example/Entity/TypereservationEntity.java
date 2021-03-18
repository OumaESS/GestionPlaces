package org.example.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "typereservation")
public class TypereservationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idType;
    @Column(nullable = false)
    private String typeRes;
    @Column(nullable = false)
    private int nomberClass;

    public TypereservationEntity() {
    }

    public TypereservationEntity(String typeRes, int nomberClass) {
        this.typeRes = typeRes;
        this.nomberClass = nomberClass;
    }

    public TypereservationEntity(int id, String typeRes, int nomberClass) {
        this.idType = id;
        this.typeRes = typeRes;
        this.nomberClass = nomberClass;
    }

    public int getId() {
        return idType;
    }

    public void setId(int id) {
        this.idType = id;
    }

    public String getTypeRes() {
        return typeRes;
    }

    public void setTypeRes(String typeRes) {
        this.typeRes = typeRes;
    }

    public int getNomberClass() {
        return nomberClass;
    }

    public void setNomberClass(int nomberClass) {
        this.nomberClass = nomberClass;
    }


    public void showTypeRes() {
        System.out.println("TypeRes{" +
                "id=" + idType +
                ", typeRes='" + typeRes + '\'' +
                ", nomberClass=" + nomberClass +
                '}');
    }
}
