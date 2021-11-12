package com.barvegas.backend.Repository;

import com.barvegas.backend.Model.ModVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RepVenda extends JpaRepository<ModVenda,Long>{

    @Query("SELECT v FROM ModVenda v WHERE v.cliente.id = ?1 AND v.data = ?2")
    ModVenda findModVendaByCliente_Id(Long id, LocalDate data);

    @Query("SELECT v FROM ModVenda v WHERE v.cliente is null AND v.data = ?1")
    List<ModVenda> retornaTodasAsComandasDoDia(LocalDate data);
}

