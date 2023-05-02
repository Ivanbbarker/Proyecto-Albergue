package com.aplication.adopcion_animales.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.aplication.adopcion_animales.Modelo.Empleados;
import com.aplication.adopcion_animales.Servicios.EmpleadosService;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {
    
    @Autowired
    private EmpleadosService empleadosService;

    //Obtener todos los empleados
    @GetMapping
    public ResponseEntity<List<Empleados>> getAllEmpleados(){
        List<Empleados> empleados = empleadosService.findAll();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    //Obtener un empleado por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Empleados> getEmpleadosById(@PathVariable Long id){
        Empleados empleados = empleadosService.findById(id);
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
    
    //Obtener un empleado para editar en html
    @GetMapping("/detalle/{id}")
    public String verEmpleadoDetalle(@PathVariable Long id, Model model){
        Empleados empleado = empleadosService.findById(id);
        model.addAttribute("empleado", empleado);
        return "/views/Empleados/empleados-detalle"; 
    }

    //Crear un nuevo empleado (POST)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Empleados> createEmpleado(@ModelAttribute Empleados empleado){
        Empleados newEmpleado = empleadosService.save(empleado);
        return new ResponseEntity<>(newEmpleado, HttpStatus.CREATED);
    }

    //Actualizar un empleado existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Empleados> updateEmpleado(@PathVariable Long id, @RequestBody Empleados empleado ){
        Empleados updatedEmpleado = empleadosService.update(id, empleado);
        return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
    }

    //Eliminar un empleado por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        empleadosService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Creando la interfaz web
    public EmpleadosController(EmpleadosService empleadosService){
        this.empleadosService = empleadosService;
    }

    @GetMapping("/listado-empleados")
    public String listarEmpleados(Model model){
        List<Empleados> empleados = empleadosService.findAll();
        model.addAttribute("empleados", empleados);
        model.addAttribute("empleados", new Empleados());
        return "/views/Empleados/listado-empleados";
    }

}
