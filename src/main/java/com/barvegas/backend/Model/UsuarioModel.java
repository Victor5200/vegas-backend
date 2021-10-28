package com.barvegas.backend.Model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;


@Data
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel implements UserDetails {

    @Id
    @Column(nullable = false,length = 50)
    private String login;
    @Column(nullable = false, length = 100)
    private String senha;

//    @ManyToMany
//    @JoinTable(name = "usuario_roles", joinColumns = @JoinColumn(
//            name = "usuario_id",referencedColumnName = "login"),
//            inverseJoinColumns = @JoinColumn(name = "role_id",
//                    referencedColumnName = "nomeRole"
//    ))
    //private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
