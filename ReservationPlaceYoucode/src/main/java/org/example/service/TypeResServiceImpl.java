package org.example.service;

import org.example.DAO.TypeResDAO;
import org.example.Entity.TypereservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class TypeResServiceImpl implements TypeResService{


    @Autowired
    private TypeResDAO typeResDAO;
    @Override
    public void addTypeRes(TypereservationEntity typereservationEntity) {
        typeResDAO.addTypeRes(typereservationEntity);
    }

    @Override
    public TypereservationEntity getTypeResById(int id) {
        return typeResDAO.getTypeResById(id);
    }

    @Override
    public List<TypereservationEntity> getAllTypeRes() {
        return typeResDAO.getAllTypeRes();
    }

    @Override
    public void deleteTypeRes(int id) {

        typeResDAO.deleteTypeRes(id);

    }

    @Override
    public TypereservationEntity updateTypeRes(TypereservationEntity typereservation) {
        return typeResDAO.updateTypeRes(typereservation);
    }
}
