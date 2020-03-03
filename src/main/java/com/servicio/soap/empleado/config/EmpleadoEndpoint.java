package com.servicio.soap.empleado.config;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.servicio.gs_ws.AddEmpleadoRequest;
import com.servicio.gs_ws.AddEmpleadoResponse;
import com.servicio.gs_ws.EmpleadoType;
import com.servicio.gs_ws.ServiceStatus;
import com.servicio.soap.empleado.entity.EmpleadoEntity;
import com.servicio.soap.empleado.service.EmpleadoService;


@Endpoint
public class EmpleadoEndpoint {

	public static final String NAMESPACE_URI = "http://www.servicio.com/empleado-ws";

	private EmpleadoService service;

	public EmpleadoEndpoint() {

	}

	@Autowired
	public EmpleadoEndpoint(EmpleadoService service) {
		this.service = service;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmpleadoRequest")
	@ResponsePayload
	public AddEmpleadoResponse addMovie(@RequestPayload AddEmpleadoRequest request) {
		AddEmpleadoResponse response = new AddEmpleadoResponse();
		EmpleadoType newMovieType = new EmpleadoType();
		ServiceStatus serviceStatus = new ServiceStatus();

		EmpleadoEntity newMovieEntity = new EmpleadoEntity(request.getId(), request.getNombres(),
				request.getApellidos(), request.getTipoDocumento(), request.getNumeroDocumento(),
				request.getFechaNacimiento(), request.getFechaVinculacion(), request.getCargo(),
				request.getSalario());
		EmpleadoEntity savedMovieEntity;
		try {
			savedMovieEntity = service.addEmpleado(newMovieEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		if (savedMovieEntity == null) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Exception while adding Entity");
		} else {

			BeanUtils.copyProperties(savedMovieEntity, newMovieType);
			serviceStatus.setStatusCode("SUCCESS");
			serviceStatus.setMessage("Content Added Successfully");
		}

		response.setMovieType(newMovieType);
		response.setServiceStatus(serviceStatus);
		return response;

	}
}
