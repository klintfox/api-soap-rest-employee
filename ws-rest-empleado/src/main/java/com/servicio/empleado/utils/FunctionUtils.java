package com.servicio.empleado.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FunctionUtils {

	/**
	 * Retorna la edad de una persona en años, meses y días
	 * @param localdate
	 * @return
	 */
	public static String edadEmpleado(String fecha) {
		String edad = "";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		edad = periodo.getYears() + " años ," + periodo.getMonths() + " meses y " + periodo.getDays()+" días";
		return edad;
	}
	
	/**
	 * Retorna el tiempo de vinculación de una persona en años, meses y días
	 * @param localdate
	 * @return
	 */
	public static String vinculacionEmpleado(String fecha) {
		String edad = "";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		edad = periodo.getYears() + " años ," + periodo.getMonths() + " meses y " + periodo.getDays()+" días";
		return edad;
	}
	
	/**
	 * Calcula si una persona es mayor de edad
	 * @param localdate
	 * @return
	 */
	public static Integer mayorEdad(String fecha) {
		Integer edad = 0;
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate fechaNac = LocalDate.parse(fecha, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		edad = periodo.getYears();
		return edad;
	}
	
	public static String datetoString (Date fecha) {
		String pattern = "yyyy/MM/dd"; //MM/dd/yyyy HH:mm:ss
		DateFormat df = new SimpleDateFormat(pattern);
//		Date today = Calendar.getInstance().getTime();        
		String todayAsString = df.format(fecha);
		
		return todayAsString;
	}
}
