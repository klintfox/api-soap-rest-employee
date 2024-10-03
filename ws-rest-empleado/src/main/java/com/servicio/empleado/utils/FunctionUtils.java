package com.servicio.empleado.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FunctionUtils {

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	/*
	 * Calcula la edad de una persona
	 * 
	 * @param fecha a convertir
	 * 
	 * @return Cadena con la edad representada en Años, meses y días
	 */
	public static String calcularEdadEmpleado(String fecha) {
		LocalDate fechaNac = LocalDate.parse(fecha, DATE_FORMATTER);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		return String.format("%d años, %d meses y %d días", periodo.getYears(), periodo.getMonths(), periodo.getDays());
	}

	/*
	 * Convierte un LocalDate a String
	 * 
	 * @param fechaVinculacion
	 * 
	 * @return cadena con la información del tiempo de vinculacion
	 */
	public static String calcularTiempoVinculacion(String fecha) {
		LocalDate fechaVinculacion = LocalDate.parse(fecha, DATE_FORMATTER);
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaVinculacion, hoy);
		return String.format("%d años, %d meses y %d días", periodo.getYears(), periodo.getMonths(), periodo.getDays());
	}

}
