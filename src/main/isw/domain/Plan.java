package main.isw.domain;

import java.io.Serializable;

public class Plan implements Serializable{

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String fecha;
    private String lugar;
    private String hora;
    private String capacidad;
    private String privacidad;
    private String descripcion;

    public Plan() {
        this.setNombre(new String());
        this.setFecha(new String());
        this.setLugar(new String());
        this.setHora(new String());
        this.setCapacidad(new String());
        this.setPrivacidad(new String());
        this.setDescripcion(new String());
    }

    public Plan(String nombre, String fecha,String hora, String capacidad, String privacidad, String descripcion) {
        this.setNombre(nombre);
        this.setFecha(fecha);
        this.setLugar(lugar);
        this.setHora(hora);
        this.setCapacidad(capacidad);
        this.setPrivacidad(privacidad);
        this.setDescripcion(descripcion);
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public String getHora() {
        return hora;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public String getPrivacidad() {
        return privacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
