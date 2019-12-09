package com.personal.crud_ajax.controllers;

import java.util.HashMap;
import java.util.List;

import com.personal.crud_ajax.models.Especilidad;
import com.personal.crud_ajax.repositories.IEspecialidad;

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
 * EspecialidadController
 */
@Controller
@CrossOrigin
@RequestMapping("especialidades")
public class EspecialidadController {
    
   @Autowired
   IEspecialidad respecialidad;

    //listar registros
    @GetMapping(value="all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Especilidad> getAllDoctor() {

        return (List<Especilidad>) respecialidad.findAll();
    }

    //guardar
    @GetMapping(value="save")
    @ResponseBody
    public HashMap<String,String> save(@RequestParam String especialidad) {
        Especilidad registro=new Especilidad(); //creando objeto de doctor
        HashMap<String,String> jsonReturn=new HashMap<>();

        //asignando datos al objeto de doctor
        registro.setEspecialidad(especialidad);

        //manejando cualquier excepcion de error
        try {
            respecialidad.save(registro); //guardando registro de doctor

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
    public HashMap<String,String> update(@RequestParam Integer id,
                        @RequestParam String especialidad) {
            Especilidad registro=new Especilidad(); //creando objeto de doctor
        HashMap<String,String> jsonReturn=new HashMap<>();

        //asignando datos al objeto de doctor
        registro.setId(id);
        registro.setEspecialidad(especialidad);

        //manejando cualquier excepcion de error
        try {
            respecialidad.save(registro); //guardando registro de doctor

            jsonReturn.put("estado", "OK");
            jsonReturn.put("mensaje", "Registro actualizado");

            return jsonReturn;
        } catch (Exception e) {
            jsonReturn.put("estado", "ERROR");
            jsonReturn.put("mensaje", "Registro no actualizado, "+e.getMessage());
            
            return jsonReturn;
        }
    }
    
    @GetMapping(value = "obtener/{id}")
    @ResponseBody
    public Especilidad obtenerEspecialidad(@PathVariable Integer id) {
    	return respecialidad.findById(id).get();
    }
    
    

    //eliminar
    @GetMapping(value="delete/{id}")
    @ResponseBody
    public HashMap<String,String> delete(@PathVariable Integer id) {
        HashMap<String,String> jsonReturn=new HashMap<>();
        try {
            //buscando registro
            Especilidad registro=respecialidad.findById(id).get();
            //eliminando registro
            respecialidad.delete(registro);

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