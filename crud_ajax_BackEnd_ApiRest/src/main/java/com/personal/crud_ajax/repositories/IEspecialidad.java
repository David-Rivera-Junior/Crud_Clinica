package com.personal.crud_ajax.repositories;

import com.personal.crud_ajax.models.Especilidad;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IEspecialidad
 */
@Repository
public interface IEspecialidad extends CrudRepository<Especilidad,Integer>{

    
}