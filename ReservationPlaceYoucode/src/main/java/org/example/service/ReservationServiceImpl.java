package org.example.service;

import org.example.DAO.ReservaionDAO;
import org.example.Entity.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ReservationServiceImpl  implements ReservationService{


    @Autowired
    private ReservaionDAO reservaionDAO;

    @Override
    public void addRes(ReservationEntity reservationEntity) {
        reservaionDAO.addRes(reservationEntity);
    }

    @Override
    public ReservationEntity getResById(int id) {
       return reservaionDAO.getResById(id);
    }

    @Override
    public List<ReservationEntity> getAllRes() {
        return reservaionDAO.getAllRes();
    }

    @Override
    public void deleteRes(int id) {

        reservaionDAO.deleteRes(id);
    }

    @Override
    public ReservationEntity updateRes(ReservationEntity reservation) {
        return reservaionDAO.updateRes(reservation);
    }
}
