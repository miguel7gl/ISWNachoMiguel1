package main.isw.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String correo;
	private String password;
	
	public Customer() {
		this.setNombre(new String());
		this.setCorreo(new String());
		this.setPassword(new String());
	}
	
	public Customer(String nombre, String correo,String password) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
	}

	public void setPassword(String password) {
		this.password=password;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setCorreo(String correo) {
		this.correo=correo;
	}
	public String getNombre(){
		return this.nombre;
	}
	public String getCorreo(){
		return this.correo;
	}
	public String getPassword(){
		return this.password;
	}
	
	
}
