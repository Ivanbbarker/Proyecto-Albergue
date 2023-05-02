package com.aplication.adopcion_animales.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.adopcion_animales.Modelo.Adoptantes;
import com.aplication.adopcion_animales.Repositorios.AdoptantesRepository;

@Service
public class AdoptantesService {
    
    @Autowired
    private AdoptantesRepository adoptantesRepository;
    
    //Encontrar a todos los adoptantes
    public List<Adoptantes> findAll(){
        return adoptantesRepository.findAll();
    }

    //Encontrar a un adoptante por ID
    public Adoptantes findById(Long id){
        Optional<Adoptantes> adoptantes = adoptantesRepository.findById(id);
        if (adoptantes.isPresent()) {
            return adoptantes.get();
        } else {
            throw new RuntimeException("Adoptante con el ID "+ id + "no encontrado.");
        }
    }

    public Adoptantes save(Adoptantes adoptante){
        return adoptantesRepository.save(adoptante);
    }

    //Actualizar un empleo existente
    public Adoptantes update(Long id, Adoptantes adoptanteDetails){
        Adoptantes adoptante = findById(id);

        adoptante.setId(adoptanteDetails.getId());
        adoptante.setNombre(adoptanteDetails.getNombre());
        adoptante.setApellido(adoptanteDetails.getApellido());
        adoptante.setDireccion(adoptanteDetails.getDireccion());
        adoptante.setEmail(adoptanteDetails.getEmail());
        adoptante.setTelefono(adoptanteDetails.getTelefono());

        return adoptantesRepository.save(adoptante);
    }




    public void delete(Long id){
        Adoptantes adoptante = findById(id);
        adoptantesRepository.delete(adoptante);
    }
}
