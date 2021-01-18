package com.johancap115.miagenda;

import java.io.Serializable;

public class Contacto implements Serializable {
    private String Nombre;
    private String fecha_nac;
    private String telefono;
    private String email;
    private String descripcion;

    public Contacto(String nombre, String telefono, String email) {
        Nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Contacto(String nombre, String fecha_nac, String telefono, String email, String descripcion) {
        Nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
