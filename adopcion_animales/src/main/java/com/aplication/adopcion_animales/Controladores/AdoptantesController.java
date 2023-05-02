package com.aplication.adopcion_animales.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.aplication.adopcion_animales.Modelo.Adoptantes;
import com.aplication.adopcion_animales.Servicios.AdoptantesService;

@Controller
@RequestMapping("/adoptantes")
public class AdoptantesController {

    @Autowired
    private AdoptantesService adoptantesService;

    // Obtener todos los adoptantes (GET)
    @GetMapping
    public ResponseEntity<List<Adoptantes>> getAllAdoptantes() {
        List<Adoptantes> adoptantes = adoptantesService.findAll();
        return new ResponseEntity<>(adoptantes, HttpStatus.OK);
    }

    // Obtener adoptante por un ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Adoptantes> getAdoptantesById(@PathVariable Long id){
        Adoptantes adoptantes = adoptantesService.findById(id);
        return new ResponseEntity<>(adoptantes, HttpStatus.OK);
    }

    // Obtener un adoptante para editar en html
    @GetMapping("/detalle/{id}")
    public String verAdoptantesDetalle(@PathVariable Long id, Model model){
        Adoptantes adoptante = adoptantesService.findById(id);
        model.addAttribute("adoptante", adoptante);
        return "/view/Adoptantes/adoptante-detalle";
    }

    // Crear un nuevo animal (POST)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Adoptantes> createAdoptante(@ModelAttribute Adoptantes adoptante){
        Adoptantes newAdoptante = adoptantesService.save(adoptante);
        return new ResponseEntity<>(newAdoptante, HttpStatus.CREATED);
    }

    // Actualizar un adoptante existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Adoptantes> updateAdoptante(@PathVariable Long id, @RequestBody Adoptantes adoptante){
        Adoptantes updatedAdoptantes = adoptantesService.update(id, adoptante);
        return new ResponseEntity<>(updatedAdoptantes, HttpStatus.OK);
    }

    // Eliminar un adoptante por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdoptante(@PathVariable Long id){
        adoptantesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Creando la interfaz web
    public AdoptantesController(AdoptantesService adoptantesService){
        this.adoptantesService = adoptantesService;
    }

    @GetMapping("/lisatdo-adoptantes")
    public String listarAdoptantes(Model model){
        List<Adoptantes> adoptantes = adoptantesService.findAll();
        model.addAttribute("adoptantes", adoptantes);
        model.addAttribute("adoptantes", new Adoptantes());
        return "/views/Adoptantes/listado-adoptantes";
    }

}
