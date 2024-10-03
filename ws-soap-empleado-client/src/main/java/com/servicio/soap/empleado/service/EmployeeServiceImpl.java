package com.servicio.soap.empleado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicio.soap.empleado.entity.EmployeeEntity;
import com.servicio.soap.empleado.repository.EmpleadoDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	public EmployeeEntity addEmpleado(EmployeeEntity empleadoEntity) throws Exception {
		try {
			return empleadoDao.save(empleadoEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
