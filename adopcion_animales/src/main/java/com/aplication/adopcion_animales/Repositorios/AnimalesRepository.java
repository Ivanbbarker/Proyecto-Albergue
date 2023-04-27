package com.aplication.adopcion_animales.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aplication.adopcion_animales.Modelo.Animales;

public interface AnimalesRepository extends JpaRepository<Animales, Long> {
    
}
