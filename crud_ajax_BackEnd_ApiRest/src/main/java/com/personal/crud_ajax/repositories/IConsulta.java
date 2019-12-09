package com.personal.crud_ajax.repositories;

import com.personal.crud_ajax.models.Consulta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IConsulta
 */
@Repository
public interface IConsulta extends CrudRepository<Consulta,Integer> {

    
}