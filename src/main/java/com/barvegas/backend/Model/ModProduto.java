package com.barvegas.backend.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ModProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduto;
    private String nome;
    private Double valorVenda;
    private Double valorCusto;
    private String fornecedor;
    private Long quantidade;



}