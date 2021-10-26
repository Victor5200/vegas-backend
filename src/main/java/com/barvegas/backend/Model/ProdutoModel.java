package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoProduto;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 10)
    private Float valorVenda;

    @Column(nullable = false, length = 10)
    private Float precoCusto;

    @Column(nullable = true, length = 20)
    private String fornecedor;
}
