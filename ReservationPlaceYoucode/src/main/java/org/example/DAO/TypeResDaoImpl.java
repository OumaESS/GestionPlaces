package org.example.DAO;

import org.example.Entity.RoleEntity;
import org.example.Entity.TypereservationEntity;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public class TypeResDaoImpl implements  TypeResDAO{
    Session session;
    @Override
    public void addTypeRes(TypereservationEntity typereservationEntity) {

        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(typereservationEntity);
        session.getTransaction().commit();
        System.out.println("add rtype");

    }

    @Override
    public TypereservationEntity getTypeResById(int id) {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        TypereservationEntity typereservationEntity = session.find(TypereservationEntity.class, id);
        session.getTransaction().commit();
        return typereservationEntity;
    }

    @Override
    public List<TypereservationEntity> getAllTypeRes() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        List<TypereservationEntity> listTypeRes = session.createQuery("From TypereservationEntity ").list();
        session.getTransaction().commit();
        return listTypeRes;
    }

    @Override
    public void deleteTypeRes(int id) {

        TypereservationEntity typereservationEntity;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        typereservationEntity= session.find(TypereservationEntity.class, id);
        if (typereservationEntity != null){
            session.delete(typereservationEntity);
            session.flush();
            System.out.println("delete typeRes");
        }else{
            System.out.println("typeRes does not exist");
        }
        session.getTransaction().commit();

    }

    @Override
    public TypereservationEntity updateTypeRes(TypereservationEntity typereservation) {
        TypereservationEntity typereservationEntity;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        typereservationEntity= session.find(TypereservationEntity.class, typereservation.getId());
        if (typereservationEntity!= null){
            typereservationEntity.setTypeRes(typereservation.getTypeRes());
            typereservationEntity.setNomberClass(typereservation.getNomberClass());
            System.out.println("typeRes update");
        }else{
            System.out.println("typeRes does not exist");
        }
        session.getTransaction().commit();
        return typereservationEntity;
    }


    }

