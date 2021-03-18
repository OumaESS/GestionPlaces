package org.example.DAO;

import org.example.Entity.*;

import java.util.List;

public interface TypeResDAO {

    public  void addTypeRes(TypereservationEntity typereservationEntity);
    public TypereservationEntity getTypeResById(int id);
    public List<TypereservationEntity> getAllTypeRes();
    public void deleteTypeRes(int id);
    public TypereservationEntity updateTypeRes(TypereservationEntity typereservation);
}
