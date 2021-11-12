package com.barvegas.backend.Repository;

import com.barvegas.backend.Model.ModVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RepVenda extends JpaRepository<ModVenda,Long>{

    @Query("SELECT v FROM ModVenda v WHERE v.membro.id = ?1 AND v.pago is null")
    ModVenda findModVendaByCliente_Id(Long id );

    @Query("SELECT v FROM ModVenda v WHERE v.membro is null AND v.pago is null")
    List<ModVenda> retornaTodasAsComandasDoDia();
}

