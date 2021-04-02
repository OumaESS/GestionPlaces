package org.example.service;

import org.example.Entity.TypereservationEntity;

import java.util.List;

public interface TypeResService {

    public  void addTypeRes(TypereservationEntity typereservationEntity);
    public TypereservationEntity getTypeResById(int id);
    public List<TypereservationEntity> getAllTypeRes();
    public void deleteTypeRes(int id);
    public TypereservationEntity updateTypeRes(TypereservationEntity typereservation);
}
