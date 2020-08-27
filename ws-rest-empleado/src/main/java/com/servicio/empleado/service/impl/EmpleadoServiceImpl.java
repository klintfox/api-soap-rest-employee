package com.servicio.empleado.service.impl;

import org.springframework.stereotype.Service;

import com.servicio.empleado.dto.EmpleadoResponse;
import com.servicio.empleado.model.Empleado;
import com.servicio.empleado.service.EmpleadoService;
import com.servicio.empleado.utils.FunctionUtils;
import com.servicio.empleado.ws.AddEmpleadoRequest;
import com.servicio.empleado.ws.EmpleadosPort;
import com.servicio.empleado.ws.EmpleadosPortService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Override
	public EmpleadoResponse validarEmpleado(Empleado request) throws Exception {
		EmpleadoResponse response = new EmpleadoResponse();
		boolean flag = false;

		flag = validarEmpledo(request);

		if (flag) {
			String fechaNac = "";
			String fechaVin = "";
			// invocamos servicio SOAP para registrar empleado
			EmpleadosPortService empleadoServiceImpl = new EmpleadosPortService();
			EmpleadosPort empleadoSoap = empleadoServiceImpl.getEmpleadosPortSoap11();
			AddEmpleadoRequest requestSoap = new AddEmpleadoRequest();
			requestSoap.setNombres(request.getNombres());
			requestSoap.setApellidos(request.getApellidos());
			requestSoap.setTipoDocumento(request.getTipoDocumento());
			requestSoap.setNumeroDocumento(request.getTipoDocumento());

			fechaNac = FunctionUtils.datetoString(request.getFechaNacimiento());
			fechaVin = FunctionUtils.datetoString(request.getFechaVinculacion());
			requestSoap.setFechaNacimiento(fechaNac);
			requestSoap.setFechaVinculacion(fechaVin);
			requestSoap.setCargo(request.getCargo());
			requestSoap.setSalario(request.getSalario());

			try {
				empleadoSoap.addEmpleado(requestSoap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setNombres(request.getNombres());
			response.setApellidos(request.getApellidos());
			response.setTipoDocumento(request.getTipoDocumento());
			response.setNumeroDocumento(request.getNumeroDocumento());
			response.setFechaNacimiento(request.getFechaNacimiento());
			response.setFechaVinculacion(request.getFechaVinculacion());
			response.setCargo(request.getCargo());
			response.setSalario(request.getSalario());
			String tiempoVinculacion = FunctionUtils.vinculacionEmpleado(fechaVin);
			String edadEmpleado = FunctionUtils.edadEmpleado(fechaNac);
			response.setTiempoVinculacion(tiempoVinculacion);
			response.setEdadEmpleado(edadEmpleado);
		}
		return response;
	}

	/**
	 * Método que valida los parámetros del objecto Empleado (request)
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("null")
	private boolean validarEmpledo(Empleado request) {
		boolean flag = true;
		if (request == null) {
			flag = false;
		} else {
			if (request.getNombres().isEmpty()) {
				flag = false;
			}
			if (request.getApellidos().isEmpty()) {
				flag = false;
			}
			if (request.getTipoDocumento().isEmpty()) {
				flag = false;
			}
			if (request.getNumeroDocumento().isEmpty()) {
				flag = false;
			}
			if (request.getFechaVinculacion().toString().isEmpty()) {
				flag = false;
			}
			if (request.getFechaNacimiento().toString().isEmpty()) {
				flag = false;
			} else {
				// validamos la edad
				String fechaNac = FunctionUtils.datetoString(request.getFechaNacimiento());
				Integer edad = FunctionUtils.mayorEdad(fechaNac);
				if (edad < 18) {
					flag = false;
				}
			}
		}
		return flag;
	}

}