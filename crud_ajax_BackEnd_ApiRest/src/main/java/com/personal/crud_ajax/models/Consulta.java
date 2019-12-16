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

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Consulta
 */
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
 
    public void setDetallesConsultas(List<DetallesConsulta> detallesConsultas) {
        this.detallesConsultas = detallesConsultas;
    }
 
    public List<DetallesConsulta> getDetallesConsultas() {
        return detallesConsultas;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
 
    public Date getFecha() {
        return fecha;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

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