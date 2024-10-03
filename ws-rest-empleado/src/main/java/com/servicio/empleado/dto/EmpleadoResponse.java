package com.servicio.empleado.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmpleadoResponse implements Serializable {

	private static final long serialVersionUID = 7959494588290592509L;

	private String nombres;

	private String apellidos;

	private String tipoDocumento;

	private String numeroDocumento;

	private String fechaNacimiento;

	private String fechaVinculacion;

	private String cargo;

	private Double salario;

	private String tiempoVinculacion;

	private String edadEmpleado;

}