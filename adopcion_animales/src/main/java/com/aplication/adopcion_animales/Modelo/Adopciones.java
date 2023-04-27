package com.aplication.adopcion_animales.Modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Adopciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdopcion")
    private long idAdopcion;
    
    @Column(name = "idAnimal")
    private long idAnimal;
    
    @Column(name = "idAdoptante")
    private long idAdoptante;

    @Column(name = "fechaAdopcion")
    private Date fechaAdopcion;

    public Adopciones() {
    }

    public Adopciones(long idAnimal, long idAdoptante, Date fechaAdopcion) {
        this.idAnimal = idAnimal;
        this.idAdoptante = idAdoptante;
        this.fechaAdopcion = fechaAdopcion;
    }

    public long getIdAdopcion() {
        return this.idAdopcion;
    }

    public void setIdAdopcion(long idAdopcion) {
        this.idAdopcion = idAdopcion;
    }

    public long getIdAnimal() {
        return this.idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public long getIdAdoptante() {
        return this.idAdoptante;
    }

    public void setIdAdoptante(long idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public Date getFechaAdopcion() {
        return this.fechaAdopcion;
    }

    public void setFechaAdopcion(Date fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }

    @Override
    public String toString() {
        return "{" +
            " idAdopcion='" + getIdAdopcion() + "'" +
            ", idAnimal='" + getIdAnimal() + "'" +
            ", idAdoptante='" + getIdAdoptante() + "'" +
            ", fechaAdopcion='" + getFechaAdopcion() + "'" +
            "}";
    }

}
