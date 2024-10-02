package com.servicio.empleado.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FunctionUtils {

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /**
     * Retorna la edad de una persona en años, meses y días.
     * @param fecha de nacimiento en formato "yyyy/MM/dd".
     * @return Cadena con la edad.
     */
    public static String edadEmpleado(String fecha) {
        return calcularEdad(fecha);
    }

    /**
     * Retorna el tiempo de vinculación de una persona en años, meses y días.
     * @param fecha de vinculación en formato "yyyy/MM/dd".
     * @return Cadena con el tiempo de vinculación.
     */
    public static String vinculacionEmpleado(String fecha) {
        return calcularEdad(fecha);
    }

    /**
     * Calcula si una persona es mayor de edad.
     * @param fecha de nacimiento en formato "yyyy/MM/dd".
     * @return Edad en años.
     */
    public static Integer mayorEdad(String fecha) {
        LocalDate fechaNac = LocalDate.parse(fecha, DATE_FORMATTER);
        return Period.between(fechaNac, LocalDate.now()).getYears();
    }

    /**
     * Convierte una fecha de tipo Date a String en formato "yyyy/MM/dd".
     * @param fecha a convertir.
     * @return Cadena con la fecha formateada.
     */
    public static String dateToString(Date fecha) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(fecha);
    }

    /*
     * Calcula la edad de una persona
     * @param fecha a convertir
     * @return Cadena con la edad representada en Años, meses y días
     */
    private static String calcularEdad(String fecha) {
        LocalDate fechaNac = LocalDate.parse(fecha, DATE_FORMATTER);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return String.format("%d años, %d meses y %d días", periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
}
