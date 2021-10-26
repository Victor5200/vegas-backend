package com.barvegas.backend.Model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Role implements GrantedAuthority {

    @Id
    private String nomeRole;

    @ManyToMany
    private List<UsuarioModel> usuarioModelList;

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
}
