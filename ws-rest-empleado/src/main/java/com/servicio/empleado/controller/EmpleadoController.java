package com.servicio.empleado.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.empleado.dto.EmpleadoResponse;
import com.servicio.empleado.model.Empleado;
import com.servicio.empleado.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);	
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@PostMapping("/add")
	public EmpleadoResponse validarEmpleado (@RequestBody Empleado request) {
		EmpleadoResponse response = new EmpleadoResponse();
		try {
			response = empleadoService.saveEmpleado(request);
		} catch (Exception e) {
			logger.error("Error"+e);
		}
		return response;
	}

}