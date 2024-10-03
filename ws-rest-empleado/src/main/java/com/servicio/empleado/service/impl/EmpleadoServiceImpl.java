package com.servicio.empleado.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.servicio.empleado.dto.EmpleadoRequest;
import com.servicio.empleado.dto.EmpleadoResponse;
import com.servicio.empleado.service.EmpleadoService;
import com.servicio.empleado.utils.FunctionUtils;
import com.servicio.ws.AddEmpleadoRequest;
import com.servicio.ws.EmpleadoPort;
import com.servicio.ws.EmpleadoPortService;
import com.servicio.ws.EmpleadoType;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Override
	public EmpleadoResponse saveEmpleado(EmpleadoRequest request) throws Exception {
		validateFechaVinculacion(request.getFechaVinculacion());
		EmpleadoResponse response = new EmpleadoResponse();
		EmpleadoPort empleadoSoap = new EmpleadoPortService().getEmpleadoPortSoap11();
		AddEmpleadoRequest requestSoap = createAddEmpleadoRequest(request);
		empleadoSoap.addEmpleado(requestSoap);
		populateEmpleadoResponse(response, request);
		return response;
	}

	private void validateFechaVinculacion(String fechaVinculacion) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate oldDate = LocalDate.parse(fechaVinculacion, formatter);
		LocalDate newDate = LocalDate.now();
		if (oldDate.isAfter(newDate)) {
			throw new IllegalArgumentException("La fecha de vinculación no puede ser mayor al día de hoy");
		}
	}

	private AddEmpleadoRequest createAddEmpleadoRequest(EmpleadoRequest request) {
		EmpleadoType empleadoType = new EmpleadoType();
		empleadoType.setNombres(request.getNombres());
		empleadoType.setApellidos(request.getApellidos());
		empleadoType.setTipoDocumento(request.getTipoDocumento());
		empleadoType.setNumeroDocumento(request.getNumeroDocumento());
		empleadoType.setFechaNacimiento(request.getFechaNacimiento());
		empleadoType.setFechaVinculacion(request.getFechaVinculacion());
		empleadoType.setCargo(request.getCargo());
		empleadoType.setSalario(request.getSalario());
		AddEmpleadoRequest requestSoap = new AddEmpleadoRequest();
		requestSoap.setEmpleado(empleadoType);
		return requestSoap;
	}

	private void populateEmpleadoResponse(EmpleadoResponse response, EmpleadoRequest request) {
		response.setNombres(request.getNombres());
		response.setApellidos(request.getApellidos());
		response.setTipoDocumento(request.getTipoDocumento());
		response.setNumeroDocumento(request.getNumeroDocumento());
		response.setFechaNacimiento(request.getFechaNacimiento());
		response.setFechaVinculacion(request.getFechaVinculacion());
		response.setCargo(request.getCargo());
		response.setSalario(request.getSalario());
		response.setTiempoVinculacion(FunctionUtils.calcularTiempoVinculacion(request.getFechaVinculacion()));
		response.setEdadEmpleado(FunctionUtils.calcularEdadEmpleado(request.getFechaNacimiento()));
	}

}