package icai.dtc.isw.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private String password;
	
	public Customer() {
		this.setNombre(new String());
		this.setApellido(new String());
		this.setPassword(new String());
	}
	
	public Customer(String nombre, String apellido,String password) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setPassword(password);
	}

	public void setPassword(String password) {
		this.password=password;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	public String getNombre(){
		return this.nombre;
	}
	public String getApellido(){
		return this.apellido;
	}
	public String getPassword(){
		return this.password;
	}
	
	
}
