package com.barvegas.backend.Service;

import com.barvegas.backend.Model.MyUserPrincipal;
import com.barvegas.backend.Model.User;
import com.barvegas.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByNameEquals(login);
            return new MyUserPrincipal(user);
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException("Usuario " + login + " nao encontrado.", e);
        }
    }
}
