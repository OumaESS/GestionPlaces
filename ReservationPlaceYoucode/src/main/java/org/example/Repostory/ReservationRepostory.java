package org.example.Repostory;

import org.example.Entity.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepostory {

    Session session;


    public List<ReservationEntity> getAllReservationsById(int id) {

        session = HibernateUtil.getSession();

        List reservations = null;

        try {

            Query query = session.createQuery(" from ReservationEntity u  where u.user.idUser =:id");

            query.setParameter("id", id);

            reservations = query.getResultList();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return reservations;
    }

    public ReservationEntity Confirm(ReservationEntity reservation) {
        ReservationEntity reservationEntity;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        reservationEntity = session.find(ReservationEntity.class, reservation.getId());
        if (reservationEntity != null){
            reservationEntity.setConfirmation(reservation.isConfirmation());

            System.out.println("Res update");
        }else{
            System.out.println("Res does not exist");
        }
        session.getTransaction().commit();
        return reservationEntity;
    }
}
