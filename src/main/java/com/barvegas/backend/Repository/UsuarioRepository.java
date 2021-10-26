package com.barvegas.backend.Repository;

import com.barvegas.backend.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,String> {

    UsuarioModel findByLogin(String login);
}
