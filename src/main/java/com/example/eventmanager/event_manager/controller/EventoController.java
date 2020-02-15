package com.example.eventmanager.event_manager.controller;

import java.util.List;

import com.example.eventmanager.event_manager.model.Convidado;
import com.example.eventmanager.event_manager.model.Evento;
import com.example.eventmanager.event_manager.repository.ConvidadoRepository;
import com.example.eventmanager.event_manager.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * EventoController
 */
@Controller
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @GetMapping("/cadastrarEvento")
    public String form() {
        return "evento/formEvento";
    }

    @PostMapping("/cadastrarEvento")
    public String form(Evento evento) {
        eventoRepository.save(evento);
        return "evento/formEvento";
    }

    @GetMapping("/evento")
    public ModelAndView listaEventos() {
        ModelAndView model = new ModelAndView("index");
        List<Evento> eventos = eventoRepository.findAll();
        model.addObject("eventos", eventos);
        return model;
    }

    @GetMapping("/evento/{codigo}")
    public ModelAndView detatlheEvento(@PathVariable("codigo") long id) {
        ModelAndView model = new ModelAndView("evento/detalhesEvento");
        Evento evento = eventoRepository.findById(id).get();
        model.addObject("evento", evento);
        return model;
    }

    @PostMapping("/evento/{codigo}")
    public String cadastrarConvidado(@PathVariable("codigo") long codigo, Convidado convidado) {
       Evento evento = eventoRepository.findById(codigo).get();
        convidado.setEvento(evento);
        convidadoRepository.save(convidado);
        return "redirect:/evento/{codigo}";
    }

}