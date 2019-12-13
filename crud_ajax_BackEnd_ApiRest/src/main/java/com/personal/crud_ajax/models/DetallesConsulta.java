package com.personal.crud_ajax.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DetallesConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sintoma;

    @ManyToOne(fetch = FetchType.EAGER)
    private Consulta consulta;
    
    //SETTERS Y GETTERS

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Consulta getConsulta() {
        return consulta;
    }
}