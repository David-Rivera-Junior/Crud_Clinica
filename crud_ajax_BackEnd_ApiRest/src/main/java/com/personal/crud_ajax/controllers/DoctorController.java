package com.personal.crud_ajax.controllers;

import java.util.HashMap;
import java.util.List;



import com.personal.crud_ajax.models.Doctor;
import com.personal.crud_ajax.models.Especilidad;
import com.personal.crud_ajax.repositories.IDoctor;
import com.personal.crud_ajax.services.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * DoctorController
 */
@Controller
@RequestMapping("doctores")
public class DoctorController {

    //repositorio para el manejo de datos
    @Autowired
    DoctorService doctorService;


    //listar registros
    @GetMapping(value="all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin
    public List<Doctor> getAllDoctor() {

        return (List<Doctor>) doctorService.getAll();
    }

     //listar registros
     @GetMapping(value="getDoctor/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseBody
     @CrossOrigin
     public Doctor getDoctor(@PathVariable Integer id) {
 
         return  doctorService.getDoctor(id);
     }

    //listar registros
    @GetMapping(value="allEspecialidad",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin
    public List<Especilidad> getAllEspecialidad() {

        return (List<Especilidad>) doctorService.getAllEspecialidad();
    }

    //guardar
    @GetMapping(value="save")
    @ResponseBody
    @CrossOrigin
    public HashMap<String,String> save(@RequestParam String nombre,
                        @RequestParam String direccion,
                        @RequestParam Integer idEspecialidad) {
      
        HashMap<String,String> jsonReturn=new HashMap<>();
        
        Doctor doctor=new Doctor(); //creando objeto de doctor
        //asignando datos al objeto de doctor
        doctor.setNombre(nombre);
        doctor.setDireccion(direccion);
        
        doctor.setEspecialidad(doctorService.getEspecialidad(idEspecialidad));
        //manejando cualquier excepcion de error
        try {
            doctorService.saveOrUpdate(doctor); //guardando registro de doctor

            jsonReturn.put("estado", "OK");
            jsonReturn.put("mensaje", "Registro guardado");

            return jsonReturn;
        } catch (Exception e) {
            jsonReturn.put("estado", "ERROR");
            jsonReturn.put("mensaje", "Registro no guardado, "+e.getMessage());
            
            return jsonReturn;
        }
    }
    

    //actualizar
    @GetMapping(value="update/{id}")
    @ResponseBody
    @CrossOrigin
    public HashMap<String,String> update(@RequestParam Integer id,
                        @RequestParam String nombre,
                        @RequestParam String direccion,
                        @RequestParam Integer idEspecialidad) {
        Doctor doctor=new Doctor(); //creando objeto de doctor
        HashMap<String,String> jsonReturn=new HashMap<>();

        //asignando datos al objeto de doctor
        doctor.setId(id);
        doctor.setNombre(nombre);
        doctor.setDireccion(direccion);
        doctor.setEspecialidad(doctorService.getEspecialidad(idEspecialidad));

        //manejando cualquier excepcion de error
        try {
            doctorService.saveOrUpdate(doctor); //guardando registro de doctor

            jsonReturn.put("estado", "OK");
            jsonReturn.put("mensaje", "Registro actualizado");

            return jsonReturn;
        } catch (Exception e) {
            jsonReturn.put("estado", "ERROR");
            jsonReturn.put("mensaje", "Registro no actualizado, "+e.getMessage());
            
            return jsonReturn;
        }
    }
    
    
    //eliminar
    @GetMapping(value="delete/{id}")
    @ResponseBody
    @CrossOrigin
    public HashMap<String,String> delete(@PathVariable Integer id) {
        HashMap<String,String> jsonReturn=new HashMap<>();
        try {
            //buscando registro
            Doctor doctor=doctorService.getDoctor(id);
            //eliminando registro
            doctorService.delete(doctor);

            jsonReturn.put("estado", "OK");
            jsonReturn.put("mensaje", "Registro eliminado");
            return jsonReturn;
        } catch (Exception e) {
            jsonReturn.put("estado", "ERROR");
            jsonReturn.put("mensaje", "Registro no eliminado, "+e.getMessage());
            
            return jsonReturn;
        }
        
    }
    
}