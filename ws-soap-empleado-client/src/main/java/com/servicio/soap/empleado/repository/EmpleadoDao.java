package com.servicio.soap.empleado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servicio.soap.empleado.entity.EmployeeEntity;

@Repository
public interface EmpleadoDao extends CrudRepository<EmployeeEntity, Long> {

}
