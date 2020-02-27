package com.example.eventmanager.event_manager.security;

import com.example.eventmanager.event_manager.model.Usuario;
import com.example.eventmanager.event_manager.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserDetailsServiceImpl
 */
@Repository
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UsuarioRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = ur.findById(username).get();

        if(usuario == null)
            throw new UsernameNotFoundException("Usuário não cadastrado!");
        
        return new User(usuario.getUsername(),usuario.getPassword(), true, true, true, true, usuario.getAuthorities());

    }

    
}