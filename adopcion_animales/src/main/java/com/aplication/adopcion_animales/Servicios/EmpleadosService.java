package com.aplication.adopcion_animales.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.adopcion_animales.Modelo.Empleados;
import com.aplication.adopcion_animales.Repositorios.EmpleadosRepository;

@Service
public class EmpleadosService {
    
    @Autowired
    private EmpleadosRepository empleadosRepository;

    //Encontrar a todos los empleados
    public List<Empleados> findAll(){
        return empleadosRepository.findAll();
    }

    //Encontrar a un empleado por su ID
    public Empleados findById(Long id){
        Optional<Empleados> empleados = empleadosRepository.findById(id);
        if (empleados.isPresent()) {
            return empleados.get();
        } else {
            throw new RuntimeException("Empleado con el ID "+ id +" no encontrado.");
        }
    }

    public Empleados save(Empleados empleado){
        return empleadosRepository.save(empleado);
    }

    public Empleados update(Long id, Empleados empleadoDetails){
        Empleados empleado = findById(id);

        empleado.setId(empleadoDetails.getId());
        empleado.setNombre(empleadoDetails.getNombre());
        empleado.setEspecializacion(empleadoDetails.getEspecializacion());
        empleado.setCargo(empleadoDetails.getCargo());
        
        return empleadosRepository.save(empleado);
    }


    public void delete(Long id){
        Empleados empleado = findById(id);
        empleadosRepository.delete(empleado);
    }



}
