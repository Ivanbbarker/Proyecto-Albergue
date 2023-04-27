package com.aplication.adopcion_animales.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aplication.adopcion_animales.Modelo.Adoptantes;

public interface AdoptantesRepository extends JpaRepository<Adoptantes, Long> {
    
}
