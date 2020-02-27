package com.example.eventmanager.event_manager.repository;


import com.example.eventmanager.event_manager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends JpaRepository<Usuario,String>{

    
}