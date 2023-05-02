package com.aplication.adopcion_animales.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.aplication.adopcion_animales.Modelo.Adopciones;
import com.aplication.adopcion_animales.Servicios.AdopcionesService;

@Controller
@RequestMapping("/adopciones")
public class AdopcionesController {
    
    @Autowired
    private AdopcionesService adopcionesService;

    // Obtener todos los animales (GET)
    @GetMapping
    public ResponseEntity<List<Adopciones>> getAllAnimales() {
        List<Adopciones> adopcion = adopcionesService.findAll();
        return new ResponseEntity<>(adopcion, HttpStatus.OK);
    }

    // Obtener un animal por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Adopciones> getAnimalesById(@PathVariable Long id) {
        Adopciones adopciones = adopcionesService.findById(id);
        return new ResponseEntity<>(adopciones, HttpStatus.OK);
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
        Adopciones adopcion = adopcionesService.findById(id);
        model.addAttribute("adopcion", adopcion);
        return "/views/Adopciones/adopcion-detalle";
    }

    // Crear un nuevo animal (POST)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Adopciones> createAnimal(@ModelAttribute Adopciones adopcion) {
        Adopciones newAnimal = adopcionesService.save(adopcion);
        return new ResponseEntity<>(newAnimal, HttpStatus.CREATED);
    }

    //Actualizar un animal existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Adopciones> updateAnimal(@PathVariable Long id, @RequestBody Adopciones adopcion){
        Adopciones updatedAdopcion = adopcionesService.update(id, adopcion);
        return new ResponseEntity<>(updatedAdopcion, HttpStatus.OK);
    }

    // Eliminar una bicicleta por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id){
        adopcionesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Creando la interfaz web
    public AdopcionesController(AdopcionesService adopcionesService){
        this.adopcionesService = adopcionesService;
    }

    @GetMapping("/listado-adopciones")
    public String listarAnimales(Model model){
        List<Adopciones> adopcion = adopcionesService.findAll();
        model.addAttribute("adopciones", adopcion);
        model.addAttribute("adopciones", new Adopciones());
        return "/views/Adopciones/listado-adopciones";
    }
}
