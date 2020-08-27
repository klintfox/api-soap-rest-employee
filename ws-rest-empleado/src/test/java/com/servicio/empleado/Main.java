package com.servicio.empleado;

import com.servicio.empleado.utils.FunctionUtils;

public class Main {

	public static void main(String[] args) {
		
		String fecha = FunctionUtils.vinculacionEmpleado("2020/03/02");
		String edad = FunctionUtils.edadEmpleado("1987/02/06");
		Integer mayorEdad = FunctionUtils.mayorEdad("2002/02/06");
		System.out.println("fechaVinculación: "+fecha);
		System.out.println("edad: "+edad);
		System.out.println("mayor edad: "+mayorEdad);
	}

}
