package com.example.eventmanager.event_manager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



/**
 * Convidado
 */
@Entity
public class Convidado  implements Serializable{

   
    private static final long serialVersionUID = 1L;
   
    @Id
    @NotEmpty
    @Min(5)
    private String rg;

    @NotEmpty
    @Size(min=2, max=40)
    private String nome;
    
    @ManyToOne
    private Evento evento;


    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }


    

}