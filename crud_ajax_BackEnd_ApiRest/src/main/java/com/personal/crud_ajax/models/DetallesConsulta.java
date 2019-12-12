package com.personal.crud_ajax.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * DetallesConsulta
 */
@Entity
public class DetallesConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sintoma;

    @ManyToOne(fetch = FetchType.EAGER)
    private Consulta consulta;
    
    //SETTERS Y GETTERS
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
     * @param sintoma the sintoma to set
     */
    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }
    /**
     * @return the sintoma
     */
    public String getSintoma() {
        return sintoma;
    }
    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    /**
     * @return the consulta
     */
    public Consulta getConsulta() {
        return consulta;
    }
}