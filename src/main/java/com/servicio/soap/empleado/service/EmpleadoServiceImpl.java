package com.servicio.soap.empleado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicio.soap.empleado.entity.EmpleadoEntity;
import com.servicio.soap.empleado.repository.EmpleadoDao;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	public EmpleadoEntity addEmpleado(EmpleadoEntity empleadoEntity) throws Exception {
		try {
			return empleadoDao.save(empleadoEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
