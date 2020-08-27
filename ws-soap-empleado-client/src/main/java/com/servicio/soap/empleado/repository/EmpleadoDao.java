package com.servicio.soap.empleado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicio.soap.empleado.entity.EmpleadoEntity;

@Repository
public interface EmpleadoDao extends CrudRepository<EmpleadoEntity, Long> {

}
