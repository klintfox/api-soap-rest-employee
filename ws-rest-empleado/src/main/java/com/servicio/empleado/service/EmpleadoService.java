package com.servicio.empleado.service;


import com.servicio.empleado.dto.EmpleadoRequest;
import com.servicio.empleado.dto.EmpleadoResponse;

public interface EmpleadoService {

	EmpleadoResponse saveEmpleado(EmpleadoRequest request)throws Exception;

}