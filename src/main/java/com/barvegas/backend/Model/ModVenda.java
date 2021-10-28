package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_VENDA")
public class ModVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVenda;
    private String data;
    @ManyToOne
    private ModProduto produtos;
    private Long qtd;
    private Double valorTotal;
    private String descricao;
    private Boolean pago;

}