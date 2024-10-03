package com.servicio.empleado.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.empleado.dto.EmpleadoRequest;
import com.servicio.empleado.dto.EmpleadoResponse;
import com.servicio.empleado.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

	private final EmpleadoService empleadoService;

	public EmpleadoController(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

	@PostMapping("/add")
	public ResponseEntity<EmpleadoResponse> validarEmpleado(@Validated @RequestBody EmpleadoRequest request)
			throws Exception {
		logger.info("Request: {}", request);
		EmpleadoResponse response = new EmpleadoResponse();
		response = empleadoService.saveEmpleado(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}