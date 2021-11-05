package com.barvegas.backend.Repository;

import com.barvegas.backend.Model.ModCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepCliente extends JpaRepository<ModCliente,Long> {
}
