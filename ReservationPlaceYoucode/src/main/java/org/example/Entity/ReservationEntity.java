package org.example.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reservation")
public class ReservationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRes;
    @OneToOne
    private UseradminEntity user;
    @Column(nullable = false)
    private String dateRes;
    private boolean confirmation;
    @OneToOne
    private TypereservationEntity typeRes;

    public ReservationEntity() {
    }

    public ReservationEntity(int id, UseradminEntity user, String dateRes, boolean confirmation, TypereservationEntity typeRes) {
        this.idRes = id;
        this.user = user;
        this.dateRes = dateRes;
        this.confirmation = confirmation;
        this.typeRes = typeRes;
    }

    public ReservationEntity(UseradminEntity user, String dateRes, TypereservationEntity typeRes) {
        this.user = user;
        this.dateRes = dateRes;
        this.typeRes = typeRes;
    }


    public int getId() {
        return idRes;
    }

    public void setId(int id) {
        this.idRes = id;
    }

    public UseradminEntity getUser() {
        return user;
    }

    public void setUser(UseradminEntity user) {
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

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
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
