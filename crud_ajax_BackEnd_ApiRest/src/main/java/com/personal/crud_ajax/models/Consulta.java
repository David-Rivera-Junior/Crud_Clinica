package com.personal.crud_ajax.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Consulta
 */
@Entity
public class Consulta {

    @Id
    private Integer id;

    private Date fecha;
    
    

    private String diagnostico;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

 //CONSTRUCTORES
    public Consulta() {
        super();
    }
    public Consulta(Date fecha, String diagnostico) {
    this.fecha=fecha;
    this.diagnostico=diagnostico;
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
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

 
    
    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    /**
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }
    
}