package com.example.eventmanager.event_manager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

/**
 * Evento
 */

 @Entity
public class Evento implements Serializable{

    private static final long serialVersionUID = 1L;
  
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotEmpty
    private String  nome;

    @NotEmpty
    private String local;

    @NotEmpty
    private String data;
    
    @NotEmpty
    private String horario;

    @OneToMany(mappedBy = "evento")
    private List<Convidado> convidados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Convidado> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<Convidado> convidados) {
        this.convidados = convidados;
    }

    @Override
    public String toString() {
        return "Evento [convidados=" + convidados + ", data=" + data + ", horario=" + horario + ", id=" + id
                + ", local=" + local + ", nome=" + nome + "]";
    }

    
}