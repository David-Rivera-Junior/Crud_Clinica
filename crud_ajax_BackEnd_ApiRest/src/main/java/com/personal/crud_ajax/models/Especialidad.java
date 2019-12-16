//package com.personal.crud_ajax.models;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

/**
 * Especilidad
 
@Entity
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String especialidad;

    public Especialidad() {
        super();
    }
    public Especialidad(String especialidad) {
      this.especialidad=especialidad;
    }

    /**
     * @param id the id to set
     
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the id
     
    public Integer getId() {
        return id;
    }

    /**
     * @param especialidad the especialidad to set
     
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    /**
     * @return the especialidad
     
    public String getEspecialidad() {
        return especialidad;
    }
}*/