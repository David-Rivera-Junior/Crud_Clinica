package com.personal.crud_ajax.repositories;

import com.personal.crud_ajax.models.Doctor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IDoctor
 */
@Repository
public interface IDoctor extends CrudRepository<Doctor,Integer>{
 
}