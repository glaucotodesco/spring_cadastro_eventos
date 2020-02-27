package com.example.eventmanager.event_manager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

/**
 * Role
 */
@Entity
public class Role implements GrantedAuthority{


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String roleName;
    

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    @Override
    public String getAuthority() {
       return this.roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    
}