package com.example.eventmanager.event_manager.repository;

import com.example.eventmanager.event_manager.model.Evento;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * EventoRepository
 */
public interface EventoRepository extends JpaRepository<Evento,Long>{

    
}