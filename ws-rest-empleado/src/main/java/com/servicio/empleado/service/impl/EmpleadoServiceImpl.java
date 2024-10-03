package com.servicio.empleado.service.impl;

import org.springframework.stereotype.Service;
import com.servicio.empleado.dto.EmpleadoResponse;
import com.servicio.empleado.model.Empleado;
import com.servicio.empleado.service.EmpleadoService;
import com.servicio.empleado.utils.FunctionUtils;
import com.servicio.ws.EmpleadoType;
import com.servicio.ws.AddEmpleadoRequest;
import com.servicio.ws.ProductPort;
import com.servicio.ws.ProductPortService;

import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {


	@Override
    public EmpleadoResponse saveEmpleado(Empleado request) {
        EmpleadoResponse response = new EmpleadoResponse();

//        if (validarEmpleado(request)) {
            try {
                ProductPort empleadoSoap = new ProductPortService().getProductPortSoap11();
                AddEmpleadoRequest requestSoap = createAddEmpleadoRequest(request);

                empleadoSoap.addEmpleado(requestSoap);

                populateEmpleadoResponse(response, request);
            } catch (Exception e) {
                e.printStackTrace();
            }
//        }
        return response;
    }

	private AddEmpleadoRequest createAddEmpleadoRequest(Empleado request) {
		
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

	private void populateEmpleadoResponse(EmpleadoResponse response, Empleado request) {
		response.setNombres(request.getNombres());
		response.setApellidos(request.getApellidos());
		response.setTipoDocumento(request.getTipoDocumento());
		response.setNumeroDocumento(request.getNumeroDocumento());
		response.setFechaNacimiento(request.getFechaNacimiento());
		response.setFechaVinculacion(request.getFechaVinculacion());
		response.setCargo(request.getCargo());
		response.setSalario(request.getSalario());
		response.setTiempoVinculacion(
				FunctionUtils.vinculacionEmpleado(request.getFechaVinculacion()));
		response.setEdadEmpleado(FunctionUtils.edadEmpleado(request.getFechaNacimiento()));
	}

//	private boolean validarEmpleado(Empleado request) {
//		return Optional.ofNullable(request)
//				.map(emp -> !emp.getNombres().isEmpty() && !emp.getApellidos().isEmpty()
//						&& !emp.getTipoDocumento().isEmpty() && !emp.getNumeroDocumento().isEmpty()
//						&& emp.getFechaVinculacion() != null && emp.getFechaNacimiento() != null
//						&& FunctionUtils.mayorEdad(FunctionUtils.dateToString(emp.getFechaNacimiento())) >= 18)
//				.orElse(false);
//	}
}