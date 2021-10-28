package com.barvegas.backend.Repository;

import com.barvegas.backend.Model.ModProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepProduto extends JpaRepository<ModProduto,Long> {
}
