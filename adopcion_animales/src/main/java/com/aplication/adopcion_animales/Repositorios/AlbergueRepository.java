package com.aplication.adopcion_animales.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aplication.adopcion_animales.Modelo.Alberge;

public interface AlbergueRepository extends JpaRepository<Alberge, Long> {
    
}
