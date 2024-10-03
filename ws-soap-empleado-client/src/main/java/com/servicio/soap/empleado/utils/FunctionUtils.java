package com.servicio.soap.empleado.utils;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

public class FunctionUtils {

	/*
	 * Converts XMLGregorianCalendar to java.util.Date in Java
	 */
	public static Date toDate(XMLGregorianCalendar calendar) {
		if (calendar == null) {
			return null;
		}
		return calendar.toGregorianCalendar().getTime();
	}

	

}
