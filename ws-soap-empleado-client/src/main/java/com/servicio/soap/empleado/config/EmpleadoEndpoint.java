package com.servicio.soap.empleado.config;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.servicio.soap.empleado.entity.EmployeeEntity;
import com.servicio.soap.empleado.gen.AddEmpleadoRequest;
import com.servicio.soap.empleado.gen.AddEmpleadoResponse;
import com.servicio.soap.empleado.gen.EmpleadoType;
import com.servicio.soap.empleado.gen.ServiceStatus;
import com.servicio.soap.empleado.service.EmployeeService;

@Endpoint
public class EmpleadoEndpoint {

	public static final String NAMESPACE_URI = "http://www.servicio.com/empleado-ws";

	@Autowired
	private EmployeeService service;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmpleadoRequest")
	@ResponsePayload
	public AddEmpleadoResponse addEmpleadoRequest(@RequestPayload AddEmpleadoRequest request) {
		AddEmpleadoResponse response = new AddEmpleadoResponse();
		EmpleadoType newEmpleadoType = new EmpleadoType();
		ServiceStatus serviceStatus = new ServiceStatus();

		EmpleadoType empleado = new EmpleadoType();
		empleado.setNombres(request.getEmpleado().getNombres());
		empleado.setApellidos(request.getEmpleado().getApellidos());
		empleado.setTipoDocumento(request.getEmpleado().getTipoDocumento());
		empleado.setNumeroDocumento(request.getEmpleado().getNumeroDocumento());
		empleado.setFechaNacimiento(request.getEmpleado().getFechaNacimiento());
		empleado.setFechaVinculacion(request.getEmpleado().getFechaVinculacion());
		empleado.setCargo(request.getEmpleado().getCargo());
		empleado.setSalario(request.getEmpleado().getSalario());

		EmployeeEntity newEmpleadoEntity = new EmployeeEntity(empleado.getId(), empleado.getNombres(),
				empleado.getApellidos(), empleado.getTipoDocumento(), empleado.getNumeroDocumento(),
				empleado.getFechaNacimiento(), empleado.getFechaVinculacion(), empleado.getCargo(),
				empleado.getSalario());

		EmployeeEntity savedEmpleadoEntity = new EmployeeEntity();
		try {
			savedEmpleadoEntity = service.addEmpleado(newEmpleadoEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (savedEmpleadoEntity == null) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Exception while adding Entity");
		} else {

			BeanUtils.copyProperties(savedEmpleadoEntity, newEmpleadoType);
			serviceStatus.setStatusCode("SUCCESS");
			serviceStatus.setMessage("Content Added Successfully");
		}

		EmpleadoType newEmpleadoTypeResp = new EmpleadoType();
		//newEmpleadoTypeResp.setId(newEmpleadoEntity.getId());
		newEmpleadoTypeResp.setNombres(newEmpleadoEntity.getNombres());
		newEmpleadoTypeResp.setApellidos(newEmpleadoEntity.getApellidos());
		newEmpleadoTypeResp.setTipoDocumento(newEmpleadoEntity.getTipoDocumento());
		newEmpleadoTypeResp.setNumeroDocumento(newEmpleadoEntity.getNumeroDocumento());
		newEmpleadoTypeResp.setFechaNacimiento(newEmpleadoEntity.getFechaNacimiento());
		newEmpleadoTypeResp.setFechaVinculacion(newEmpleadoEntity.getFechaVinculacion());
		newEmpleadoTypeResp.setCargo(newEmpleadoEntity.getCargo());
		newEmpleadoTypeResp.setSalario(newEmpleadoEntity.getSalario());
		response.setEmpleado(newEmpleadoTypeResp);

		response.setServiceStatus(serviceStatus);
		return response;

	}
}