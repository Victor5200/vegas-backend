package com.barvegas.backend.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(precision = 5, scale = 2,nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal valorVenda;

    @Column(precision = 5, scale = 2,nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal valorCusto;

    @Column
    private String fornecedor;

    @Column(nullable = false)
    private Long quantidade;

}
