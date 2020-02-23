package com.example.eventmanager.event_manager.controller;

import javax.validation.Valid;

import com.example.eventmanager.event_manager.model.Convidado;
import com.example.eventmanager.event_manager.model.Evento;
import com.example.eventmanager.event_manager.repository.ConvidadoRepository;
import com.example.eventmanager.event_manager.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * EventoController
 */
@Controller
public class ConvidadoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ConvidadoRepository convidadoRepository;


    //Sempre sera chamado para esse controle
    @ModelAttribute
    void supplyModel(@PathVariable("id") long id, Model model) {
        Evento evento = eventoRepository.findById(id).get();
        model.addAttribute("evento", evento);
        model.addAttribute("convidados", evento.getConvidados());
        model.addAttribute("convidado", new Convidado());
    }

    @GetMapping("/evento/{id}")
    public String detatlheEvento(@PathVariable("id") final long id, Model model) {
        return "evento/detalhesEvento";
    }

    @PostMapping("/evento/{id}")
    public String cadastrarConvidado(@PathVariable("id") final long id, @Valid Convidado convidado,
            final BindingResult bindingResult, RedirectAttributes attributes) {

        final Evento evento = eventoRepository.findById(id).get();

        if (bindingResult.hasErrors()) {
            return "evento/detalhesEvento";
        } else {
            attributes.addFlashAttribute("sucesso", "true");
            convidado.setEvento(evento);
            convidadoRepository.save(convidado);
            return "redirect:/evento/{id}";
        }

    }

                  
    @GetMapping("/removerConvidado/{id}/{idConvidado}")
    public String removerConvidado(@PathVariable long id, @PathVariable long idConvidado) {
        Convidado convidado = convidadoRepository.findById(idConvidado).get();
        convidadoRepository.delete(convidado);
        return "redirect:/evento/{id}";
    }

}