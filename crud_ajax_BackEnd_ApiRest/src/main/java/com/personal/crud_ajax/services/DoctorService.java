package com.personal.crud_ajax.services;

import java.util.List;



import com.personal.crud_ajax.models.Doctor;
import com.personal.crud_ajax.models.Especilidad;
import com.personal.crud_ajax.repositories.IDoctor;
import com.personal.crud_ajax.repositories.IEspecialidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DoctorService
 */
@Service
public class DoctorService {

    @Autowired
    IDoctor rdoctor;
    @Autowired
    IEspecialidad respecialidad;

  
    public List<Doctor> getAll() {
        return (List<Doctor>) rdoctor.findAll();
    }

    public List<Especilidad> getAllEspecialidad() {
        return (List<Especilidad>) respecialidad.findAll();
    }

    public Boolean saveOrUpdate(Doctor entity) {     
        try {
           rdoctor.save(entity);
           return true; 
        } catch (Exception e) {
            return false;
        }
    }

 
    public Boolean delete(Doctor entity) {     
        try {
           rdoctor.delete(entity);
           return true; 
        } catch (Exception e) {
            return false;
        }
    }

    
    public Especilidad getEspecialidad(Integer id) {
        return respecialidad.findById(id).get();
    }

  
    public Doctor getDoctor(Integer id) {
        return rdoctor.findById(id).get();
    }
}