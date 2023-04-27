package com.aplication.adopcion_animales.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aplication.adopcion_animales.Modelo.Adopciones;

public interface AdopcionesRepository extends JpaRepository<Adopciones, Long>{
    
}
