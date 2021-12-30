package com.barvegas.backend.Repository;

import com.barvegas.backend.Model.ModCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepCompras extends JpaRepository<ModCompras, Long> {
}
