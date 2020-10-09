package com.bci.users.infraestructure.token;

//TODO JAVA 8 @FunctionalInterface Interfaz que debiese ser utilizada por diversos componentes
@FunctionalInterface 
public interface TokenGeneratorPort {

	
	public String getToken();
	
	
}
