package org.example.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRes;
    @OneToOne
    private UsersEntity user;
    @Column(nullable = false)
    private String dateRes;
    private boolean confirmation;
    @OneToOne //for&key
    private TypereservationEntity typeRes;

    public ReservationEntity() {
    }

    public ReservationEntity(int id, UsersEntity user, String dateRes, boolean confirmation, TypereservationEntity typeRes) {
        this.idRes = id;
        this.user = user;
        this.dateRes = dateRes;
        this.confirmation = confirmation;
        this.typeRes = typeRes;
    }

    public ReservationEntity(UsersEntity user, String dateRes, TypereservationEntity typeRes) {
        this.user = user;
        this.dateRes = dateRes;
        this.typeRes = typeRes;
    }

    public ReservationEntity(int id, boolean accpeted) {
        this.idRes=id;
        this.confirmation=accpeted;
    }


    public int getId() {
        return idRes;
    }

    public void setId(int id) {
        this.idRes = id;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public String getDateRes() {
        return dateRes;
    }

    public void setDateRes(String dateRes) {
        this.dateRes = dateRes;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public boolean setConfirmation(boolean confirmation) {
       return this.confirmation = confirmation;

    }

    public TypereservationEntity getTypeRes() {
        return typeRes;
    }

    public void setTypeRes(TypereservationEntity typeRes) {
        this.typeRes = typeRes;
    }


    public void showRes() {
        System.out.println("Reservation{" +
                "id=" + idRes +
                ", user=" + user +
                ", dateRes='" + dateRes + '\'' +
                ", confirmation=" + confirmation +
                ", typeRes=" + typeRes +
                '}');
    }
}
