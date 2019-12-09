package com.personal.crud_ajax.services;

import java.util.List;

import com.personal.crud_ajax.models.Consulta;
import com.personal.crud_ajax.models.Doctor;
import com.personal.crud_ajax.models.Paciente;
import com.personal.crud_ajax.repositories.IConsulta;
import com.personal.crud_ajax.repositories.IDoctor;
import com.personal.crud_ajax.repositories.IPaciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ConsultaService
 */
@Service
public class ConsultaService {

    @Autowired
    IConsulta rConsulta;

    @Autowired
    IDoctor rDoctor;

    @Autowired
    IPaciente rPaciente;

    public List<Consulta> getAll() {
        return (List<Consulta>) rConsulta.findAll();
    }
    public List<Doctor> getAll1() {
        return (List<Doctor>) rDoctor.findAll();
    }
    public List<Paciente> getAll2() {
        return (List<Paciente>) rPaciente.findAll();
    }

    public Boolean saveOrUpdate(Consulta entity) {

        try {
            rConsulta.save(entity);
            return true;
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
            return false;
        }
    }

    public Boolean delete(Consulta entity) {

        try {
            rConsulta.delete(entity);
            return true;
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
            return false;
        }
    }

    public Consulta getConsulta(Integer id) {
        return rConsulta.findById(id).get();
    }

    public Doctor getDoctor(Integer id) {
        return rDoctor.findById(id).get();
    }

    public Paciente getPaciente(Integer id) {
        return rPaciente.findById(id).get();
    }

}