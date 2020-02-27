package com.example.eventmanager.event_manager.repository;

import com.example.eventmanager.event_manager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UsuarioRepository
 */
public interface RoleRepository extends JpaRepository<Role,String>{

    
}