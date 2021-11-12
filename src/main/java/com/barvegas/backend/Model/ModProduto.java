package com.barvegas.backend.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PRODUTO")
public class ModProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProduto;

    private String nome;

    @Column(precision = 5, scale = 2)
    private BigDecimal valorVenda;

    @Column(precision = 5, scale = 2)
    private BigDecimal valorCusto;

    private String fornecedor;

    private Long quantidade;

}
