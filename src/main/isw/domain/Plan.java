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
    private String creador;
    private Integer idPlan;



    public Plan() {
        this.setCreador(new String());
        this.setNombre(new String());
        this.setFecha(new String());
        this.setLugar(new String());
        this.setHora(new String());
        this.setCapacidad(new String());
        this.setPrivacidad(new String());
        this.setDescripcion(new String());
    }
//Plan((String)mensajeIn.getSession().get("nombre"),(String)mensajeIn.getSession().get("fecha"),(String)mensajeIn.getSession().get("lugar"),(String)mensajeIn.getSession().get("hora"),(String)mensajeIn.getSession().get("capacidad"),(String)mensajeIn.getSession().get("privacidad"),(String)mensajeIn.getSession().get("descripcion"))
    public Plan(String nombre, String fecha,String lugar,String hora, String capacidad, String privacidad, String descripcion,String creador,Integer idPlan) {
        this.setNombre(nombre);
        this.setFecha(fecha);
        this.setLugar(lugar);
        this.setHora(hora);
        this.setCapacidad(capacidad);
        this.setPrivacidad(privacidad);
        this.setDescripcion(descripcion);
        this.setCreador(creador);
        this.setIdPlan(idPlan);

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

    public void setCreador(String creador){this.creador=creador;}

    public void setIdPlan(Integer idPlan){this.idPlan=idPlan;}


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

    public String getCreador(){
        return this.creador;
    }

    public Integer getIdPlan(){ return this.idPlan; } ;
}
