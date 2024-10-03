package com.servicio.empleado.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmpleadoRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "{nombres.not.null}")
	private String nombres;

	@NotBlank(message = "{apellidos.not.null}")
	private String apellidos;

	@NotBlank(message = "{tipoDocumento.not.null}")
	private String tipoDocumento;

	@NotBlank(message = "{numeroDocumento.not.null}")
	private String numeroDocumento;

	@NotNull(message = "{fechaNacimiento.not.null}")
	@Pattern(regexp = "^\\d{4}/\\d{2}/\\d{2}$", message = "La fecha de nacimiento debe estar en el formato YYYY/MM/DD")
	private String fechaNacimiento;

	@NotNull(message = "{fechaNacimiento.not.null}")
	@Pattern(regexp = "^\\d{4}/\\d{2}/\\d{2}$", message = "La fecha de vinculacion debe estar en el formato YYYY/MM/DD")
	private String fechaVinculacion;

	@NotNull(message = "{cargo.not.null}")
	private String cargo;

	@NotNull(message = "{salario.not.null}")
	@DecimalMin(value = "0.0", inclusive = false, message = "El salario debe ser mayor que cero")
	private Double salario;

}