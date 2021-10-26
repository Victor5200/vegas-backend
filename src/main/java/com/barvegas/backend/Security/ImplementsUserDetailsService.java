package com.barvegas.backend.Security;

import com.barvegas.backend.Model.UsuarioModel;
import com.barvegas.backend.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UsuarioModel usuario = usuarioRepository.findByLogin(login);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuário não encontrato");
        }
        return usuario;
    }
}
