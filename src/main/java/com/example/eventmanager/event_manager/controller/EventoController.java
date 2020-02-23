package com.example.eventmanager.event_manager.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.eventmanager.event_manager.model.Evento;
import com.example.eventmanager.event_manager.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



/**
 * EventoController
 */
@Controller
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

  
    @GetMapping("/cadastrarEvento")
    public String form(Model model) 
    {
        model.addAttribute("evento", new Evento());
        return "evento/formEvento";
    }

    @PostMapping("/cadastrarEvento")
    public String form(final @Valid Evento evento,  final BindingResult bindingResult, RedirectAttributes attributes) {
        
        if (bindingResult.hasErrors()) {
            return "/evento/formEvento";
        }
        else
        {
            eventoRepository.save(evento);
            attributes.addFlashAttribute("sucesso", "true");
            return "redirect:/cadastrarEvento";
        }
    }


    @GetMapping("/removerEvento/{id}")
    public String remover(@PathVariable long id)
    {
        Evento evento = eventoRepository.findById(id).get();
        eventoRepository.delete(evento);
        return "redirect:/evento";
    }

    @GetMapping("/evento")
    public ModelAndView listaEventos() {
        final ModelAndView model = new ModelAndView("index");
        final List<Evento> eventos = eventoRepository.findAll();
        model.addObject("eventos", eventos);
        return model;
    }

  

}