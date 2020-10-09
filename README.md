# Ejemplo Api Creación de Usuarios #

- Gradle
- H2 Bd
- Spock Framework (Basic test)
- Hibernate
- Spring Boot
- Java 8
- JWT Token


# Instrucciones


## 1.- Descargar Proyecto a través de Git

	 git clone https://github.com/arrecho/user-management.git
	 
## 2.- Compilar y generar el ensamblado
	
	./gradlew build
	   
## 3.- Ejecutar
	 
	java -jar build/libs/users-0.0.1-SNAPSHOT.jar

## 4.- Probar API:

	URL POST   : http://localhost:8090/api/v1/users/

## 5.- Se adjunta en Raiz de Proyecto lo siguiente: 

	   user.json  --> Json de Ejemplo valido
	   diagrama_componentes.jpg --> Diagrama Componentes
	   diagrama_secuencia.jpg --> Diagrama Secuencia

#Nota:	
Uso características Java 8  --> Revisar código comentado //TODO JAVA 8
