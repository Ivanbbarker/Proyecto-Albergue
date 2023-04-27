package com.aplication.adopcion_animales.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.adopcion_animales.Modelo.Animales;
import com.aplication.adopcion_animales.Repositorios.AnimalesRepository;

@Service
public class AnimalesService {
    
    @Autowired
    private AnimalesRepository animalesRepository;

    //Encontrar todos los animales
    public List<Animales> findAll(){
        return animalesRepository.findAll();
    }

    //Encontrar un animal por un ID
    public Animales findById(Long id){
        Optional<Animales> animales = animalesRepository.findById(id);
        if (animales.isPresent()) {
            return animales.get();
        } else {
            throw new RuntimeException("Animal con el ID "+ id +" no encontrado.");
        }
    }

    //Guardar un animal
    public Animales save(Animales animal){
        return animalesRepository.save(animal);
    }

    //Actualizar un animal existente
    public Animales update(Long id, Animales animalDetails){
        Animales animal = findById(id);

        animal.setRaza(animalDetails.getRaza());
        animal.setFechaEntrada(animalDetails.getFechaEntrada());
        animal.setNombre(animalDetails.getNombre());
        animal.setPatologia(animalDetails.getPatologia());
        animal.setRaza(animalDetails.getRaza());
        animal.setTipo(animalDetails.getTipo());
        animal.setId(animalDetails.getId());

        return animalesRepository.save(animal);
    }

    public void delete(Long id){
        Animales animal = findById(id);
        animalesRepository.delete(animal);
    }

}
