package com.aplication.adopcion_animales.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aplication.adopcion_animales.Modelo.Empleados;

public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {
    
}
