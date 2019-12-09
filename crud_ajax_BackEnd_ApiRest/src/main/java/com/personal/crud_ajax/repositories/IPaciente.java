package com.personal.crud_ajax.repositories;

import com.personal.crud_ajax.models.Paciente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IPaciente
 */
@Repository
public interface IPaciente extends CrudRepository<Paciente,Integer> {

    
}