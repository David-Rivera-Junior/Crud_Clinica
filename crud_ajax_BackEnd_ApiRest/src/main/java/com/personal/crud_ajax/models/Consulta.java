package com.personal.crud_ajax.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Consulta
 */
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    private String sintomas;

    private String diagnostico;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Paciente paciente;

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

 //CONSTRUCTORES
    public Consulta() {
        super();
    }
    public Consulta(Date fecha, String sintomas, String diagnostico) {
    this.fecha=fecha;
    this.sintomas=sintomas;
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
     * @param sintomas the sintomas to set
     */
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }
    /**
     * @return the sintomas
     */
    public String getSintomas() {
        return sintomas;
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