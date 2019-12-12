package com.personal.crud_ajax.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Doctor
 */
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    
    private String direccion;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Especilidad especialidad;



    //CONSTRUCTORES
    public Doctor() {
       
    }

    public Doctor(String nombre,String direccion) {
       this.nombre=nombre;
       this.direccion=direccion;
    }

    //SETTER Y GETTER
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(Especilidad especialidad) {
        this.especialidad = especialidad;
    }
    /**
     * @return the especialidad
     */
    public Especilidad getEspecialidad() {
        return especialidad;
    }
}