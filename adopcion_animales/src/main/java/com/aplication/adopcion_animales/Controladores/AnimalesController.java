package com.aplication.adopcion_animales.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aplication.adopcion_animales.Modelo.Animales;
import com.aplication.adopcion_animales.Servicios.AnimalesService;

@Controller
@RequestMapping("/animales")
public class AnimalesController {

    @Autowired
    private AnimalesService animalesService;

    // Obtener todos los animales (GET)
    @GetMapping
    public ResponseEntity<List<Animales>> getAllAnimales() {
        List<Animales> animales = animalesService.findAll();
        return new ResponseEntity<>(animales, HttpStatus.OK);
    }

    // Obtener un animal por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Animales> getAnimalesById(@PathVariable Long id) {
        Animales animales = animalesService.findById(id);
        return new ResponseEntity<>(animales, HttpStatus.OK);
    }

    // Crear un nuevo animal (POST)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Animales> createAnimal(@ModelAttribute Animales animal){
        Animales newAnimal = animalesService.save(animal);
        return new ResponseEntity<>(newAnimal, HttpStatus.CREATED);
    }
    
    /*****************************************************************/

}
