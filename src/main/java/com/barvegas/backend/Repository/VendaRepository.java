package com.barvegas.backend.Repository;

import com.barvegas.backend.Model.VendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaModel,Long> {
}
