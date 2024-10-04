# Servicio Soap

Servicio Soap para registrar un empleado en una base de datos H2

## Solución

### Ejecución Servicio Soap

- Paso 1 Posicionarse en el proyecto "ws-soap-empleado-client" ya sea por consola o importandolo desde STS

- Paso 2 Una vez importado ejecutar el siguiente comando maven para limpiar e instalar las dependencias
	
	```sh
		mvn clean install
	```	
 
- Paso 3 Estructura del proyecto
	
	```sh
		ws-soap-empleado-client
		├───main
		│   ├───java
		│   │   └───com
		│   │       └───servicio
		│   │           └───soap
		│   │               └───empleado
		│   │                   │   ServicioSoapEmpleadoApplication.java
		│   │                   │   ServletInitializer.java
		│   │                   │
		│   │                   ├───config
		│   │                   │       EmpleadoEndpoint.java
		│   │                   │       WebServiceConfig.java
		│   │                   │
		│   │                   ├───entity
		│   │                   │       EmployeeEntity.java
		│   │                   │
		│   │                   ├───repository
		│   │                   │       EmpleadoDao.java
		│   │                   │
		│   │                   ├───service
		│   │                   │       EmployeeService.java
		│   │                   │       EmployeeServiceImpl.java
		│   │                   │
		│   │                   └───utils
		│   │                           FunctionUtils.java
		│   │
		│   └───resources
		│       │   application.properties
		│       │
		│       └───xsd
		│               empleado.xsd
		│
		└-pom.xml		
	``` 

- Paso 4 En está sección del archivo pom.xml se indica la configuración para generar las clases a utilizarse en el proyecto
	
	```sh
		<plugin>
			 <groupId>org.codehaus.mojo</groupId>
			<artifactId>jaxb2-maven-plugin</artifactId>
			<version>3.2.0</version>
			<executions>
				<execution>
					<id>xjc</id>
					<goals>
						<goal>xjc</goal>
					</goals>
				</execution>
			</executions>
			<configuration>
				<sources>
					<source>src/main/resources/xsd/empleado.xsd</source>
				</sources>
				<packageName>com.servicio.soap.empleado.gen</packageName>
			</configuration>
			<dependencies>
				<dependency>
					<groupId>jakarta.xml.bind</groupId>
					<artifactId>jakarta.xml.bind-api</artifactId>
					<version>3.0.1</version>
				</dependency>
				<dependency>
					<groupId>org.glassfish.jaxb</groupId>
					<artifactId>jaxb-xjc</artifactId>
					<version>4.0.2</version>
				</dependency>
				<dependency>
					<groupId>com.sun.activation</groupId>
					<artifactId>jakarta.activation</artifactId>
					<version>1.2.2</version>
				</dependency>
			</dependencies>
		</plugin>
	``` 

### Ejecución Servicio Soap 

- Paso 1 Utilizando comandos maven 

-- Abrimos una consola nos posicionamos a la raiz del servicio soap y ejecutamos el siguiente comando maven.
	
	```sh
		mvn spring-boot:run
	``` 

-- Utilizando Spring STS
	Realizamos click derecho en el proyecto y en la opción "Run As" elegimos la opción "Sprin Bboot App"

- Paso 2 Probar utilizando SoapUI
	
	- Si el servidor esta corriendo en el puerto 8080 ingresamos en el navegador lo siguiente:
	
	```sh
		http://localhost:8080/ws/empleados.wsdl
	``` 

	- Guardamos el archivo con la extensión wsdl y lo importamos desde SOAPUI (en el proyecto en "resources/otherTests" hay capturas de H2 y SoapUI


### Java version y dependencias 
	
	```sh
	
		<properties>
			<java.version>17</java.version>
		</properties>

		<dependencies>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-web</artifactId>
			</dependency>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-web-services</artifactId>
			</dependency>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-devtools</artifactId>
				<scope>runtime</scope>
				<optional>true</optional>
			</dependency>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-data-jpa</artifactId>
			</dependency>
			<dependency>
				<groupId>com.h2database</groupId>
				<artifactId>h2</artifactId>
				<scope>runtime</scope>
			</dependency>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-test</artifactId>
				<scope>test</scope>
			</dependency>
			<dependency>
				<groupId>org.projectlombok</groupId>
				<artifactId>lombok</artifactId>
				<optional>true</optional>
			</dependency>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-tomcat</artifactId>
				<scope>provided</scope>
			</dependency>
			<dependency>
				<groupId>wsdl4j</groupId>
				<artifactId>wsdl4j</artifactId>
			</dependency>
		</dependencies>
		
	``` 

### Por Implementar
- Swagger
- DockerFile para ambos servicios
- Creación de Imagen por Servicio
- Creación de Contenedor y que ambos servicios se comuniquen


### Fuera del alcance
- Realización del archivo XSD 
