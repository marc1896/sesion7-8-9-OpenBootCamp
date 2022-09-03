package com.example.agendacontactos.clases;

import java.time.LocalDateTime;
import java.util.Date;

public class Persona {
    //Atributos
    private int id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private LocalDateTime fechaCreacion;
    private String telelfono;
    private String movil;
    private String direccion;
    private String email;

    //Constructores
    public Persona() {}

    public Persona(int id, String nombre, String apellidoP, String apellidoM, LocalDateTime fechaCreacion, String telelfono, String movil, String direccion, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaCreacion = fechaCreacion;
        this.telelfono = telelfono;
        this.movil = movil;
        this.direccion = direccion;
        this.email = email;
    }

    public Persona(String nombre, String apellidoP, String apellidoM, LocalDateTime fechaCreacion, String telelfono, String movil, String direccion, String email) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaCreacion = fechaCreacion;
        this.telelfono = telelfono;
        this.movil = movil;
        this.direccion = direccion;
        this.email = email;
    }

    //Metodos
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoP='" + apellidoP + '\'' +
                ", apellidoM='" + apellidoM + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", telelfono=" + telelfono +
                ", movil=" + movil +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTelelfono() {
        return telelfono;
    }

    public void setTelelfono(String telelfono) {
        this.telelfono = telelfono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
