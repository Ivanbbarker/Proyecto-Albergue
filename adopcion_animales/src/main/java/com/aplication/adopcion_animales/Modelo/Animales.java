package com.aplication.adopcion_animales.Modelo;
/*
 * Cada animal debe tener como atributos; 
 * su ID (lo que le identifica o PrimaryKey), raza, 
 * nombre, sexo, tipo, patologías, 
 * y fecha de entrada y salida del centro.
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Animales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "raza")
    private String raza;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private int tipo;

    @Column(name = "patologia")
    private String patologia;

    @Column(name = "fechaEntrada")
    private Date fechaEntrada;

    @Column(name = "fechaSalida")
    private Date fechaSalida;

    public Animales() {
    }

    public Animales(String raza, String nombre, int tipo, String patologia, Date fechaEntrada,
            Date fechaSalida) {
        this.raza = raza;
        this.nombre = nombre;
        this.tipo = tipo;
        this.patologia = patologia;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return this.tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPatologia() {
        return this.patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public Date getFechaEntrada() {
        return this.fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return this.fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "{" +
                " Id='" + getId() + "'" +
                ", Raza='" + getRaza() + "'" +
                ", Nombre='" + getNombre() + "'" +
                ", Tipo='" + getTipo() + "'" +
                ", Patologia='" + getPatologia() + "'" +
                ", FechaEntrada='" + getFechaEntrada() + "'" +
                ", FechaSalida='" + getFechaSalida() + "'" +
                "}";
    }

}
