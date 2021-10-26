package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProdutoModel {


    private String nome;

    @Id
    private Long codigoProduto;

    private Float valorVenda;

    private Float precoCusto;
    
    private String fornecedor;
}
