package org.example.DAO;

import org.example.Entity.ReservationEntity;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public class ReservationDaoImpl implements ReservaionDAO{
    Session session;
    @Override
    public void addRes(ReservationEntity reservationEntity) {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(reservationEntity);
        session.getTransaction().commit();
        System.out.println("add Res");
    }

    @Override
    public ReservationEntity getResById(int id) {
        session = HibernateUtil.getSession();
        session.beginTransaction();
       ReservationEntity reservationEntity = session.find(ReservationEntity.class, id);
        session.getTransaction().commit();
        return reservationEntity;
    }

    @Override
    public List<ReservationEntity> getAllRes() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        List<ReservationEntity> resList = session.createQuery("From ReservationEntity ").list();
        session.getTransaction().commit();
        return resList;
    }

    @Override
    public void deleteRes(int id) {

        ReservationEntity reservationEntity;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        reservationEntity = session.find(ReservationEntity.class, id);
        if (reservationEntity != null){
            session.delete(reservationEntity);
            session.flush();
            System.out.println("delete user");
        }else{
            System.out.println("user does not exist");
        }
        session.getTransaction().commit();
    }

    @Override
    public ReservationEntity updateRes(ReservationEntity reservation) {
        ReservationEntity reservationEntity;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        reservationEntity = session.find(ReservationEntity.class, reservation.getId());
        if (reservationEntity != null){
            reservationEntity.setUser(reservation.getUser());
            reservationEntity.setDateRes(reservation.getDateRes());
            reservationEntity.setConfirmation(reservation.isConfirmation());
            reservationEntity.setTypeRes(reservation.getTypeRes());
            System.out.println("Res update");
        }else{
            System.out.println("Res does not exist");
        }
        session.getTransaction().commit();
        return reservationEntity;
    }

}

