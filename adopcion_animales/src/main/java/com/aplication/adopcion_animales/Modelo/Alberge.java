package com.aplication.adopcion_animales.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * La protectora deberá tener como atributos;
 *  un nombre, una dirección, un teléfono de contacto y 
 * correo electrónico.
 */
@Entity
@Table
public class Alberge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "asociacion")
    private String asociacion;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private int telefono;

    @Column(name = "email")
    private String email;

    public Alberge() {
    }

    public Alberge(String asociacion, String direccion, int telefono, String email) {
        this.asociacion = asociacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getAsociacion() {
        return this.asociacion;
    }

    public void setAsociacion(String asociacion) {
        this.asociacion = asociacion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
            " Asociacion='" + getAsociacion() + "'" +
            ", Direccion='" + getDireccion() + "'" +
            ", Telefono='" + getTelefono() + "'" +
            ", Email='" + getEmail() + "'" +
            "}";
    }
}
