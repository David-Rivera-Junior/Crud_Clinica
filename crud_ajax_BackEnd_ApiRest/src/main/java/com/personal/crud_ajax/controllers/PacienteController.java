package com.personal.crud_ajax.controllers;

import java.util.HashMap;
import java.util.List;

import com.personal.crud_ajax.models.Paciente;
import com.personal.crud_ajax.repositories.IPaciente;

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
 * PacienteController
 */
@Controller
@CrossOrigin
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    IPaciente rPaciente;

    // listar registros
    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Paciente> getAllPaciente() {
        return (List<Paciente>) rPaciente.findAll();
    }

    // Guardar
    @GetMapping(value = "save")
    @ResponseBody
    public HashMap<String, String> save(@RequestParam String nombre, @RequestParam String direccion) {
        Paciente registro = new Paciente(); // Creando objeto de Paciente
        HashMap<String, String> jsonReturn = new HashMap<>();

        // Asignando datos de objetos de paciente
        registro.setNombre(nombre);
        registro.setDireccion(direccion);

        // Manejando cualquier exception de erro
        try {
            rPaciente.save(registro);

            jsonReturn.put("estado", "OK");
            jsonReturn.put("mensaje", "Registro guardado");

            return jsonReturn;
        } catch (Exception e) {
            jsonReturn.put("estado", "ERROR");
            jsonReturn.put("mensaje", "Registro no guardado, " + e.getMessage());

            return jsonReturn;

        }
    }

    // Actualizar
    @GetMapping(value = "update/{id}")
    @ResponseBody
    public HashMap<String, String> update(@RequestParam Integer id, @RequestParam String nombre,
            @RequestParam String direccion) {
        Paciente registro = new Paciente(); // Creando objto de Paciente
        HashMap<String, String> jsonReturn = new HashMap<>();

        // Asignando dato del objeto de Paciente
        registro.setId(id);
        registro.setNombre(nombre);
        registro.setDireccion(direccion);

        // manejando cualquier excepcion de error
        try {
            rPaciente.save(registro); // guardando registro de doctor

            jsonReturn.put("estado", "OK");
            jsonReturn.put("mensaje", "Registro actualizado");

            return jsonReturn;
        } catch (Exception e) {
            jsonReturn.put("estado", "ERROR");
            jsonReturn.put("mensaje", "Registro no actualizado, " + e.getMessage());

            return jsonReturn;
        }
    }

    @GetMapping(value = "obtener/{id}")
    @ResponseBody
    public Paciente obtenerPaciente(@PathVariable Integer id) {
        return rPaciente.findById(id).get();
    }

    // Eliminar
    @GetMapping(value = "delete/{id}")
    @ResponseBody
    public HashMap<String, String> delete(@PathVariable Integer id) {
        HashMap<String, String> jsonReturn = new HashMap<>();
        try {
            // buscando registro
            Paciente registro = rPaciente.findById(id).get();
            // eliminando registro
            rPaciente.delete(registro);

            jsonReturn.put("estado", "OK");
            jsonReturn.put("mensaje", "Registro eliminado");
            return jsonReturn;
        } catch (Exception e) {
            jsonReturn.put("estado", "ERROR");
            jsonReturn.put("mensaje", "Registro no eliminado, " + e.getMessage());

            return jsonReturn;
        }

    }
}
