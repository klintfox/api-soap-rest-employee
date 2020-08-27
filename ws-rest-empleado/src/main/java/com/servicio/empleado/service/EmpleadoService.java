package com.servicio.empleado.service;

import com.servicio.empleado.dto.EmpleadoResponse;
import com.servicio.empleado.model.Empleado;

public interface EmpleadoService {

	EmpleadoResponse validarEmpleado(Empleado request)throws Exception;

}
