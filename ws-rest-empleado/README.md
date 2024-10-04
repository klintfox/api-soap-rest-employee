# Servicio Rest 

Servicio Rest consumir el servicio Soap mediante los artefactores generados desde el archivo wsdl

## Solución

### Ejecución Servicio Rest 

- Paso 1 Posicionarse en el proyecto "ws-rest-empleado" ya sea por consola o importandolo desde STS

- Paso 2 Una vez importado ejecutar el siguiente comando maven para limpiar e instalar las dependencias
	
	```sh
		mvn clean install
	```	
 
- Paso 3 Estructura del proyecto

	```sh
		ws-rest-empleado
		├───main
		│   ├───java
		│   │   └───com
		│   │       └───servicio
		│   │           ├───empleado
		│   │           │   │   ServicioEmpleadoApplication.java
		│   │           │   │
		│   │           │   ├───config
		│   │           │   │       JacksonConfig.java
		│   │           │   │       SoapConfig.java
		│   │           │   │
		│   │           │   ├───controller
		│   │           │   │       EmpleadoController.java
		│   │           │   │
		│   │           │   ├───dto
		│   │           │   │       EmpleadoRequest.java
		│   │           │   │       EmpleadoResponse.java
		│   │           │   │
		│   │           │   ├───exception
		│   │           │   │       GlobalExceptionHandler.java
		│   │           │   │
		│   │           │   ├───service
		│   │           │   │   │   EmpleadoService.java
		│   │           │   │   │
		│   │           │   │   └───impl
		│   │           │   │           EmpleadoServiceImpl.java
		│   │           │   │
		│   │           │   └───utils
		│   │           │           FunctionUtils.java
		│   │           │
		│   │           └───ws
		│   │                   AddEmpleadoRequest.java
		│   │                   AddEmpleadoResponse.java
		│   │                   EmpleadoPort.java
		│   │                   EmpleadoPortService.java
		│   │                   EmpleadoType.java
		│   │                   ObjectFactory.java
		│   │                   package-info.java
		│   │                   ServiceStatus.java
		│   │
		│   └───resources
		│       │   application.properties
		│       │   scriptMysql.sql
		│       │
		│       ├───capturas
		│       │       Postmant - TestRestService.png
		│       │
		│       └───wsdl
		│               empleados.wsdl
		│
		└───test
			├───java
			│   └───com
			│       └───servicio
			│           └───empleado
			│                   ServicioEmpleadoApplicationTests.java
	```

	


- Generación clases a partir del wsld

### Java version y dependencias 


### Por Implementar
- Swagger
- DockerFile para ambos servicios
- Creación de Imagen por Servicio
- Creación de Contenedor y que ambos servicios se comuniquen


### Fuera del alcance
- Realización del archivo XSD 