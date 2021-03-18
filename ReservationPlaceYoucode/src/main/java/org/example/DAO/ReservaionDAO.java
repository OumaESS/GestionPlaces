package org.example.DAO;

import org.example.Entity.*;

import java.util.List;

public interface ReservaionDAO {

    public  void addRes(ReservationEntity reservationEntity);
    public ReservationEntity getResById(int id);
    public List<ReservationEntity> getAllRes();
    public void deleteRes(int id);
    public ReservationEntity updateRes(ReservationEntity reservation);
}
