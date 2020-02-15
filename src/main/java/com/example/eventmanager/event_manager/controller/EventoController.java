package com.example.eventmanager.event_manager.controller;

import java.util.List;

import com.example.eventmanager.event_manager.model.Evento;
import com.example.eventmanager.event_manager.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * EventoController
 */
@Controller
public class EventoController {

    @Autowired
    private EventoRepository repository;

    @GetMapping("/cadastrarEvento" )
    public String form() {
        return "evento/formEvento";
    }

    @PostMapping("/cadastrarEvento")
    public String form(Evento evento) {
        repository.save(evento);
        return "evento/formEvento";
    }

   @GetMapping("/evento" )
    public ModelAndView listaEventos(){
        ModelAndView model = new ModelAndView("index");
        List<Evento> eventos = repository.findAll();
        model.addObject("eventos", eventos);
        return model;
    }

    
   @GetMapping("/evento/{codigo}" )
   public ModelAndView detatlheEvento(@PathVariable("codigo") long id){
       ModelAndView model = new ModelAndView("evento/detalhesEvento");
       Evento evento = repository.findById(id).get();
       model.addObject("evento", evento);
       return model;
   }


}