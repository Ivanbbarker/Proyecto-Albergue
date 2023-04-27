package com.aplication.adopcion_animales.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*Los adoptantes deben tener como atributos su ID 
(lo que le identifica o PrimaryKey), nombre, apellido, 
teléfono, correo y dirección(Calle, Número, Población, 
Ciudad).
 */
@Entity
@Table
public class Adoptantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "email")
    private String email;


    public Adoptantes() {
    }

    public Adoptantes(String nombre, String apellido, String direccion, int telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", Nombre='" + getNombre() + "'" +
            ", Apellido='" + getApellido() + "'" +
            ", Direccion='" + getDireccion() + "'" +
            ", Telefono='" + getTelefono() + "'" +
            ", Email='" + getEmail() + "'" +
            "}";
    }
    

}
