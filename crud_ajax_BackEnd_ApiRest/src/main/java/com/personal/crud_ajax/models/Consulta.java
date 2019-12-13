package com.personal.crud_ajax.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Consulta
 */
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;

    private String diagnostico;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Paciente paciente;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "consulta",cascade = CascadeType.ALL)
    private List<DetallesConsulta> detallesConsultas;

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
     * @param detallesConsultas the detallesConsultas to set
     */
    public void setDetallesConsultas(List<DetallesConsulta> detallesConsultas) {
        this.detallesConsultas = detallesConsultas;
    }
    /**
     * @return the detallesConsultas
     */
    public List<DetallesConsulta> getDetallesConsultas() {
        return detallesConsultas;
    }
    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

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