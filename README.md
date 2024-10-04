# Ejercicio Servicio Soap

### Descripción

Implementar en Java un servicio Rest que reciba como parámetros los atributos del objeto empleado(que será descrito más adelante) al ser invocado mediante el método GET. 

El servicio deberá validar los formatos de las fechas y que los atributos no vengan vacíos, adicionalmente deberá validar que el empleado sea mayor de edad.

Una vez se hayan superado estas validaciones se deberá invocar un servicio web SOAP pasando como parámetro el objeto empleado, este último servicio deberá almacenar la información en una base de datos mysql. 

- El método REST responderá con el objeto en estructura JSON, en el que se deberá adicionar la siguiente información:
  - Tiempo de Vinculación a la compañía (años, meses y días).
  - Edad actual del empleado (años, meses y días)

- Atributos del objeto empleado:
  - Nombres (String)
  - Apellidos (String)
  - Tipo de Documento (String)
  - Número de Documento (String)
  - Fecha de Nacimiento (Date)
  - Fecha de Vinculación a la Compañía (Date)
  - Cargo (String)
  - Salario (Double)
  
## Solución

- Clonar proyecto 

	```sh
	git clone https://github.com/klintfox/challenge-soap-empleado.git
	```

### 1 Servicio Soap (ws-soap-empleado-client)

- Paso 1 Una vez importado ejecutar el siguiente comando maven para limpiar e instalar las dependencias desde la carpeta "ws-soap-empleado-client"
	
	```sh
		mvn clean install
	```	
 
- Paso 2 Ver Readme.md de la carpeta ws-soap-empleado-client para mayor detalle.
	
	```sh
		[Texto del enlace](https://github.com/klintfox/challenge-soap-empleado/tree/master/ws-rest-empleado)
	```


### 2 Servicio Rest (ws-rest-empleado)

- Paso 1 posicionarse en el proyecto 

- Paso 2 Una vez importado ejecutar el siguiente comando maven para limpiar e instalar las dependencias desde la carpeta "ws-rest-empleado" 
	
	```sh
		mvn clean install
	```	
 
- Paso 2 Ver Readme.md de la carpeta ws-soap-empleado-client para mayor detalle.
	```sh
		[Texto del enlace](https://github.com/klintfox/challenge-soap-empleado/tree/master/ws-rest-empleado)

	```

### 3 Version Java

- La versión para ambos servicios fue Java17 

