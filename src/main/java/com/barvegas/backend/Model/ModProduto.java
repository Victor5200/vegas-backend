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