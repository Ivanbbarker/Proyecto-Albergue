package com.aplication.adopcion_animales.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.adopcion_animales.Modelo.Adopciones;
import com.aplication.adopcion_animales.Repositorios.AdopcionesRepository;

@Service
public class AdopcionesService {

    @Autowired
    private AdopcionesRepository adopcionesRepository;

    // Encontrar todas las adopciones
    public List<Adopciones> findAll() {
        return adopcionesRepository.findAll();
    }

    // Encontrar una adopcion por ID
    public Adopciones findById(Long id) {
        Optional<Adopciones> adopciones = adopcionesRepository.findById(id);
        if (adopciones.isPresent()) {
            return adopciones.get();
        } else {
            throw new RuntimeException("Adopcion con ID " + id + ", no encontrada.");
        }
    }

    // Guardar una adopcion
    public Adopciones save(Adopciones adopcion) {
        return adopcionesRepository.save(adopcion);
    }

    // Actualizar una adopcion existente
    public Adopciones update(Long id, Adopciones adopcionDetails) {
        Adopciones adopcion = findById(id);

        adopcion.setIdAnimal(adopcionDetails.getIdAnimal());
        adopcion.setIdAdoptante(adopcionDetails.getIdAdoptante());
        adopcion.setFechaAdopcion(adopcionDetails.getFechaAdopcion());
        adopcion.setIdAdopcion(adopcionDetails.getIdAdopcion());

        return adopcionesRepository.save(adopcion);
    }

    public void delete(Long id) {
        Adopciones adopcion = findById(id);
        adopcionesRepository.delete(adopcion);
    }

}
