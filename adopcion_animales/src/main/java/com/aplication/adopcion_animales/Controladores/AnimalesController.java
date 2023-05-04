package com.aplication.adopcion_animales.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /*
     * //Obetener un animal por su tipo
     * 
     * @GetMapping("/tipo")
     * public ResponseEntity<List<Animales>> getAnimalesPorTipo(@RequestParam String
     * Tipo){
     * List<Animales> animales = animalesService.findByTipo(Tipo);
     * return new ResponseEntity<>(animales, HttpStatus.OK);
     * }
     */

    // Obtener un animal para editar en html
    @GetMapping("/detalle/{id}")
    public String verAnimalDetalle(@PathVariable Long id, Model model) {
        Animales animal = animalesService.findById(id);
        model.addAttribute("animal", animal);
        return "/views/Animales/animal-detalle";
    }

    // Crear un nuevo animal (POST)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Animales> createAnimal(@ModelAttribute Animales animal) {
        Animales newAnimal = animalesService.save(animal);
        return new ResponseEntity<>(newAnimal, HttpStatus.CREATED);
    }

    //Actualizar un animal existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Animales> updateAnimal(@PathVariable Long id, @RequestBody Animales animal){
        Animales updatedAnimal = animalesService.update(id, animal);
        return new ResponseEntity<>(updatedAnimal, HttpStatus.OK);
    }

    // Eliminar una bicicleta por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id){
        animalesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Creando la interfaz web
    public AnimalesController(AnimalesService animalesService){
        this.animalesService = animalesService;
    }

    @GetMapping("/animales/listado-animales")
    public String listarAnimales(Model model){
        List<Animales> animales = animalesService.findAll();
        model.addAttribute("animales", animales);
        model.addAttribute("animales", new Animales());
        return "listado-animales";
    }

}
