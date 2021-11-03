package com.barvegas.backend.Repository;

import com.barvegas.backend.Model.ModItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepItens extends JpaRepository<ModItems,Long> {

}
